# VOcadesk GUI Guide

## 🎨 GUI Version Overview

VOcadesk now includes a beautiful **Swing-based GUI** for easier interaction with the offline voice launcher!

## 📦 What's New

### New Classes Added:

1. **`VOcadeskMain.java`** - Main entry point with GUI
2. **`VocadeskGUI.java`** - Swing GUI interface with visual controls
3. **`VoiceRecognitionController.java`** - Voice recognition controller for GUI integration

### Existing Classes (Unchanged):

- **`AppLauncher.java`** - Still manages app loading and launching
- **`VoiceLauncher.java`** - Original console version (still available)

---

## 🚀 Running the GUI in Eclipse

### Method 1: Run VOcadeskMain (Recommended)

1. In Eclipse Project Explorer, expand: **src/main/java → com.vocadesk**
2. Right-click on **`VOcadeskMain.java`**
3. Select **Run As → Java Application**
4. The GUI window will appear!

### Method 2: Run from Package Explorer

1. Right-click on the **VOcadesk** project
2. Select **Run As → Java Application**
3. If prompted, choose **`VOcadeskMain`** as the main class
4. Click **OK**

### Method 3: Create Run Configuration

1. Go to **Run → Run Configurations...**
2. Right-click **Java Application** → **New Configuration**
3. Name: `VOcadesk GUI`
4. Project: `VOcadesk`
5. Main class: `com.vocadesk.VOcadeskMain`
6. Click **Apply** → **Run**

---

## 🎯 GUI Features

### Main Window Components:

```
┌─────────────────────────────────────────────────────┐
│  VOcadesk Launcher - Offline Voice Control         │
├─────────────────────────────────────────────────────┤
│  Status: Ready                                      │
│  ┌───────────────────────────────────────────────┐ │
│  │     Start Voice Recognition (Button)          │ │
│  └───────────────────────────────────────────────┘ │
│  Last Command: None                                 │
├─────────────────────────────────────────────────────┤
│  ┌─ Available Applications ──────────────────────┐ │
│  │ Total Apps: 8                                 │ │
│  │ ─────────────────────────                     │ │
│  │ 1. calculator                                 │ │
│  │ 2. notepad                                    │ │
│  │ 3. paint                                      │ │
│  │ ...                                           │ │
│  └───────────────────────────────────────────────┘ │
├─────────────────────────────────────────────────────┤
│  ┌─ Activity Log ────────────────────────────────┐ │
│  │ [INFO] VOcadesk GUI initialized               │ │
│  │ [INFO] Loaded 8 applications                  │ │
│  │ [SUCCESS] Speech recognition initialized      │ │
│  │ [HEARD] open calculator                       │ │
│  │ [SUCCESS] Launched: calculator                │ │
│  │ ...                                           │ │
│  └───────────────────────────────────────────────┘ │
├─────────────────────────────────────────────────────┤
│  Voice Commands: 'open [app]' | 'list apps' | ...  │
└─────────────────────────────────────────────────────┘
```

### 1. Status Label
- **Green "Status: Ready"** - Voice recognition is off
- **Red "Status: Listening..."** - Voice recognition is active

### 2. Toggle Button
- **Green "Start Voice Recognition"** - Click to start listening
- **Red "Stop Voice Recognition"** - Click to stop listening

### 3. Last Command Display
- Shows the most recent voice command recognized
- Updates in real-time as you speak

### 4. Available Applications Panel
- Lists all apps loaded from `apps.json`
- Shows total count
- Scrollable if you have many apps

### 5. Activity Log Panel
- Real-time log of all activities
- Color-coded messages:
  - `[INFO]` - General information
  - `[SUCCESS]` - Successful operations
  - `[ERROR]` - Errors
  - `[WARNING]` - Warnings
  - `[HEARD]` - Voice commands recognized
  - `[ACTION]` - Actions being performed
- Auto-scrolls to show latest messages
- Dark terminal-style appearance

---

## 🎤 Using Voice Recognition

### Starting Voice Recognition:

1. **Click** the **"Start Voice Recognition"** button
2. Wait for status to change to **"Status: Listening..."**
3. The button turns **red** and shows **"Stop Voice Recognition"**
4. The log shows: `[SUCCESS] Voice recognition started`
5. **Speak clearly** into your microphone

### Stopping Voice Recognition:

1. **Click** the **"Stop Voice Recognition"** button
2. Status changes back to **"Status: Ready"**
3. The button turns **green** again
4. The log shows: `[SUCCESS] Voice recognition stopped`

### Voice Commands (Same as Before):

#### Launch Applications:
- **"open calculator"** → Opens Calculator
- **"open notepad"** → Opens Notepad
- **"launch paint"** → Opens Paint
- **"start explorer"** → Opens File Explorer

#### System Commands:
- **"list apps"** → Shows all available apps in the log
- **"show apps"** → Alternative to list apps
- **"help"** → Shows available commands

#### Exit:
- Use the **X button** on the window (not voice command)
- Confirmation dialog will appear

---

## 🔧 GUI Controls

### Window Controls:

- **Minimize** - Minimizes to taskbar
- **Maximize** - Expands to full screen
- **Close (X)** - Shows exit confirmation dialog

### Resizing:

- The window is **resizable**
- Drag edges or corners to resize
- All panels adjust automatically
- Split pane between app list and log is adjustable

### Keyboard Shortcuts:

