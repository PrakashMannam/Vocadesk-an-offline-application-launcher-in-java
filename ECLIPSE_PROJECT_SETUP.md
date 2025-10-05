# Eclipse Project Structure Setup Guide

## 🎯 Complete Step-by-Step Guide

This guide shows you how to create and set up the VOcadesk project structure in Eclipse from scratch.

---

## Method 1: Import Existing Project (Recommended - Fastest)

### The project files are already created! Just import them:

1. **Open Eclipse**

2. **Import the Project:**
   - Go to **File → Import**
   - Expand **Maven**
   - Select **Existing Maven Projects**
   - Click **Next**

3. **Browse to Project:**
   - Click **Browse**
   - Navigate to: `C:\Users\praka\eclipse-workspace\VOcadesk`
   - Click **Select Folder**

4. **Verify and Import:**
   - You should see `/pom.xml` checked
   - Click **Finish**

5. **Wait for Maven:**
   - Eclipse will automatically:
     - Create the project structure
     - Download dependencies
     - Build the project
   - Watch the progress bar (bottom-right)

6. **Verify Structure:**
   - Your project should now appear in Project Explorer
   - Expand it to see the structure

**That's it! Skip to "Verify Project Structure" section below.**

---

## Method 2: Create Project from Scratch (Manual)

### If you want to create the project manually:

### Step 1: Create Maven Project

1. **Open Eclipse**

2. **Create New Maven Project:**
   - Go to **File → New → Project**
   - Expand **Maven**
   - Select **Maven Project**
   - Click **Next**

3. **Configure Project Location:**
   - ✅ Check **Create a simple project (skip archetype selection)**
   - Location: `C:\Users\praka\eclipse-workspace`
   - Click **Next**

4. **Enter Project Details:**
   - **Group Id:** `com.vocadesk`
   - **Artifact Id:** `vocadesk`
   - **Version:** `1.0.0`
   - **Packaging:** `jar`
   - **Name:** `VOcadesk`
   - **Description:** `Fully Offline Voice-Controlled Application Launcher`
   - Click **Finish**

### Step 2: Create Package Structure

1. **Expand Project in Project Explorer:**
   ```
   VOcadesk
   └── src/main/java
   ```

2. **Create Package:**
   - Right-click on **src/main/java**
   - Select **New → Package**
   - Name: `com.vocadesk`
   - Click **Finish**

### Step 3: Add Java Classes

**Create each class by:**
- Right-click on **com.vocadesk** package
- Select **New → Class**
- Enter class name
- Click **Finish**
- Copy-paste the code from the generated files

**Classes to create:**
1. `VOcadeskMain.java` - Main entry point
2. `VocadeskGUI.java` - GUI interface
3. `VoiceRecognitionController.java` - Voice controller
4. `AppLauncher.java` - App manager
5. `VoiceLauncher.java` - Console version

### Step 4: Add Configuration Files

1. **Add pom.xml:**
   - Right-click on **VOcadesk** project root
   - Select **New → File**
   - Name: `pom.xml`
   - Click **Finish**
   - Copy-paste content from generated `pom.xml`

2. **Add apps.json:**
   - Right-click on **VOcadesk** project root
   - Select **New → File**
   - Name: `apps.json`
   - Click **Finish**
   - Copy-paste content from generated `apps.json`

### Step 5: Update Maven Project

1. Right-click on **VOcadesk** project
2. Select **Maven → Update Project**
3. Check **Force Update of Snapshots/Releases**
4. Click **OK**
5. Wait for dependencies to download

---

## 📁 Expected Project Structure in Eclipse

After setup, your Project Explorer should show:

```
VOcadesk
├── src/main/java
│   └── com.vocadesk
│       ├── VOcadeskMain.java
│       ├── VocadeskGUI.java
│       ├── VoiceRecognitionController.java
│       ├── AppLauncher.java
│       └── VoiceLauncher.java
├── src/main/resources
│   └── (empty - models are in sphinx4-data JAR)
├── src/test/java
│   └── (empty)
├── JRE System Library [JavaSE-17]
├── Maven Dependencies
│   ├── sphinx4-core-5prealpha-SNAPSHOT.jar
│   ├── sphinx4-data-5prealpha-SNAPSHOT.jar
│   ├── json-20231013.jar
│   ├── slf4j-api-2.0.9.jar
│   ├── slf4j-simple-2.0.9.jar
│   └── (other dependencies)
├── target
│   └── (compiled classes)
├── apps.json
├── pom.xml
├── README.md
├── GUI_GUIDE.md
├── ECLIPSE_SETUP.md
└── QUICK_START.txt
```

---

## ✅ Verify Project Structure

### Check 1: Java Files

Expand **src/main/java → com.vocadesk**

You should see:
- ✅ VOcadeskMain.java
- ✅ VocadeskGUI.java
- ✅ VoiceRecognitionController.java
- ✅ AppLauncher.java
- ✅ VoiceLauncher.java

### Check 2: Maven Dependencies

Expand **Maven Dependencies**

You should see:
- ✅ sphinx4-core-5prealpha-SNAPSHOT.jar
- ✅ sphinx4-data-5prealpha-SNAPSHOT.jar
- ✅ json-20231013.jar
- ✅ slf4j-api-2.0.9.jar
- ✅ slf4j-simple-2.0.9.jar

**If missing:** Right-click project → Maven → Update Project

### Check 3: Configuration Files

At project root level, you should see:
- ✅ apps.json
- ✅ pom.xml
- ✅ README.md
- ✅ GUI_GUIDE.md

### Check 4: No Errors

- ❌ No red X on project name
- ❌ No red X on Java files
- ✅ All imports resolve correctly

