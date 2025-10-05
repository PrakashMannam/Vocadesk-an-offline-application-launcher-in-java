# 🎤 Vosk Model Setup Guide

## ✅ Switched to Vosk!

I've replaced CMUSphinx with **Vosk** - a better, modern speech recognition library that's:
- ✅ More accurate
- ✅ Actively maintained
- ✅ Available in Maven Central (no manual JAR downloads!)
- ✅ Fully offline

## 📥 Download Vosk Model (One-Time Setup)

### Step 1: Download the Model

Go to: **https://alphacephei.com/vosk/models**

**Recommended model for English:**
- **vosk-model-small-en-us-0.15** (40 MB) - Good balance
- Direct link: https://alphacephei.com/vosk/models/vosk-model-small-en-us-0.15.zip

**Alternative (more accurate but larger):**
- **vosk-model-en-us-0.22** (1.8 GB) - Best accuracy
- Direct link: https://alphacephei.com/vosk/models/vosk-model-en-us-0.22.zip

**For this project, use the small model (40 MB).**

### Step 2: Extract the Model

1. Download `vosk-model-small-en-us-0.15.zip`
2. Extract the ZIP file
3. You'll get a folder: `vosk-model-small-en-us-0.15`

### Step 3: Rename and Move to Project

1. **Rename** the folder from `vosk-model-small-en-us-0.15` to just `model`
2. **Move** the `model` folder to your project root:
   ```
   C:\Users\praka\eclipse-workspace\VOcadesk\model\
   ```

### Step 4: Verify Structure

Your project should look like this:

```
VOcadesk/
├── model/                    ← Vosk model folder
│   ├── am/
│   ├── conf/
│   ├── graph/
│   └── README
├── src/
├── lib/
├── apps.json
└── pom.xml
```

**The `model` folder must be at the project root level!**

---

## 🔄 Update Maven

Now update Maven to download the Vosk library:

1. Right-click **VOcadesk** project
2. **Maven → Update Project**
3. Check **Force Update**
4. Click **OK**

Maven will download:
- ✅ `vosk-0.3.45.jar` (automatically!)
- ✅ All dependencies

**No manual JAR downloads needed!**

---

## 🚀 Run the Application

After model is in place and Maven updated:

1. **Refresh Project** (F5)
2. Right-click `VOcadeskMain.java`
3. **Run As → Java Application**
4. Click **"Start Voice Recognition"**
5. Say **"open calculator"**

---

## 📊 Model Comparison

| Model | Size | Accuracy | Speed | Recommended |
|-------|------|----------|-------|-------------|
| vosk-model-small-en-us-0.15 | 40 MB | Good | Fast | ✅ Yes |
| vosk-model-en-us-0.22 | 1.8 GB | Excellent | Slower | For production |
| vosk-model-en-us-0.42-gigaspeech | 2.3 GB | Best | Slowest | Advanced use |

**For this project: Use the small model (40 MB)**

---

## ❓ Troubleshooting

### Issue: "Failed to initialize speech recognizer"

**Solution:**
- Check that `model` folder exists at project root
- Verify folder structure has `am`, `conf`, `graph` subfolders
- Make sure folder is named exactly `model` (not `vosk-model-small-en-us-0.15`)

### Issue: "Model not found"

**Solution:**
- Path should be: `C:\Users\praka\eclipse-workspace\VOcadesk\model\`
- Refresh project in Eclipse (F5)
- Check that `model` folder is visible in Project Explorer

### Issue: Maven dependency error

**Solution:**
- Right-click project → Maven → Update Project
- Check internet connection
- Vosk is in Maven Central, so it should download automatically

---

## 🎯 Summary

**What I changed:**
- ❌ Removed CMUSphinx (hard to get JARs)
- ✅ Added Vosk (available in Maven Central)
- ✅ Updated VoiceRecognitionController.java to use Vosk

**What you need to do:**
1. Download vosk-model-small-en-us-0.15.zip (40 MB)
2. Extract and rename folder to `model`
3. Move `model` folder to project root
4. Update Maven project
5. Run the application

**Benefits:**
- ✅ No manual JAR downloads
- ✅ Better accuracy than CMUSphinx
- ✅ Actively maintained
- ✅ Fully offline after model download

---

## 📝 Quick Checklist

- [ ] Downloaded vosk-model-small-en-us-0.15.zip
- [ ] Extracted the ZIP
- [ ] Renamed folder to `model`
- [ ] Moved to `C:\Users\praka\eclipse-workspace\VOcadesk\model\`
- [ ] Refreshed project in Eclipse (F5)
- [ ] Updated Maven project
- [ ] Verified `vosk-0.3.45.jar` in Maven Dependencies
- [ ] Ready to run!

---

**Download link:** https://alphacephei.com/vosk/models/vosk-model-small-en-us-0.15.zip

**This is much easier than finding CMUSphinx JARs!** 🎉
