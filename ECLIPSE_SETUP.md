# Eclipse Setup Guide for VOcadesk

## Prerequisites

### 1. Install Java JDK 17 or Higher

**Check if Java is installed:**
```bash
java -version
```

**If not installed:**
1. Download JDK 17 from: https://www.oracle.com/java/technologies/downloads/#java17
2. Install it
3. Set JAVA_HOME environment variable

### 2. Install Eclipse IDE

**Download Eclipse IDE for Java Developers:**
- URL: https://www.eclipse.org/downloads/
- Choose: **Eclipse IDE for Java Developers** (not Enterprise)
- Install and launch Eclipse

### 3. Install Maven in Eclipse

**Eclipse usually comes with Maven (m2e plugin). To verify:**

1. Open Eclipse
2. Go to **Help → About Eclipse IDE**
3. Click **Installation Details**
4. Look for **Maven Integration for Eclipse (m2e)**

**If Maven is NOT installed:**
1. Go to **Help → Eclipse Marketplace**
2. Search for **"Maven Integration for Eclipse"**
3. Install **m2e - Maven Integration for Eclipse**
4. Restart Eclipse

---

## Step-by-Step Setup in Eclipse

### Step 1: Import the VOcadesk Project

1. **Open Eclipse**

2. **Import the Maven Project:**
   - Go to **File → Import**
   - Expand **Maven** folder
   - Select **Existing Maven Projects**
   - Click **Next**

3. **Browse to Project:**
   - Click **Browse**
   - Navigate to: `C:\Users\praka\eclipse-workspace\VOcadesk`
   - Click **Select Folder**

4. **Verify pom.xml is detected:**
   - You should see `/pom.xml` checked in the Projects list
   - Click **Finish**

5. **Wait for Maven to initialize:**
   - Eclipse will start downloading dependencies
   - Check the progress in the bottom-right corner
   - This may take 2-5 minutes depending on your internet speed

---

### Step 2: Configure Java JDK in Eclipse

1. **Set Project JDK:**
   - Right-click on **VOcadesk** project
   - Select **Properties**
   - Go to **Java Build Path**
   - Click **Libraries** tab
   - If you see JRE System Library [JavaSE-17], you're good!
   
2. **If JDK is not set correctly:**
   - Click **Edit** on JRE System Library
   - Select **Workspace default JRE**
   - Or click **Installed JREs** → **Add** → **Standard VM**
   - Browse to your JDK 17 installation folder
   - Click **Finish** and **Apply**

---

### Step 3: Update Maven Dependencies

**Force Maven to download all dependencies:**

1. Right-click on **VOcadesk** project
2. Select **Maven → Update Project**
3. Check these options:
   - ✅ Force Update of Snapshots/Releases
   - ✅ Update project configuration from pom.xml
   - ✅ Clean projects
4. Click **OK**
5. Wait for Maven to download dependencies (check bottom-right progress)

**Dependencies that will be downloaded:**
- `sphinx4-core` (5prealpha-SNAPSHOT) - ~15 MB
- `sphinx4-data` (5prealpha-SNAPSHOT) - ~50 MB (includes acoustic models)
- `json` (20231013) - ~100 KB
- `slf4j-simple` (2.0.9) - ~20 KB

---

### Step 4: Verify Project Structure

**Your project should look like this in Eclipse:**

```
VOcadesk
├── src/main/java
│   └── com.vocadesk
│       ├── AppLauncher.java
│       └── VoiceLauncher.java
├── src/main/resources (empty - models are in sphinx4-data JAR)
├── src/test/java (empty)
├── JRE System Library [JavaSE-17]
├── Maven Dependencies
│   ├── sphinx4-core-5prealpha-SNAPSHOT.jar
│   ├── sphinx4-data-5prealpha-SNAPSHOT.jar
│   ├── json-20231013.jar
│   ├── slf4j-api-2.0.9.jar
│   ├── slf4j-simple-2.0.9.jar
│   └── (other transitive dependencies)
├── apps.json
├── pom.xml
└── README.md
```

**To verify Maven Dependencies:**
1. Expand **Maven Dependencies** in Project Explorer
2. You should see all the JARs listed above
3. If not, repeat Step 3 (Update Maven)

---

### Step 5: Verify apps.json Location

**CRITICAL:** `apps.json` must be in the project root!

1. In Eclipse Project Explorer, you should see `apps.json` at the root level
2. It should be at: `C:\Users\praka\eclipse-workspace\VOcadesk\apps.json`
3. If it's not there, create it (see apps.json content below)

---

### Step 6: Configure Microphone Permissions

1. **Windows Settings:**
   - Press `Win + I` to open Settings
   - Go to **Privacy → Microphone**
   - Enable **"Allow apps to access your microphone"**
   - Enable **"Allow desktop apps to access your microphone"**

2. **Test Microphone:**
   - Open **Windows Voice Recorder**
   - Record a test audio
   - If it works, you're ready!

---

### Step 7: Run the Application

**Method 1: Run from Eclipse (Recommended)**

1. In Project Explorer, expand: **src/main/java → com.vocadesk**
2. Right-click on **VoiceLauncher.java**
3. Select **Run As → Java Application**
4. Check the **Console** tab at the bottom
5. You should see:
   ```
   [INFO] Initializing offline speech recognition...
   [SUCCESS] Speech recognition initialized (offline mode)
   [INFO] Loaded app: calculator -> C:/Windows/System32/calc.exe
   ...
   ========================================
     VOcadesk - Offline Voice Launcher
   ========================================
   Listening for commands...
   ```