**If you see errors:**
1. Right-click project → **Maven → Update Project**
2. **Project → Clean** → Select VOcadesk → Clean
3. Right-click project → **Refresh** (F5)

---

## 🔧 Common Project Structure Issues

### Issue 1: "src/main/java" folder doesn't exist

**Solution:**
1. Right-click on **VOcadesk** project
2. Select **New → Source Folder**
3. Folder name: `src/main/java`
4. Click **Finish**

### Issue 2: Package "com.vocadesk" not showing

**Solution:**
1. Right-click on **src/main/java**
2. Select **New → Package**
3. Name: `com.vocadesk`
4. Click **Finish**

### Issue 3: Maven Dependencies folder is empty

**Solution:**
1. Check internet connection
2. Right-click project → **Maven → Update Project**
3. Check **Force Update of Snapshots/Releases**
4. Click **OK**
5. Wait 2-5 minutes for downloads

### Issue 4: "Maven Dependencies" folder not visible

**Solution:**
1. Right-click on project → **Properties**
2. Go to **Java Build Path → Libraries**
3. You should see **Maven Dependencies**
4. If not: Right-click project → **Maven → Update Project**

### Issue 5: apps.json not at root level

**Solution:**
- Drag and drop `apps.json` to project root
- Or: Right-click project root → New → File → Name: `apps.json`

### Issue 6: Red X on project after import

**Solution:**
1. Check **Problems** tab at bottom
2. Common fixes:
   - Right-click project → **Maven → Update Project**
   - **Project → Clean** → Clean
   - Right-click project → **Refresh** (F5)

---

## 🎨 Eclipse Views to Open

### Essential Views:

1. **Project Explorer** (Left side)
   - Window → Show View → Project Explorer

2. **Console** (Bottom)
   - Window → Show View → Console

3. **Problems** (Bottom)
   - Window → Show View → Problems

4. **Outline** (Right side - optional)
   - Window → Show View → Outline

### Recommended Layout:

```
┌─────────────────────────────────────────────────────┐
│  Menu Bar                                           │
├──────────────┬──────────────────────┬───────────────┤
│              │                      │               │
│  Project     │   Code Editor        │   Outline     │
│  Explorer    │                      │   (optional)  │
│              │                      │               │
│              │                      │               │
├──────────────┴──────────────────────┴───────────────┤
│  Console / Problems / Terminal                      │
└─────────────────────────────────────────────────────┘
```

---

## 🚀 Running the Project

### After Structure is Set Up:

1. **Locate Main Class:**
   - Expand: **src/main/java → com.vocadesk**
   - Find: **VOcadeskMain.java**

2. **Run the Application:**
   - Right-click on **VOcadeskMain.java**
   - Select **Run As → Java Application**

3. **GUI Window Appears:**
   - Click **"Start Voice Recognition"**
   - Say **"open calculator"**
   - Calculator should launch!

---

## 📋 Project Structure Checklist

Before running, verify:

- ✅ Eclipse IDE installed
- ✅ JDK 17+ configured
- ✅ Maven plugin (m2e) installed
- ✅ Project imported/created
- ✅ Package `com.vocadesk` exists
- ✅ All 5 Java classes present
- ✅ `pom.xml` at project root
- ✅ `apps.json` at project root
- ✅ Maven Dependencies downloaded
- ✅ No red X errors
- ✅ Microphone connected
- ✅ Ready to run!

---

## 🎓 Understanding the Structure

### Maven Standard Directory Layout:

```
VOcadesk/
├── src/
│   ├── main/
│   │   ├── java/           ← Java source code
│   │   │   └── com/
│   │   │       └── vocadesk/
│   │   └── resources/      ← Resources (empty for us)
│   └── test/
│       ├── java/           ← Test code (empty)
│       └── resources/      ← Test resources (empty)
├── target/                 ← Compiled output (auto-generated)
├── pom.xml                 ← Maven configuration
└── apps.json               ← Our app configuration
```

### Why This Structure?

- **src/main/java** - Standard Maven location for source code
- **com.vocadesk** - Java package naming convention (reverse domain)
- **Maven Dependencies** - External libraries managed by Maven
- **target/** - Build output (ignored by Git)

---

## 🔄 Refreshing Project Structure

If you make changes outside Eclipse:

1. **Refresh Project:**
   - Right-click on **VOcadesk** project
   - Select **Refresh** (or press **F5**)

2. **Update Maven:**
   - Right-click on **VOcadesk** project
   - Select **Maven → Update Project**

3. **Clean Build:**
   - Go to **Project → Clean**
   - Select **VOcadesk**
   - Click **Clean**

---

## 📦 Exporting Project Structure

### To share with others:

1. **Export as Archive:**
   - Right-click on **VOcadesk** project
   - Select **Export → General → Archive File**
   - Choose location
   - Click **Finish**

2. **Export to Git:**
   - Right-click on **VOcadesk** project
   - Select **Team → Share Project**
   - Choose **Git**
   - Follow wizard

---

## 🎯 Quick Commands

### Keyboard Shortcuts:

- **F5** - Refresh project
- **Ctrl + Shift + O** - Organize imports
- **Ctrl + Shift + F** - Format code
- **Ctrl + F11** - Run last launched
- **Alt + Shift + X, J** - Run as Java Application

### Right-Click Menu:

- **Maven → Update Project** - Update dependencies
- **Run As → Java Application** - Run the program
- **Refresh** - Refresh from file system
- **Properties** - View project settings

---

## ✨ You're All Set!

Your project structure is now ready. To run:

1. Open **VOcadeskMain.java**
2. Right-click → **Run As → Java Application**
3. Click **"Start Voice Recognition"** in the GUI
4. Say **"open calculator"**

**Happy coding! 🚀**
