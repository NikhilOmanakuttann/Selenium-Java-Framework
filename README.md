#  Selenium Hybrid Automation Framework

A robust, modular, and data-driven test automation framework designed for the [SauceDemo](https://www.saucedemo.com/) e-commerce platform. This project demonstrates modern automation practices using the **Page Object Model (POM)** design pattern.

##  Key Features
* **Page Object Model (POM):** Clear separation between page objects (locators) and test scripts.
* **Data-Driven Testing:** Test data is read dynamically from Excel files using **Apache POI**.
* **Robust Reporting:** Generates interactive HTML reports with **ExtentReports 5**, including automatic screenshots on failure.
* **Cross-Browser Support:** Configurable via `properties` file to run on Chrome, Firefox, or Edge.
* **CI/CD Ready:** Optimized for Jenkins/GitHub Actions integration (Headless mode supported).

## Tech Stack
| Component | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **Web Automation** | Selenium WebDriver 4.27 |
| **Test Runner** | TestNG |
| **Build Tool** | Maven |
| **Reporting** | ExtentReports 5 |
| **Data Source** | Apache POI (Excel) |
| **Logging** | Log4j2 |

## Project Structure
```text
src/test/java
├── com.automation.tests      # Test Scripts (LoginTest, InventoryTest)
├── com.automation.pages      # Page Objects (Locators & Actions)
├── com.automation.base       # Base Class (Driver Initialization)
├── com.automation.utils      # Utilities (Excel, Config, DataProviders)
├── com.automation.listeners  # Test Listeners (Screenshots & Reporting)
└── resources                 # Config.properties & TestData.xlsx