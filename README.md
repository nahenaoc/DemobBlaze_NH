# DemoBlaze Automation Project

## Overview

Welcome to the DemoBlaze Automation Project! This project is designed to showcase how the Page Object Model (POM) design pattern can be used to create a robust and maintainable test automation framework for the DemoBlaze web application. The project is built using Java and Selenium WebDriver

https://demoblaze.com/index.html

### 🏗️ Design Patterns

### 📚 Page Object Model (POM) pattern

The project follows a well-organized structure to ensure clarity and ease of maintenance. Below is an overview of the project structure:

```
DemoBlaze
│
├── drivers
│   └── chromedriver.exe
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   └── utils
│   │   │       └── WebDriverUtils.java
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       └── java
│          ├── tests
│          │   └── DemoBlazeTest.java
│          └── base
│              └── TestBase.java
│
├── pom.xml
└── README.md
```



### 🧠 Classes and their Purpose

- **drivers/**
    - Contains the ChromeDriver executable required for running the tests.

- **src/main/java/pages/**
    - **HomePage.java**: Represents the home page of the DemoBlaze application.
    - **LoginPage.java**: Represents the login page and contains methods to perform login actions.
    - **ProductPage.java**: Represents the product page and includes methods to interact with product details.
    - **CheckoutPage.java**: Represents the checkout page and includes methods to fill in payment details and complete the purchase.

- **src/main/java/utils/**
    - **WebDriverUtils.java**: Contains utility methods for initializing the WebDriver.

- **src/main/resources/**
    - **config.properties**: Contains configuration properties such as URLs, credentials, and other test data.

- **src/test/java/tests/**
    - **DemoBlazeTest.java**: Contains the test cases for the DemoBlaze application, utilizing the Page Object Model.

- **src/test/java/base/**
    - **TestBase.java**: Provides the base setup and teardown methods for the tests.

- **pom.xml**
    - The Maven Project Object Model file that manages project dependencies and build configuration.

## Key Features

- **Page Object Model (POM)**: The project uses the POM design pattern to enhance test maintenance and readability by separating the test logic from the page-specific actions.
- **Configurable Properties**: Test data and configuration settings are externalized in the `config.properties` file, making it easy to update without modifying the code.
- **WebDriver Utilities**: Utility methods for WebDriver initialization and configuration are centralized in `WebDriverUtils.java`.
- **Robust Test Cases**: The test cases in `DemoBlazeTest.java` cover various scenarios, including login, product selection, and checkout, ensuring comprehensive test coverage.

## Getting Started

### Prerequisites

- Java JDK 17
- Maven
- Chrome browser



### Running the Tests

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/DemoBlazeAutomation.git
   cd DemoBlazeAutomation
    ```

### 🤝 Contributions
Contributions are welcome. If you want to contribute to the project, please fork the repository, make your changes and submit a pull request.



