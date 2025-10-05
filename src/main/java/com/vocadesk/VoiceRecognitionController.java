package com.vocadesk;

import org.vosk.Model;
import org.vosk.Recognizer;
import org.json.JSONObject;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * VoiceRecognitionController - Simple, working version
 */
public class VoiceRecognitionController {
    
    private AppLauncher appLauncher;
    private VocadeskGUI gui;
    private Model model;
    private Recognizer recognizer;
    private TargetDataLine microphone;
    private volatile boolean isRunning;
    private Thread recognitionThread;
    
    private static final String MODEL_PATH = "model";
    
    public VoiceRecognitionController(AppLauncher appLauncher, VocadeskGUI gui) {
        this.appLauncher = appLauncher;
        this.gui = gui;
        this.isRunning = false;
        
        initializeSpeechRecognizer();
        gui.updateAppList(appLauncher.getAppNames());
    }
    
    private void initializeSpeechRecognizer() {
        try {
            gui.appendLog("[INFO] Initializing Vosk speech recognition...");
            
            model = new Model(MODEL_PATH);
            
            AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            
            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            
            recognizer = new Recognizer(model, 16000);
            
            gui.appendLog("[SUCCESS] Speech recognition initialized (offline mode)");
            gui.appendLog("[INFO] Using Vosk - High accuracy offline recognition");
            
        } catch (Exception e) {
            gui.appendLog("[ERROR] Failed to initialize speech recognizer: " + e.getMessage());
            throw new RuntimeException("Failed to initialize speech recognizer", e);
        }
    }
    
    public void startListening() {
        if (isRunning) {
            gui.appendLog("[WARNING] Voice recognition is already running");
            return;
        }
        
        isRunning = true;
        microphone.start();
        gui.appendLog("[INFO] Microphone activated - speak clearly");
        
        recognitionThread = new Thread(() -> {
            byte[] buffer = new byte[4096];
            
            while (isRunning) {
                try {
                    int bytesRead = microphone.read(buffer, 0, buffer.length);
                    
                    if (bytesRead > 0 && isRunning) {
                        if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                            String result = recognizer.getResult();
                            JSONObject json = new JSONObject(result);
                            String text = json.getString("text");
                            
                            if (!text.isEmpty()) {
                                gui.updateLastCommand(text);
                                gui.appendLog("[HEARD] " + text);
                                processCommand(text);
                            }
                        }
                    }
                    
                } catch (Exception e) {
                    if (isRunning) {
                        gui.appendLog("[ERROR] Error processing speech: " + e.getMessage());
                    }
                }
            }
            
            microphone.stop();
            gui.appendLog("[INFO] Voice recognition stopped");
        });
        
