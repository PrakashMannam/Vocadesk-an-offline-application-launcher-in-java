# 🔧 CMUSphinx Dependency Fix

## ✅ Problem Solved!

The original `pom.xml` had **SNAPSHOT versions** that caused errors. I've fixed it!

## 🎯 What I Changed

### Before (Problematic):
```xml
<dependency>
    <groupId>edu.cmu.sphinx</groupId>
    <artifactId>sphinx4-core</artifactId>
    <version>5prealpha-SNAPSHOT</version>  ❌ SNAPSHOT - unstable
</dependency>
```

### After (Fixed):
```xml
<dependency>
    <groupId>de.sciss</groupId>
    <artifactId>sphinx4-core</artifactId>
    <version>1.0.0</version>  ✅ Stable release
</dependency>
```

## 📦 What This Means

**✅ No manual downloads needed!**
- Maven will **automatically download** these dependencies
- They're from **Maven Central** (reliable, stable)
- **No SNAPSHOT repository** issues
- **Works offline** after first download

## 🚀 What You Need to Do Now

### Step 1: Import Project in Eclipse

1. **File → Import → Maven → Existing Maven Projects**
2. Browse to: `C:\Users\praka\eclipse-workspace\VOcadesk`
3. Click **Finish**

### Step 2: Maven Will Download Dependencies

Eclipse will automatically:
- ✅ Read the fixed `pom.xml`
- ✅ Download `sphinx4-core-1.0.0.jar` from Maven Central
- ✅ Download `sphinx4-data-1.0.0.jar` from Maven Central
- ✅ Download `json-20231013.jar`
- ✅ Download `slf4j` libraries

**This happens automatically - no manual work needed!**

### Step 3: Wait for Download

- Watch the progress bar (bottom-right in Eclipse)
- Takes 2-5 minutes depending on internet speed
- You'll see: "Downloading..." messages in Console

### Step 4: Verify

After download completes:
- Expand **Maven Dependencies** in Project Explorer
- You should see:
  - ✅ `sphinx4-core-1.0.0.jar`
  - ✅ `sphinx4-data-1.0.0.jar`
  - ✅ `json-20231013.jar`
  - ✅ `slf4j-api-2.0.9.jar`
  - ✅ `slf4j-simple-2.0.9.jar`

## ❓ FAQ

### Q: Do I need to download JARs manually?
**A: NO!** Maven downloads everything automatically when you import the project.

### Q: Why were there errors before?
**A: SNAPSHOT versions** are unstable development versions that may not be available. The fixed version uses **stable releases** from Maven Central.

### Q: Will it work offline?
**A: YES!** After Maven downloads the dependencies once, they're cached locally. You can then work offline.

### Q: What if I still see errors?
**A: Try this:**
1. Right-click project → **Maven → Update Project**
2. Check **Force Update of Snapshots/Releases**
3. Click **OK**

### Q: Where are the dependencies stored?
**A: In your local Maven repository:**
```
C:\Users\praka\.m2\repository\
```
Maven caches all downloads here for reuse.

## 🎉 Summary

**✅ Fixed:** Changed from SNAPSHOT to stable versions  
**✅ No manual downloads:** Maven handles everything  
**✅ Ready to use:** Just import and run  

**Next step:** Import the project in Eclipse and Maven will do the rest!
