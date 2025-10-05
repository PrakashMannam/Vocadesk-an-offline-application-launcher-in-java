package com.vocadesk;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * AppLauncher - Manages loading applications from JSON and launching them
 * This class is fully offline and reads from a local apps.json file
 */
public class AppLauncher {
    
    // Store app name -> path mapping
    private Map<String, String> applications;
    private String jsonFilePath;
    
    /**
     * Constructor - Initialize the AppLauncher with path to apps.json
     * @param jsonFilePath Path to the apps.json configuration file
     */
    public AppLauncher(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        this.applications = new HashMap<>();
        loadApplications();
    }
    
    /**
     * Load applications from the JSON file into memory
     * Format: [{"name": "Calculator", "path": "C:/Windows/System32/calc.exe"}, ...]
     */
    private void loadApplications() {
        try {
            // Read JSON file content
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray appsArray = new JSONArray(jsonContent);
            
            // Parse each application entry
            for (int i = 0; i < appsArray.length(); i++) {
                JSONObject app = appsArray.getJSONObject(i);
                String name = app.getString("name").toLowerCase(); // Store in lowercase for easy matching
                String path = app.getString("path");
                applications.put(name, path);
                System.out.println("[INFO] Loaded app: " + name + " -> " + path);
            }
            
            System.out.println("[SUCCESS] Loaded " + applications.size() + " applications from " + jsonFilePath);
            
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read apps.json: " + e.getMessage());
            System.err.println("[INFO] Make sure apps.json exists in the project root folder");
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to parse apps.json: " + e.getMessage());
        }
    }
    
    /**
     * Launch an application by name
     * @param appName Name of the application to launch (case-insensitive)
     * @return true if launched successfully, false otherwise
     */
    public boolean launchApp(String appName) {
        // Normalize the app name to lowercase
        String normalizedName = appName.toLowerCase().trim();
        
        // Check if app exists in our registry
        if (!applications.containsKey(normalizedName)) {
            System.err.println("[ERROR] Application '" + appName + "' not found in apps.json");
            return false;
        }
        
        // Get the application path
        String appPath = applications.get(normalizedName);
        
        try {
            // Launch the application using ProcessBuilder (works offline)
            ProcessBuilder processBuilder = new ProcessBuilder(appPath);
            processBuilder.start();
            System.out.println("[SUCCESS] Launched: " + appName + " (" + appPath + ")");
            return true;
            
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to launch " + appName + ": " + e.getMessage());
            System.err.println("[INFO] Check if the path is correct: " + appPath);
            return false;
        }
    }
    
    /**
     * Check if an application exists in the registry
     * @param appName Name of the application
     * @return true if app exists, false otherwise
     */
    public boolean hasApp(String appName) {
        return applications.containsKey(appName.toLowerCase().trim());
    }
    
    /**
     * Get all registered application names
     * @return Array of application names
     */
    public String[] getAppNames() {
        return applications.keySet().toArray(new String[0]);
    }
    
    /**
     * Reload applications from JSON file (useful if file is updated)
     */
    public void reload() {
        applications.clear();
        loadApplications();
    }
    
    /**
     * Get the number of registered applications
     * @return Number of apps
     */
    public int getAppCount() {
        return applications.size();
    }
}
