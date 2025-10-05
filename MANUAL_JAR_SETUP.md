# 🔧 Manual JAR Setup for CMUSphinx

## ⚠️ Problem

CMUSphinx libraries are **not available in Maven Central**, so we need to add them manually.

## ✅ Solution: Download & Add JARs Manually

### Step 1: Download Required JARs

Download these files and save them to the `lib` folder in your project:

**Required JARs:**

1. **sphinx4-core-5prealpha.jar**
   - URL: https://sourceforge.net/projects/cmusphinx/files/sphinx4/5prealpha/sphinx4-core-5prealpha.jar/download
   - Or: https://github.com/cmusphinx/sphinx4/releases

2. **sphinx4-data-5prealpha.jar**
   - URL: https://sourceforge.net/projects/cmusphinx/files/sphinx4/5prealpha/sphinx4-data-5prealpha.jar/download
   - Or: https://github.com/cmusphinx/sphinx4/releases

**Save to:** `C:\Users\praka\eclipse-workspace\VOcadesk\lib\`

---

### Step 2: Add JARs to Eclipse Build Path

1. **Refresh Project:**
   - Right-click on **VOcadesk** project
   - Select **Refresh** (F5)

2. **Open Build Path:**
   - Right-click on **VOcadesk** project
   - Select **Build Path → Configure Build Path**

3. **Add JARs:**
   - Click **Libraries** tab
   - Click **Add JARs...** (NOT "Add External JARs")
   - Expand **VOcadesk → lib**
   - Select both:
     - ✅ `sphinx4-core-5prealpha.jar`
     - ✅ `sphinx4-data-5prealpha.jar`
   - Click **OK**

4. **Apply and Close:**
   - Click **Apply and Close**

---

### Step 3: Verify

Check in **Project Explorer**:
```
VOcadesk
├── src/main/java
├── lib/
│   ├── sphinx4-core-5prealpha.jar  ✅
│   └── sphinx4-data-5prealpha.jar  ✅
├── Referenced Libraries
│   ├── sphinx4-core-5prealpha.jar  ✅
│   └── sphinx4-data-5prealpha.jar  ✅
└── Maven Dependencies
```

---

### Step 4: Update Maven Project

1. Right-click **VOcadesk** project
2. **Maven → Update Project**
3. Click **OK**

---

## 🎯 Alternative: Quick Download Links

If SourceForge is slow, try these direct links:

**GitHub Releases:**
- https://github.com/cmusphinx/sphinx4/releases/tag/5prealpha

**Maven Repository (for reference):**
- https://mvnrepository.com/artifact/edu.cmu.sphinx/sphinx4-core
- https://mvnrepository.com/artifact/edu.cmu.sphinx/sphinx4-data

---

## 📋 Checklist

- [ ] Created `lib` folder in project root ✅ (Already done)
- [ ] Downloaded `sphinx4-core-5prealpha.jar`
- [ ] Downloaded `sphinx4-data-5prealpha.jar`
- [ ] Saved both JARs to `lib` folder
- [ ] Refreshed project in Eclipse (F5)
- [ ] Added JARs via Build Path → Add JARs
- [ ] Verified JARs appear under "Referenced Libraries"
- [ ] No red X errors on project

---

## 🚀 After Setup

Once JARs are added:

1. **Run the application:**
   - Right-click `VOcadeskMain.java`
   - **Run As → Java Application**

2. **Test voice recognition:**
   - Click "Start Voice Recognition"
   - Say "open calculator"

---

## ❓ Troubleshooting

### Issue: Can't find download links

**Solution:** Search for "sphinx4 5prealpha jar download" or use:
- https://sourceforge.net/projects/cmusphinx/files/sphinx4/

### Issue: JARs not showing in Eclipse

**Solution:**
1. Make sure JARs are in `lib` folder (not `libs` or other name)
2. Refresh project (F5)
3. Try: Project → Clean → Clean

### Issue: Still getting errors after adding JARs

**Solution:**
1. Right-click project → **Properties**
2. **Java Build Path → Libraries**
3. Remove old/broken references
4. Add JARs again from `lib` folder

---

## 📝 Summary

**What I did:**
- ✅ Removed CMUSphinx from `pom.xml` (Maven can't find it)
- ✅ Created `lib` folder for manual JARs

**What you need to do:**
1. Download 2 JAR files
2. Put them in `lib` folder
3. Add to Build Path in Eclipse
4. Run the application

**This is the standard way to add libraries that aren't in Maven Central!**