- **Alt + F4** - Close window (with confirmation)
- **Mouse scroll** - Scroll through logs and app list

---

## 📊 Visual Feedback

### When You Speak:

1. **Command appears** in "Last Command" label
2. **Log shows** `[HEARD] your command`
3. **Action is logged** with `[ACTION]` prefix
4. **Result is shown** with `[SUCCESS]` or `[ERROR]`

### Example Flow:

```
You say: "open calculator"

GUI Updates:
┌─────────────────────────────────────┐
│ Last Command: open calculator       │
└─────────────────────────────────────┘

Activity Log:
[HEARD] open calculator
[ACTION] Attempting to open: calculator
[SUCCESS] Launched: calculator
```

---

## 🎨 GUI Customization

### Colors:

- **Status Ready**: Green (#006400)
- **Status Listening**: Red (#C62828)
- **Start Button**: Green (#2E7D32)
- **Stop Button**: Red (#C62828)
- **Log Background**: Dark (#1E1E1E)
- **Log Text**: Green (#00FF00) - Terminal style

### Fonts:

- **Status Label**: Arial Bold, 16pt
- **Button**: Arial Bold, 14pt
- **Last Command**: Arial, 14pt
- **App List**: Monospaced, 12pt
- **Activity Log**: Monospaced, 11pt

---

## 🔍 Troubleshooting GUI Issues

### Issue 1: GUI doesn't appear

**Solution:**
- Check Eclipse Console for errors
- Verify `apps.json` exists in project root
- Make sure Maven dependencies are installed
- Try: Right-click project → Maven → Update Project

### Issue 2: Button doesn't respond

**Solution:**
- Check Activity Log for error messages
- Verify microphone is connected
- Check Windows microphone permissions
- Restart the application

### Issue 3: No voice recognition

**Solution:**
- Click "Start Voice Recognition" button first
- Check status shows "Listening..."
- Verify microphone is working (test in Voice Recorder)
- Check Activity Log for initialization errors

### Issue 4: Commands not recognized

**Solution:**
- Speak clearly and at normal pace
- Reduce background noise
- Check "Last Command" label to see what was heard
- Try simpler commands like "open calculator"
- Say "help" to see available commands

### Issue 5: Window is too small/large

**Solution:**
- Resize the window by dragging edges
- Maximize the window for full screen
- Adjust the split pane divider between app list and log

### Issue 6: Log text is hard to read

**Solution:**
- Resize the window to make log area larger
- Drag the split pane divider to give more space to log
- Scroll up/down to view older messages

---

## 🆚 GUI vs Console Version

### GUI Version (VOcadeskMain):
- ✅ Visual interface
- ✅ Button controls
- ✅ Real-time feedback
- ✅ App list display
- ✅ Scrollable log
- ✅ Easy to use
- ✅ Better for beginners

### Console Version (VoiceLauncher):
- ✅ Lightweight
- ✅ Command-line interface
- ✅ No GUI overhead
- ✅ Better for automation
- ✅ Good for advanced users

**Both versions are fully offline and use the same voice recognition!**

---

## 🔄 Switching Between Versions

### To Run GUI Version:
```java
// Run: VOcadeskMain.java
```

### To Run Console Version:
```java
// Run: VoiceLauncher.java
```

Both are available in the same project!

---

## 📝 Code Structure

### Class Responsibilities:

**VOcadeskMain.java:**
- Entry point for GUI version
- Initializes AppLauncher
- Creates and shows GUI
- Handles startup errors

**VocadeskGUI.java:**
- Creates Swing window and components
- Manages UI layout
- Handles button clicks
- Updates visual feedback
- Displays logs and app list

**VoiceRecognitionController.java:**
- Initializes CMUSphinx
- Manages voice recognition lifecycle
- Processes voice commands
- Integrates with GUI for feedback
- Runs recognition in background thread

**AppLauncher.java:**
- Loads apps from JSON
- Launches applications
- Manages app registry
- (Unchanged from original)

**VoiceLauncher.java:**
- Original console version
- Still available for command-line use
- (Unchanged, still works)

---

## 🎯 Best Practices

### For Best Voice Recognition:

1. **Click "Start Voice Recognition"** before speaking
2. **Wait** for status to show "Listening..."
3. **Speak clearly** at normal pace
4. **Use simple commands** like "open calculator"
5. **Check "Last Command"** to see what was heard
6. **Watch the Activity Log** for feedback

### For Best GUI Experience:

1. **Resize window** to comfortable size
2. **Adjust split pane** to see more log or app list
3. **Keep window visible** while using voice commands
4. **Read the Activity Log** for detailed feedback
5. **Use the button** to toggle voice recognition

---

## 🚀 Quick Start Checklist

- ✅ Eclipse project imported
- ✅ Maven dependencies installed
- ✅ `apps.json` in project root
- ✅ Microphone connected
- ✅ Windows microphone permissions granted
- ✅ Run `VOcadeskMain.java`
- ✅ Click "Start Voice Recognition"
- ✅ Say "open calculator"
- ✅ Calculator launches!

---

## 📚 Additional Resources

- **README.md** - Full project documentation
- **ECLIPSE_SETUP.md** - Eclipse setup guide
- **QUICK_START.txt** - Quick reference
- **apps.json** - Application configuration

---

**Enjoy the new GUI! 🎉**

Say "open calculator" to test it out!