**Method 2: Run with Maven**

1. Right-click on **VOcadesk** project
2. Select **Run As → Maven build...**
3. In Goals, enter: `clean compile exec:java`
4. Click **Run**

---

## Troubleshooting Eclipse Issues

### Issue 1: "Project configuration is not up-to-date"

**Solution:**
1. Right-click project → **Maven → Update Project**
2. Check **Force Update of Snapshots/Releases**
3. Click OK

### Issue 2: "Build path specifies execution environment JavaSE-17"

**Solution:**
1. Right-click project → **Properties**
2. Go to **Java Build Path → Libraries**
3. Remove old JRE
4. Click **Add Library → JRE System Library**
5. Select **JavaSE-17** or higher
6. Click Finish → Apply

### Issue 3: Maven Dependencies not downloading

**Solution:**
1. Check internet connection
2. Go to **Window → Preferences → Maven**
3. Uncheck **Offline**
4. Click **Apply and Close**
5. Right-click project → **Maven → Update Project**

### Issue 4: "Failed to execute goal" during Maven build

**Solution:**
1. Delete Maven repository cache:
   - Close Eclipse
   - Delete: `C:\Users\praka\.m2\repository`
   - Reopen Eclipse
   - Right-click project → **Maven → Update Project**

### Issue 5: Red X on project after import

**Solution:**
1. Check **Problems** tab at the bottom
2. Common fixes:
   - Right-click project → **Maven → Update Project**
   - Right-click project → **Refresh** (F5)
   - **Project → Clean** → Select VOcadesk → Clean

### Issue 6: "sphinx4-core" or "sphinx4-data" not found

**Solution:**
These are SNAPSHOT versions from Sonatype repository.

1. Check `pom.xml` has the snapshots repository:
   ```xml
   <repositories>
       <repository>
           <id>snapshots-repo</id>
           <url>https://oss.sonatype.org/content/repositories/snapshots</url>
           <snapshots>
               <enabled>true</enabled>
           </snapshots>
       </repository>
   </repositories>
   ```

2. Force Maven to download snapshots:
   - Right-click project → **Maven → Update Project**
   - Check **Force Update of Snapshots/Releases**

3. If still failing, check Maven settings:
   - **Window → Preferences → Maven → User Settings**
   - Verify settings.xml location
   - Click **Update Settings**

### Issue 7: Console shows "No microphone available"

**Solution:**
1. Check microphone is connected
2. Windows Settings → Privacy → Microphone → Enable
3. Test in Windows Voice Recorder first
4. Restart Eclipse

### Issue 8: "Failed to read apps.json"

**Solution:**
1. Verify `apps.json` is in project root (not in src/)
2. Right-click project → **Refresh** (F5)
3. Check JSON syntax is valid
4. Make sure file is UTF-8 encoded

---

## Eclipse Plugins Needed (Usually Pre-installed)

### Required Plugins:

1. **Maven Integration (m2e)** - Usually comes with Eclipse
   - Check: Help → About → Installation Details
   - If missing: Help → Eclipse Marketplace → Search "m2e"

2. **Java Development Tools (JDT)** - Comes with Eclipse IDE for Java

### Optional but Recommended:

1. **Eclipse Color Theme** - Better syntax highlighting
2. **Darkest Dark Theme** - Dark theme for Eclipse
3. **JSON Editor Plugin** - For editing apps.json
   - Help → Eclipse Marketplace → Search "JSON Editor"

---

## Maven Configuration Files

Eclipse will auto-generate these files (don't edit manually):

- `.classpath` - Eclipse classpath configuration
- `.project` - Eclipse project configuration
- `.settings/` - Eclipse settings folder

These are already in `.gitignore` so they won't be committed to Git.

---

## Building Executable JAR from Eclipse

**To create a runnable JAR:**

1. Right-click on **VOcadesk** project
2. Select **Run As → Maven build...**
3. In **Goals**, enter: `clean package`
4. Click **Run**
5. JAR will be created at: `target/vocadesk-1.0.0.jar`

**To run the JAR:**
```bash
cd C:\Users\praka\eclipse-workspace\VOcadesk
java -jar target/vocadesk-1.0.0.jar
```

**Important:** Copy `apps.json` to the same folder as the JAR!

---

## Eclipse Shortcuts (Helpful)

- **Ctrl + Shift + O** - Organize imports
- **Ctrl + Shift + F** - Format code
- **Ctrl + Space** - Auto-complete
- **F5** - Refresh project
- **Ctrl + F11** - Run last launched
- **Alt + Shift + X, J** - Run as Java Application

---

## Verify Everything is Working

**Checklist:**

- ✅ Eclipse IDE installed
- ✅ JDK 17+ installed and configured
- ✅ Maven plugin (m2e) installed
- ✅ VOcadesk project imported
- ✅ Maven dependencies downloaded (check Maven Dependencies folder)
- ✅ No red X errors on project
- ✅ apps.json in project root
- ✅ Microphone connected and permissions granted
- ✅ VoiceLauncher.java runs without errors

**Test Run:**
1. Run VoiceLauncher.java
2. Wait for "Listening for commands..."
3. Say: **"open calculator"**
4. Calculator should launch!

---

## Need More Help?

**Eclipse Documentation:**
- https://help.eclipse.org/

**Maven in Eclipse:**
- https://www.eclipse.org/m2e/

**CMUSphinx:**
- https://cmusphinx.github.io/

---

**You're all set! Happy coding! 🚀**
