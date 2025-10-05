package com.vocadesk;

import org.vosk.Model;
import org.vosk.Recognizer;
import org.json.JSONObject;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * VoiceLauncher - Console version of offline voice-controlled application launcher
 * Uses Vosk for fully offline speech recognition
 * No internet connection required!
 */
public class VoiceLauncher {
    
    private AppLauncher appLauncher;
    private Model model;
    private Recognizer recognizer;
    private TargetDataLine microphone;
    private boolean isRunning;
    
    // Path to Vosk model
    private static final String MODEL_PATH = "model";
    
    /**
     * Constructor - Initialize the voice launcher
     */
    public VoiceLauncher() {
        // Initialize AppLauncher with apps.json in project root
        this.appLauncher = new AppLauncher("apps.json");
        this.isRunning = true;
        
        // Initialize Vosk speech recognizer
        initializeSpeechRecognizer();
    }
    
    /**
     * Initialize Vosk for offline speech recognition
     * Uses local model files (fully offline)
     */
    private void initializeSpeechRecognizer() {
        try {
            System.out.println("[INFO] Initializing Vosk speech recognition...");
            
            // Load Vosk model from local directory
            model = new Model(MODEL_PATH);
            
            // Setup audio format (16kHz, 16-bit, mono)
            AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            
            // Get microphone
            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            
            // Create recognizer
            recognizer = new Recognizer(model, 16000);
            
            System.out.println("[SUCCESS] Speech recognition initialized (offline mode)");
            System.out.println("[INFO] Using Vosk - High accuracy offline recognition");
            
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to initialize speech recognizer: " + e.getMessage());
            System.err.println("[INFO] Make sure 'model' folder exists in project root");
            System.err.println("[INFO] Download model from: https://alphacephei.com/vosk/models");
            System.exit(1);
        }
    }
    
    /**
     * Start listening for voice commands
     * This is the main loop that processes voice input
     */
    public void startListening() {
        System.out.println("\n========================================");
        System.out.println("  VOcadesk - Offline Voice Launcher");
        System.out.println("  Console Version");
        System.out.println("========================================");
        System.out.println("Loaded " + appLauncher.getAppCount() + " applications");
        System.out.println("\nAvailable commands:");
        System.out.println("  - 'open [app name]' - Launch an application");
        System.out.println("  - 'exit' or 'quit' - Close VOcadesk");
        System.out.println("\nListening for commands...\n");
        
        // Start microphone
        microphone.start();
        
        byte[] buffer = new byte[4096];
        
        // Main listening loop
        while (isRunning) {
            try {
                // Read audio data from microphone
                int bytesRead = microphone.read(buffer, 0, buffer.length);
                
                if (bytesRead > 0) {
                    // Process audio with Vosk
                    if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                        // Get final result
                        String result = recognizer.getResult();
                        JSONObject json = new JSONObject(result);
                        String text = json.getString("text");
                        
                        if (!text.isEmpty()) {
                            System.out.println("[HEARD] " + text);
                            processCommand(text);
                        }
                    }
                }
                
            } catch (Exception e) {
                System.err.println("[ERROR] Error processing speech: " + e.getMessage());
            }
        }
        
        // Stop microphone and cleanup
        microphone.stop();
        microphone.close();
        model.close();
        
        System.out.println("\n[INFO] VOcadesk stopped. Goodbye!");
    }
    
    /**
     * Process voice commands and trigger appropriate actions
     * @param command The recognized voice command
     */
    private void processCommand(String command) {
        // Normalize command to lowercase for easier matching
        String normalizedCommand = command.toLowerCase().trim();
        
        // Check for exit command
        if (normalizedCommand.equals("exit") || 
            normalizedCommand.equals("quit") || 
            normalizedCommand.equals("close") ||
            normalizedCommand.equals("stop")) {
            
            System.out.println("[ACTION] Exiting VOcadesk...");
            isRunning = false;
            return;
        }
        
        // Check for "open [app]" command
        if (normalizedCommand.startsWith("open ")) {
            // Extract app name after "open "
            String appName = normalizedCommand.substring(5).trim();
            
            if (appName.isEmpty()) {
                System.out.println("[ERROR] No application name specified");
                return;
            }
            
            // Try to launch the application
            System.out.println("[ACTION] Attempting to open: " + appName);
            boolean success = appLauncher.launchApp(appName);
            
            if (!success) {
                System.out.println("[HINT] Available apps: " + String.join(", ", appLauncher.getAppNames()));
            }
            
            return;
        }
        
        // Check for "launch [app]" command (alternative)
        if (normalizedCommand.startsWith("launch ")) {
            String appName = normalizedCommand.substring(7).trim();
            
            if (!appName.isEmpty()) {
                System.out.println("[ACTION] Attempting to launch: " + appName);
                boolean success = appLauncher.launchApp(appName);
                
                if (!success) {
                    System.out.println("[HINT] Available apps: " + String.join(", ", appLauncher.getAppNames()));
                }
            }
            
            return;
        }
        
        // Check for "start [app]" command (alternative)
        if (normalizedCommand.startsWith("start ")) {
            String appName = normalizedCommand.substring(6).trim();
            
            if (!appName.isEmpty()) {
                System.out.println("[ACTION] Attempting to start: " + appName);
                boolean success = appLauncher.launchApp(appName);
                
                if (!success) {
                    System.out.println("[HINT] Available apps: " + String.join(", ", appLauncher.getAppNames()));
                }
            }
            
            return;
        }
        
        // Check for "list apps" or "show apps" command
        if (normalizedCommand.contains("list") || normalizedCommand.contains("show")) {
            System.out.println("[INFO] Available applications:");
            for (String appName : appLauncher.getAppNames()) {
                System.out.println("  - " + appName);
            }
            return;
        }
        
        // Check for "help" command
        if (normalizedCommand.contains("help")) {
            System.out.println("[HELP] Available commands:");
            System.out.println("  - 'open [app]' - Launch an application");
            System.out.println("  - 'list apps' - Show all available apps");
            System.out.println("  - 'exit' - Close VOcadesk");
            return;
        }
        
        // Unknown command
        System.out.println("[WARNING] Command not recognized. Say 'help' for available commands.");
    }
    
    /**
     * Main entry point for the application
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Create and start the voice launcher
            VoiceLauncher launcher = new VoiceLauncher();
            launcher.startListening();
            
        } catch (Exception e) {
            System.err.println("[FATAL ERROR] " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
