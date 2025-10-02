# 🥒 Cucumber Login Test Automation

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.14.0-green.svg)](https://cucumber.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.20.0-red.svg)](https://selenium.dev/)
[![JUnit](https://img.shields.io/badge/JUnit-4.13.2-blue.svg)](https://junit.org/)
[![Gradle](https://img.shields.io/badge/Gradle-7.0+-blue.svg)](https://gradle.org/)

A comprehensive **Behavior-Driven Development (BDD)** test automation framework for testing login functionality using Cucumber, Selenium WebDriver, and JUnit.

## 📋 Table of Contents

- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [📁 Project Structure](#-project-structure)
- [🚀 Getting Started](#-getting-started)
- [📝 Test Scenarios](#-test-scenarios)
- [🏃‍♂️ Running Tests](#️-running-tests)
- [📊 Test Reports](#-test-reports)
- [🔧 Configuration](#-configuration)
- [👨‍💻 Author](#-author)

## ✨ Features

- **🎯 BDD Approach**: Write tests in plain English using Gherkin syntax
- **🌐 Web Automation**: Automated browser testing with Selenium WebDriver
- **📊 Rich Reporting**: HTML reports with detailed test results
- **🔧 Easy Configuration**: Simple setup with Gradle build system
- **📱 Cross-browser Support**: Chrome WebDriver integration
- **✅ Comprehensive Coverage**: Both positive and negative test scenarios

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 11+ | Programming language |
| **Cucumber** | 7.14.0 | BDD testing framework |
| **Selenium** | 4.20.0 | Web browser automation |
| **JUnit** | 4.13.2 | Test assertion framework |
| **Gradle** | 7.0+ | Build automation tool |

## 📁 Project Structure

```
cucumber-login-test/
├── 📁 src/
│   └── 📁 test/
│       ├── 📁 java/
│       │   ├── 📁 stepDefinitions/
│       │   │   └── 📄 LoginSteps.java          # Step definitions
│       │   ├── 📁 utils/
│       │   │   └── 📄 TestDataManager.java     # Test data utility
│       │   └── 📄 TestRunner.java              # Test runner configuration
│       └── 📁 resources/
│           ├── 📁 features/
│           │   └── 📄 login.feature            # Feature files
│           ├── 📄 config.properties            # Main configuration
│           └── 📄 testdata.properties          # Test data configuration
├── 📁 build/
│   └── 📁 reports/
│       └── 📄 cucumber.html                    # Test reports
├── 📄 build.gradle                            # Dependencies & build config
└── 📄 README.md                               # This file
```

## 🚀 Getting Started

### Prerequisites

- ☕ **Java 11 or higher**
- 🌐 **Chrome browser** installed
- 📦 **ChromeDriver** (compatible with your Chrome version)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd cucumber-login-test
   ```

2. **Download ChromeDriver**
   - Download from [ChromeDriver Downloads](https://chromedriver.chromium.org/)
   - Update the path in `LoginSteps.java` line 14:
   ```java
   System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver");
   ```

3. **Build the project**
   ```bash
   ./gradlew build
   ```

## 📝 Test Scenarios

### Feature: Login Functionality

#### ✅ Successful Login
- **Given** the user is on the login page
- **When** the user enters valid credentials
- **And** clicks the login button
- **Then** the user should be redirected to the dashboard

#### ❌ Failed Login
- **Given** the user is on the login page
- **When** the user enters invalid credentials
- **And** clicks the login button
- **Then** an error message should be displayed

## 🏃‍♂️ Running Tests

### Run All Tests
```bash
./gradlew test
```

### Run Specific Feature
```bash
./gradlew test -Dcucumber.options="--features src/test/resources/features/login.feature"
```

### Run with Specific Tags
```bash
./gradlew test -Dcucumber.options="--tags @smoke"
```

## 📊 Test Reports

After running tests, view the detailed HTML report:

```
📁 build/reports/cucumber.html
```

The report includes:
- 📈 **Test execution summary**
- 🎯 **Feature and scenario details**
- ⏱️ **Execution time and status**
- 📝 **Step-by-step results**
- 🖼️ **Screenshots** (if configured)

## 🔧 Configuration

### Properties Files

The project now uses configuration files for better maintainability:

#### `src/test/resources/config.properties`
Main configuration file containing:
- Application URL
- WebDriver settings
- Element selectors
- Timeout configurations

#### `src/test/resources/testdata.properties`
Test data configuration containing:
- Valid/invalid credentials
- Edge case test data
- Boundary test values

### Updating Test Data

Edit `src/test/resources/testdata.properties`:

```properties
# Valid Test Credentials
valid.username=your_username
valid.password=your_password

# Invalid Test Credentials
invalid.username=testuser
invalid.password=wrongpass
```

### Updating Application URL

Modify `src/test/resources/config.properties`:

```properties
# Application Configuration
app.url=https://your-application.com/login
```

### Updating Element Selectors

Update selectors in `src/test/resources/config.properties`:

```properties
# Element Selectors
username.field.id=username
password.field.id=password
login.button.id=loginButton
error.message.id=errorMessage
```

### WebDriver Configuration

Configure ChromeDriver settings in `config.properties`:

```properties
# WebDriver Configuration
webdriver.chrome.driver.path=path/to/your/chromedriver
webdriver.implicit.wait=10
webdriver.page.load.timeout=30
```

## 🎨 Customization

### Adding New Test Scenarios

1. **Add to Feature File** (`login.feature`):
   ```gherkin
   Scenario: Login with empty credentials
     Given the user is on the login page
     When the user enters username "" and password ""
     And clicks the login button
     Then an error message "Please enter username and password" should be displayed
   ```

2. **Implement Step Definition** (`LoginSteps.java`):
   ```java
   @Then("an error message {string} should be displayed")
   public void error_message_displayed(String expectedMessage) {
       // Implementation
   }
   ```

### Adding New Features

1. Create new `.feature` file in `src/test/resources/features/`
2. Add corresponding step definitions
3. Update `TestRunner.java` if needed

## 🐛 Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| **ChromeDriver not found** | Update the path in `LoginSteps.java` |
| **Element not found** | Verify selectors match your application |
| **Tests fail** | Check if the application URL is accessible |
| **Build fails** | Ensure Java 11+ is installed |

### Debug Mode

Run tests with debug information:
```bash
./gradlew test --debug
```

## 👨‍💻 Author

**Tewodros Berhanu**  
📅 Created: February 8, 2025

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

<div align="center">

**⭐ Star this repository if you found it helpful!**

Made with ❤️ using Cucumber, Selenium, and Java

</div>

