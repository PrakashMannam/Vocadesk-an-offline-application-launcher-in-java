# 📥 Vosk Model Download Guide

## ⚠️ IMPORTANT: Model Not Included!

The Vosk speech recognition model is **NOT included** in this repository because it's too large for GitHub (1GB+).

**You MUST download it separately before running VOcadesk!**

---

## 🇮🇳 Recommended: Indian English Model

**Best for Indian accents!**

1. **Download:** [vosk-model-en-in-0.5.zip](https://alphacephei.com/vosk/models/vosk-model-en-in-0.5.zip)
   - Size: 1.0 GB
   - Optimized for Indian English

2. **Extract** the zip file

3. **Rename** the extracted folder from `vosk-model-en-in-0.5` to `model`

4. **Move** it to project root:
   ```
   VOcadesk/
   ├── model/          ← Place here!
   │   ├── am/
   │   ├── conf/
   │   ├── graph/
   │   ├── ivector/
   │   └── README
   ├── src/
   ├── pom.xml
   └── apps.json
   ```

---

## 🌍 Alternative Models

### US English (High Accuracy)
- **Download:** [vosk-model-en-us-0.22.zip](https://alphacephei.com/vosk/models/vosk-model-en-us-0.22.zip)
- **Size:** 1.8 GB
- **Best for:** American English accent
- **Accuracy:** 95%+

### Small/Fast Model
- **Download:** [vosk-model-small-en-us-0.15.zip](https://alphacephei.com/vosk/models/vosk-model-small-en-us-0.15.zip)
- **Size:** 40 MB
- **Best for:** Quick testing, low-end PCs
- **Accuracy:** 70-80%

---

## ✅ Verify Installation

After placing the model, your folder structure should look like:

```
VOcadesk/
├── model/
│   ├── am/
│   │   ├── final.mdl
│   │   └── frame_subsampling_factor
│   ├── conf/
│   │   ├── mfcc.conf
│   │   └── model.conf
│   ├── graph/
│   │   ├── HCLG.fst
│   │   └── words.txt
│   ├── ivector/
│   └── README
├── src/
├── pom.xml
└── apps.json
```

---

## 🚀 After Download

1. **Run VOcadesk** in Eclipse
2. You should see: `[SUCCESS] Speech recognition initialized`
3. If you see `[ERROR] Failed to initialize`, check that `model/` folder exists!

---

## 📊 Model Comparison

| Model | Size | Accuracy | Best For |
|-------|------|----------|----------|
| Indian English | 1.0 GB | 90%+ | Indian accents |
| US English | 1.8 GB | 95%+ | American accents |
| Small | 40 MB | 70-80% | Testing/Low-end PCs |

---

## ❓ Troubleshooting

**Error: "Model not found"**
- Make sure folder is named exactly `model` (lowercase)
- Check it's in project root, not inside `src/`

**Error: "Failed to load model"**
- Model might be corrupted, re-download
- Check you extracted the full zip file

---

**Once model is downloaded, VOcadesk is ready to use!** 🎤✨
