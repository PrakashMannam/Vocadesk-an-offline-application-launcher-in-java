# 📱 How to Add Apps to VOcadesk

## 🎯 Quick Guide

Adding apps to VOcadesk is super easy! Just edit the `apps.json` file.

---

## 📝 Step-by-Step Instructions

### **Step 1: Open apps.json**

Location: `C:\Users\praka\eclipse-workspace\VOcadesk\apps.json`

In Eclipse:
1. Expand **VOcadesk** project
2. Find **apps.json** in the root
3. Double-click to open

---

### **Step 2: Add Your App**

Copy this template and add it to the list:

```json
{
  "name": "Your App Name",
  "path": "C:/Path/To/Your/App.exe"
}
```

**Important:** Add a comma `,` after the previous app entry!

---

### **Step 3: Example - Adding Steam**

**Before:**
```json
  {
    "name": "VLC",
    "path": "C:/Program Files/VideoLAN/VLC/vlc.exe"
  }
]
```

**After:**
```json
  {
    "name": "VLC",
    "path": "C:/Program Files/VideoLAN/VLC/vlc.exe"
  },
  {
    "name": "Steam",
    "path": "C:/Program Files (x86)/Steam/steam.exe"
  }
]
```

**Note the comma after VLC!**

---

## 🔍 How to Find App Paths

### **Method 1: Desktop Shortcut**

1. Right-click the app shortcut on desktop
2. Select **Properties**
3. Look at **Target** field
4. Copy the path
5. Replace `\` with `/` in the path

**Example:**
- Windows path: `C:\Program Files\App\app.exe`
- JSON path: `C:/Program Files/App/app.exe`

---

### **Method 2: Task Manager**

1. Open the app you want to add
2. Open **Task Manager** (Ctrl+Shift+Esc)
3. Go to **Details** tab
4. Find your app's process
5. Right-click → **Open file location**
6. Copy the full path from address bar

---

### **Method 3: Search in File Explorer**

1. Open File Explorer
2. Search for the app name
3. Right-click the `.exe` file
4. Select **Copy as path**
5. Paste in JSON (change `\` to `/`)

---

## 📂 Common App Locations

### **Windows Apps:**
```
C:/Windows/System32/calc.exe          (Calculator)
C:/Windows/System32/notepad.exe       (Notepad)
C:/Windows/System32/mspaint.exe       (Paint)
C:/Windows/System32/cmd.exe           (Command Prompt)
C:/Windows/System32/taskmgr.exe       (Task Manager)
```

### **Installed Programs:**
```
C:/Program Files/[App Name]/[app].exe
C:/Program Files (x86)/[App Name]/[app].exe
```

**Examples:**
```
C:/Program Files/Google/Chrome/Application/chrome.exe
C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe
C:/Program Files/Mozilla Firefox/firefox.exe
```

### **User-Installed Apps:**
```
C:/Users/[YourName]/AppData/Local/[App]/[app].exe
C:/Users/[YourName]/AppData/Roaming/[App]/[app].exe
```

**Examples:**
```
C:/Users/praka/AppData/Roaming/Spotify/Spotify.exe
C:/Users/praka/AppData/Local/WhatsApp/WhatsApp.exe
C:/Users/praka/AppData/Local/Discord/Update.exe
```

---

## 🎮 Popular Apps to Add

### **Gaming:**
```json
{
  "name": "Steam",
  "path": "C:/Program Files (x86)/Steam/steam.exe"
},
{
  "name": "Epic Games",
  "path": "C:/Program Files (x86)/Epic Games/Launcher/Portal/Binaries/Win32/EpicGamesLauncher.exe"
},
{
  "name": "Minecraft",
  "path": "C:/Program Files (x86)/Minecraft Launcher/MinecraftLauncher.exe"
}
```

### **Social Media (Desktop Apps):**
```json
{
  "name": "Instagram",
  "path": "C:/Program Files/WindowsApps/Instagram/Instagram.exe"
},
{
  "name": "Twitter",
  "path": "C:/Program Files/WindowsApps/Twitter/Twitter.exe"
}
```

### **Development:**
```json
{
  "name": "Visual Studio",
  "path": "C:/Program Files/Microsoft Visual Studio/2022/Community/Common7/IDE/devenv.exe"
},
{
  "name": "IntelliJ IDEA",
  "path": "C:/Program Files/JetBrains/IntelliJ IDEA/bin/idea64.exe"
},
{
  "name": "PyCharm",
  "path": "C:/Program Files/JetBrains/PyCharm/bin/pycharm64.exe"
}
```

### **Media:**
```json
{
  "name": "iTunes",
  "path": "C:/Program Files/iTunes/iTunes.exe"
},
{
  "name": "Audacity",
  "path": "C:/Program Files/Audacity/Audacity.exe"
},
{
  "name": "OBS Studio",
  "path": "C:/Program Files/obs-studio/bin/64bit/obs64.exe"
}
```

---

## ✅ Complete Example

Here's a full `apps.json` with multiple apps:

```json
[
  {
    "name": "Calculator",
    "path": "C:/Windows/System32/calc.exe"
  },
  {
    "name": "Chrome",
    "path": "C:/Program Files/Google/Chrome/Application/chrome.exe"
  },
  {
    "name": "Spotify",
    "path": "C:/Users/praka/AppData/Roaming/Spotify/Spotify.exe"
  },
  {
    "name": "Steam",
    "path": "C:/Program Files (x86)/Steam/steam.exe"
  },
  {
    "name": "VS Code",
    "path": "C:/Users/praka/AppData/Local/Programs/Microsoft VS Code/Code.exe"
  }
]
```

---

## ⚠️ Common Mistakes

### **1. Missing Comma**
```json
❌ Wrong:
{
  "name": "App1",
  "path": "C:/path1.exe"
}
{
  "name": "App2",
  "path": "C:/path2.exe"
}

