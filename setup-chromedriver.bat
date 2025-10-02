@echo off
echo Setting up ChromeDriver for Cucumber Login Test
echo ================================================

REM Check if ChromeDriver is already in PATH
where chromedriver >nul 2>nul
if %errorlevel% == 0 (
    echo ChromeDriver found in PATH
    for /f "tokens=*" %%i in ('where chromedriver') do (
        echo ChromeDriver location: %%i
        echo Updating config.properties...
        powershell -Command "(Get-Content 'src\test\resources\config.properties') -replace 'webdriver.chrome.driver.path=.*', 'webdriver.chrome.driver.path=%%i' | Set-Content 'src\test\resources\config.properties'"
        echo Configuration updated successfully!
        goto :end
    )
)

echo ChromeDriver not found in PATH
echo Please download ChromeDriver from: https://chromedriver.chromium.org/
echo After downloading, either:
echo 1. Add ChromeDriver to your PATH, or
echo 2. Update the webdriver.chrome.driver.path in src\test\resources\config.properties

:end
pause
