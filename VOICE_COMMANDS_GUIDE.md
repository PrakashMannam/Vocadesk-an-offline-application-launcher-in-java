# 🎤 VOcadesk Voice Commands Guide

## 📱 Available Applications

### **System Apps:**
- Calculator
- Notepad
- Paint
- Command Prompt
- Explorer
- Task Manager
- WordPad
- Snipping Tool

### **Browsers:**
- Chrome
- Edge
- Firefox

### **Social Media & Communication:**
- Spotify
- WhatsApp
- Discord
- Telegram
- Zoom
- Teams
- Slack

### **Productivity:**
- VS Code
- Outlook
- Word
- Excel
- PowerPoint

### **Media:**
- VLC

---

## 🗣️ Voice Commands

### **Basic App Launch:**
```
"open calculator"
"open spotify"
"launch whatsapp"
"start discord"
"open teams"
```

### **Browser Search (NEW!):**

#### **Google Search:**
```
"open chrome and search india"
"search india in edge"
"open firefox and search for python tutorial"
"search machine learning in chrome"
```

#### **More Examples:**
```
"open chrome and search weather"
"search news in edge"
"open firefox and search for recipes"
"search youtube in chrome"
```

### **System Commands:**
```
"list apps" - Show all available applications
"help" - Show available commands
```

---

## 🎯 Command Patterns

### **Pattern 1: Simple Launch**
```
"open [app name]"
"launch [app name]"
"start [app name]"
```

**Examples:**
- "open spotify"
- "launch teams"
- "start vs code"

### **Pattern 2: Browser + Search**
```
"open [browser] and search [query]"
"search [query] in [browser]"
"open [browser] and search for [query]"
```

**Examples:**
- "open chrome and search india"
- "search python in edge"
- "open firefox and search for news"

---

## 💡 Tips for Best Recognition

### **1. Speak Clearly**
- Use normal speaking pace
- Pronounce words distinctly
- Avoid background noise

### **2. Use Simple Commands**
- ✅ "open chrome and search india"
- ❌ "can you please open chrome and search for india"

### **3. App Names**
- Use exact names from the app list
- Names are case-insensitive
- "spotify" = "Spotify" = "SPOTIFY"

### **4. Search Queries**
- Keep queries simple
- Multi-word queries work: "machine learning"
- Avoid complex sentences

---

## 🔧 Customizing Apps

### **Add Your Own Apps:**

Edit `apps.json` in the project root:

```json
{
  "name": "Your App Name",
  "path": "C:/Path/To/Your/App.exe"
}
```

### **Finding App Paths:**

**Method 1: Desktop Shortcut**
1. Right-click app shortcut
2. Properties → Target
3. Copy the path

**Method 2: Task Manager**
1. Open app
2. Task Manager → Details
3. Right-click → Open file location

### **Common App Locations:**

**Installed Apps:**
```
C:/Program Files/[App Name]/[app].exe
C:/Program Files (x86)/[App Name]/[app].exe
```

**User Apps:**
```
C:/Users/[YourName]/AppData/Local/[App]/[app].exe
C:/Users/[YourName]/AppData/Roaming/[App]/[app].exe
```

---

## 🌐 Browser Search Features

### **How It Works:**
1. Detects browser name (chrome/edge/firefox)
2. Extracts search query
3. Opens default browser with Google search
4. Displays results automatically

### **Supported Browsers:**
- ✅ Google Chrome
- ✅ Microsoft Edge
- ✅ Mozilla Firefox

### **Search Examples:**

**News & Information:**
```
"search news in chrome"
"open edge and search weather"
"search coronavirus updates in firefox"
```

**Learning:**
```
"search python tutorial in chrome"
"open edge and search java programming"
"search machine learning in firefox"
```

**Entertainment:**
```
"search movies in chrome"
"open edge and search music"
"search games in firefox"
```

**Shopping:**
```
"search laptops in chrome"
"open edge and search phones"
"search books in firefox"
```

---

## 📊 Command Success Rate

### **High Success Rate:**
- ✅ Simple app names (calculator, notepad)
- ✅ Common browsers (chrome, edge)
- ✅ Popular apps (spotify, whatsapp)
- ✅ Short search queries (india, news)

### **Medium Success Rate:**
- ⚠️ Long app names (microsoft teams)
- ⚠️ Multi-word queries (machine learning)
- ⚠️ Similar sounding names

### **Tips to Improve:**
- Speak slower for long commands
- Pause between words
- Repeat if not recognized
- Check "Last Command" label to see what was heard

---

## 🎨 Social Media Apps

### **Instagram (Web):**
```
"open chrome and search instagram"
```
*Note: Instagram doesn't have a desktop app, use browser*

### **Facebook (Web):**
```
"open edge and search facebook"
```

### **Twitter/X (Web):**
```
"open chrome and search twitter"
```

### **YouTube:**
```
"search youtube in chrome"
"open edge and search youtube"
```

### **TikTok (Web):**
```
"search tiktok in firefox"
```

---

## 🚀 Advanced Usage

### **Chain Commands (Future Feature):**
Currently not supported, but planned:
```
"open spotify and play music"
"open chrome and search india and open first result"
```

### **Custom Search Engines:**
Currently uses Google. Future support for:
- Bing
- DuckDuckGo
- YouTube direct search

---

## ❓ Troubleshooting

### **App Not Found:**
- Check if app is installed
- Verify path in `apps.json`
- Say "list apps" to see available apps

### **Search Not Working:**
- Make sure you say browser name (chrome/edge/firefox)
- Use "search" keyword
- Example: "search [query] in [browser]"

### **Command Not Recognized:**
- Speak more clearly
- Use simpler words
- Check "Last Command" to see what was heard
- Say "help" for command list

---

## 📝 Quick Reference Card

```
┌─────────────────────────────────────────┐
│  LAUNCH APPS                            │
│  • "open [app]"                         │
│  • "launch [app]"                       │
│  • "start [app]"                        │
├─────────────────────────────────────────┤
│  BROWSER SEARCH                         │
│  • "open [browser] and search [query]"  │
│  • "search [query] in [browser]"        │
├─────────────────────────────────────────┤
│  SYSTEM                                 │
│  • "list apps"                          │
│  • "help"                               │
└─────────────────────────────────────────┘
```

---

## 🎉 Examples to Try Right Now!

1. **"open spotify"** - Launch Spotify
2. **"open chrome and search india"** - Search India in Chrome
3. **"launch whatsapp"** - Open WhatsApp
4. **"search news in edge"** - Search news in Edge
5. **"open discord"** - Launch Discord
6. **"list apps"** - Show all apps

---

**Enjoy your voice-controlled launcher!** 🎤✨
