# 📶 Bandwidth Sharing in Repocket 1.0 – Automated QA Tests

Welcome to the official QA test suite for the **Bandwidth Sharing** module of the **Repocket 1.0 Android Application**.

This repository demonstrates a professional automated testing strategy submitted by **Ahsan Habib** as part of a technical assessment for the role of **Tester (QA)** at Repocket. It covers end-to-end automation, unit testing, API validation, CI/CD setup, and test management practices.

---

## 🔍 Overview

The goal of this project is to validate the **Bandwidth Sharing** feature using a layered, scalable, and maintainable approach:

- ✅ UI Testing (Appium)
- ✅ API Testing (Postman, RestAssured)
- ✅ Unit Testing (JUnit + Mockito)
- ✅ CI/CD with GitHub Actions

---

## 📁 Repository Structure
```
Bandwidth-sharing-in-Repocket-1.0/ │ 
  ├── README.md 
  ├── pom.xml / build.gradle # Dependency management 
  ├── src/ 
    │ └── test/ 
    │ └── java/ 
    │ └── com/ 
    │ └── repocket/ 
    │ └── tests/ 
    │ ├── PositiveTest.java 
    │ ├── NegativeTest.java 
    │ ├── ApiTests.java 
    │ └── utils/ 
    │ └── TestData.java 
  ├── .github/workflows/ 
    │ └── android-tests.yml # GitHub Actions pipeline 
      └── screenshots/ # Optional: Appium screenshots

````
---

## ⚙️ Tools & Technologies

| Tool            | Purpose                           |
|------------------|-----------------------------------|
| **Appium**       | Android UI test automation        |
| **JUnit**        | Unit testing                      |
| **Mockito**      | Mocking for isolated component testing |
| **RestAssured**  | API testing in Java               |
| **Postman**      | Manual API validation             |
| **GitHub Actions** | Continuous Integration & Test Execution |

---

## ✅ Test Scenarios

### 1. Positive Test Case

- **Scenario**: User enables bandwidth sharing with sufficient data.
- **Expected**: Sharing toggle activates and status updates to “Sharing Enabled”.

### 2. Negative Test Case (Edge Case)

- **Scenario**: User attempts to enable sharing with 0MB remaining.
- **Expected**: App shows error message: “Insufficient bandwidth or no internet”.

---

## 🚀 CI/CD Integration

The project uses **GitHub Actions** to automate testing.

### Trigger:
- Push to `main` branch
- Pull requests

### Steps:
1. Checkout code
2. Set up JDK & Android SDK
3. Run unit tests
4. Launch emulator & run UI tests
5. Publish results

```yaml
# .github/workflows/android-tests.yml
name: Android UI Tests

on:
  push:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v2

      - name: Set up Java
        uses: actions/setup-java@v2
        with:
          java-version: '11'

      - name: Run Tests
        run: ./gradlew connectedAndroidTest
```
🧪 Run Locally

Requirements: Android Studio, emulator or connected device, Java 11+

1. Clone the repo:
```bash
git clone https://github.com/yourusername/Bandwidth-sharing-in-Repocket-1.0.git

cd Bandwidth-sharing-in-Repocket-1.0
``` 
2. Install dependencies:
```bash  
./gradlew build
```
4. Run tests:
```bash 
./gradlew connectedAndroidTest
```
🐞 Bug Reporting Template
Title: Bandwidth Sharing fails with 0MB quota
Description: Enabling sharing with 0MB doesn’t display the expected error.
Steps to Reproduce:

Launch the app

Navigate to Bandwidth Sharing

Enable sharing with no bandwidth
Expected Result: Error displayed
Actual Result: No error
Logs: Attached Appium log & screenshot
Device Info: Pixel 5 / Android 12
Severity: High

🧰 Test Data Strategy
Test user accounts with preset bandwidth values

Reset data post-test via teardown or API hooks

Isolated datasets for parallel test runs

👨‍💻 Author

Ahsan Habib

📧 ahsanhabib.qa@gmail.com

🔗 [LinkedIn]([url](https://www.linkedin.com/in/mahqa/)) | 🌐 [GitHub]([url](https://github.com/ahsan-00))

📄 License
All contents are intended solely for QA assessment and demonstration purposes. Not affiliated with the official Repocket team.


