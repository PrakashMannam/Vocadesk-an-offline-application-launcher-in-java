@echo off
echo Building VOcadesk...
cd /d "%~dp0"

REM Compile Java files
javac -cp "src/main/java;lib/*" -d target/classes src/main/java/com/vocadesk/*.java

REM Run the application
java -cp "target/classes;lib/*;model" com.vocadesk.VOcadeskMain

pause
