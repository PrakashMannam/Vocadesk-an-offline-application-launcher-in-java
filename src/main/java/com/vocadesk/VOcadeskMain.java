package com.vocadesk;

import javax.swing.*;

/**
 * VOcadeskMain - Main entry point for VOcadesk application
 * Launches the GUI version of the offline voice-controlled application launcher
 */
public class VOcadeskMain {
    
    /**
     * Main entry point for the application
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Set system look and feel for better native appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // If setting look and feel fails, use default
            System.err.println("[WARNING] Could not set system look and feel: " + e.getMessage());
        }
        
        // Run GUI on Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(() -> {
            try {
                System.out.println("========================================");
                System.out.println("  VOcadesk - Offline Voice Launcher");
                System.out.println("  GUI Version");
                System.out.println("========================================");
                System.out.println();
                
                // Initialize AppLauncher with apps.json
                System.out.println("[INFO] Loading applications from apps.json...");
                AppLauncher appLauncher = new AppLauncher("apps.json");
                
                // Create and show GUI
                System.out.println("[INFO] Initializing GUI...");
                VocadeskGUI gui = new VocadeskGUI(appLauncher);
                
                System.out.println("[SUCCESS] VOcadesk GUI launched successfully");
                System.out.println("[INFO] Click 'Start Voice Recognition' to begin");
                System.out.println();
                
            } catch (Exception e) {
                System.err.println("[FATAL ERROR] Failed to start VOcadesk: " + e.getMessage());
                e.printStackTrace();
                
                // Show error dialog
                JOptionPane.showMessageDialog(
                    null,
                    "Failed to start VOcadesk:\n" + e.getMessage() +
                    "\n\nPlease check:\n" +
                    "1. apps.json exists in project root\n" +
                    "2. Maven dependencies are installed\n" +
                    "3. Microphone is connected",
                    "VOcadesk Error",
                    JOptionPane.ERROR_MESSAGE
                );
                
                System.exit(1);
            }
        });
    }
}