✅ Correct:
{
  "name": "App1",
  "path": "C:/path1.exe"
},
{
  "name": "App2",
  "path": "C:/path2.exe"
}
```

### **2. Backslashes Instead of Forward Slashes**
```json
❌ Wrong: "C:\Program Files\App\app.exe"
✅ Correct: "C:/Program Files/App/app.exe"
```

### **3. Comma After Last Entry**
```json
❌ Wrong:
{
  "name": "Last App",
  "path": "C:/path.exe"
},
]

✅ Correct:
{
  "name": "Last App",
  "path": "C:/path.exe"
}
]
```

---

## 🔄 After Adding Apps

### **Step 1: Save the File**
- Press **Ctrl+S** in Eclipse

### **Step 2: Restart VOcadesk**
- Close the running VOcadesk window
- Run `VOcadeskMain.java` again

### **Step 3: Verify**
- New apps will appear in the app list
- Say "list apps" to see all apps
- Say "open [new app name]" to test

---

## 🎤 Voice Commands for New Apps

After adding an app, you can say:

```
"open [app name]"
"launch [app name]"
"start [app name]"
```

**Examples:**
- "open steam"
- "launch instagram"
- "start pycharm"

**App names are case-insensitive!**

---

## 🎯 Pro Tips

### **1. Use Simple Names**
```json
✅ Good: "Chrome", "Spotify", "Steam"
❌ Avoid: "Google Chrome Browser", "Spotify Music Player"
```

### **2. Test the Path First**
- Press **Win+R**
- Paste the path
- Press Enter
- If app opens, path is correct!

### **3. Use Quotes for Paths with Spaces**
```json
"path": "C:/Program Files/My App/app.exe"
```
Always use quotes around the path!

### **4. Check App is Installed**
- Make sure the app exists at that path
- If you moved/uninstalled the app, remove it from JSON

---

## 📊 App Categories

Organize your apps by category for easy management:

```json
[
  // Browsers
  {"name": "Chrome", "path": "..."},
  {"name": "Edge", "path": "..."},
  
  // Social Media
  {"name": "WhatsApp", "path": "..."},
  {"name": "Discord", "path": "..."},
  
  // Development
  {"name": "VS Code", "path": "..."},
  {"name": "Eclipse", "path": "..."},
  
  // Gaming
  {"name": "Steam", "path": "..."},
  {"name": "Epic Games", "path": "..."}
]
```

---

## ❓ Troubleshooting

### **App Doesn't Open**

**Problem:** Say "open myapp" but nothing happens

**Solutions:**
1. Check path is correct
2. Check app name matches JSON
3. Try running path manually (Win+R)
4. Check for typos in JSON

### **JSON Error on Startup**

**Problem:** VOcadesk crashes on startup

**Solutions:**
1. Check for missing commas
2. Check for extra comma after last entry
3. Validate JSON at: https://jsonlint.com
4. Check all quotes are closed

### **App Not in List**

**Problem:** Added app but don't see it

**Solutions:**
1. Save apps.json file
2. Restart VOcadesk
3. Say "list apps" to verify
4. Check JSON syntax is correct

---

## 🌟 Advanced: Windows Store Apps

Windows Store apps have complex paths. Use this method:

1. Press **Win+R**
2. Type: `shell:AppsFolder`
3. Find your app
4. Right-click → Create shortcut
5. Check shortcut properties for path

---

## 📝 Quick Reference Card

```
┌─────────────────────────────────────────┐
│  ADDING AN APP                          │
├─────────────────────────────────────────┤
│  1. Open apps.json                      │
│  2. Add:                                │
│     {                                   │
│       "name": "App Name",               │
│       "path": "C:/path/to/app.exe"      │
│     }                                   │
│  3. Add comma before it                 │
│  4. Save file                           │
│  5. Restart VOcadesk                    │
│  6. Say "open app name"                 │
└─────────────────────────────────────────┘
```

---

## 🎉 Examples to Try

Add these popular apps:

```json
{
  "name": "Brave",
  "path": "C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe"
},
{
  "name": "Notion",
  "path": "C:/Users/praka/AppData/Local/Programs/Notion/Notion.exe"
},
{
  "name": "Figma",
  "path": "C:/Users/praka/AppData/Local/Figma/Figma.exe"
},
{
  "name": "Postman",
  "path": "C:/Users/praka/AppData/Local/Postman/Postman.exe"
}
```

---

## 📚 Summary

**To add an app:**
1. Find the `.exe` path
2. Add to `apps.json` with name and path
3. Use forward slashes `/`
4. Add comma between entries
5. Save and restart

**That's it!** 🎉

**Now you can control ANY app with your voice!** 🎤✨