        recognitionThread.setDaemon(true);
        recognitionThread.start();
    }
    
    public void stopListening() {
        isRunning = false;
        
        if (recognitionThread != null && recognitionThread.isAlive()) {
            recognitionThread.interrupt();
        }
    }
    
    private void processCommand(String command) {
        String normalizedCommand = command.toLowerCase().trim();
        
        // Check for exit command
        if (normalizedCommand.equals("exit") || normalizedCommand.equals("quit") || 
            normalizedCommand.equals("close") || normalizedCommand.equals("stop")) {
            gui.appendLog("[ACTION] Exit command received");
            gui.appendLog("[INFO] Please use the GUI to exit the application");
            return;
        }
        
        // Check for browser search
        if (normalizedCommand.contains("search") && 
            (normalizedCommand.contains("chrome") || normalizedCommand.contains("edge") || normalizedCommand.contains("firefox"))) {
            handleBrowserSearch(normalizedCommand);
            return;
        }
        
        // Check for "open [app]" command
        if (normalizedCommand.startsWith("open ")) {
            String appName = normalizedCommand.substring(5).trim();
            
            if (appName.isEmpty()) {
                gui.appendLog("[ERROR] No application name specified");
                return;
            }
            
            // Check if it's a browser with search query
            if ((appName.contains("chrome") || appName.contains("edge") || appName.contains("firefox")) 
                && appName.contains("search")) {
                handleBrowserSearch(appName);
                return;
            }
            
            gui.appendLog("[ACTION] Attempting to open: " + appName);
            boolean success = appLauncher.launchApp(appName);
            
            if (success) {
                gui.appendLog("[SUCCESS] Launched: " + appName);
            } else {
                gui.appendLog("[ERROR] Failed to launch: " + appName);
                gui.appendLog("[HINT] Available apps: " + String.join(", ", appLauncher.getAppNames()));
            }
            
            return;
        }
        
        // Check for "launch [app]" command
        if (normalizedCommand.startsWith("launch ")) {
            String appName = normalizedCommand.substring(7).trim();
            
            if (!appName.isEmpty()) {
                gui.appendLog("[ACTION] Attempting to launch: " + appName);
                boolean success = appLauncher.launchApp(appName);
                
                if (success) {
                    gui.appendLog("[SUCCESS] Launched: " + appName);
                } else {
                    gui.appendLog("[ERROR] Failed to launch: " + appName);
                    gui.appendLog("[HINT] Available apps: " + String.join(", ", appLauncher.getAppNames()));
                }
            }
            
            return;
        }
        
        // Check for "list apps" or "show apps" command
        if (normalizedCommand.contains("list") || normalizedCommand.contains("show")) {
            gui.appendLog("[INFO] Available applications:");
            for (String appName : appLauncher.getAppNames()) {
                gui.appendLog("  • " + appName);
            }
            return;
        }
        
        // Check for "help" command
        if (normalizedCommand.contains("help")) {
            gui.appendLog("[HELP] Available voice commands:");
            gui.appendLog("  • 'open [app]' - Launch an application");
            gui.appendLog("  • 'launch [app]' - Launch an application (alternative)");
            gui.appendLog("  • 'start [app]' - Launch an application (alternative)");
            gui.appendLog("  • 'list apps' - Show all available apps");
            gui.appendLog("  • 'help' - Show this help message");
            gui.appendLog("  • Use the GUI button to stop voice recognition");
            return;
        }
        
        gui.appendLog("[WARNING] Command not recognized: " + command);
        gui.appendLog("[HINT] Say 'help' for available commands");
    }
    
    private void handleBrowserSearch(String command) {
        try {
            String browser = "";
            String searchQuery = "";
            
            if (command.contains("chrome")) {
                browser = "chrome";
            } else if (command.contains("edge")) {
                browser = "edge";
            } else if (command.contains("firefox")) {
                browser = "firefox";
            }
            
            if (command.contains("search for ")) {
                int startIndex = command.indexOf("search for ") + 11;
                searchQuery = command.substring(startIndex).trim();
                searchQuery = searchQuery.replace("in " + browser, "")
                                       .replace("on " + browser, "")
                                       .replace(browser, "").trim();
            } else if (command.contains("search ")) {
                int startIndex = command.indexOf("search ") + 7;
                searchQuery = command.substring(startIndex).trim();
                searchQuery = searchQuery.replace("in " + browser, "")
                                       .replace("on " + browser, "")
                                       .replace(browser, "").trim();
            }
            
            if (searchQuery.isEmpty()) {
                gui.appendLog("[ERROR] No search query specified");
                return;
            }
            
            String encodedQuery = searchQuery.replace(" ", "+");
            String searchUrl = "https://www.google.com/search?q=" + encodedQuery;
            
            gui.appendLog("[ACTION] Opening " + browser.toUpperCase() + " and searching for: " + searchQuery);
            
            Desktop.getDesktop().browse(new URI(searchUrl));
            
            gui.appendLog("[SUCCESS] Opened " + browser.toUpperCase() + " with search results");
            
        } catch (Exception e) {
            gui.appendLog("[ERROR] Failed to open browser: " + e.getMessage());
        }
    }
    
    public void cleanup() {
        stopListening();
        
        try {
            if (recognitionThread != null && recognitionThread.isAlive()) {
                recognitionThread.join(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        if (microphone != null && microphone.isOpen()) {
            microphone.close();
        }
        
        if (model != null) {
            model.close();
        }
        
        gui.appendLog("[INFO] Voice recognition resources cleaned up");
    }
    
    public boolean isRunning() {
        return isRunning;
    }
}
