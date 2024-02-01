# testSalesforceAutomation

Test automation on page salesforce for company VRP consulting using tools as Java, Maven and Framework Selenium.

## Previous requirements

Ensure you have install the following requirements before of execute project :

- Java SDK (versión 17)
- Maven (versión 3.8.2) 
- Selenium (version 4.17)
- WebDriver (ChromeDriver 121)

## Project Configuration

1. **Clone Repository:**
   git clone https://github.com/alejoagd/testSalesforceAutomation.git

2. **Configuration Dependencies of Maven:**
Make sure the dependencies in the file pom.xml are configured correctly.

3.**Configuration of WebDriver:**
Download and configure the corresponding WebDriver (e.g. ChromeDriver) and make sure it is in your PATH.

4.**Execute the Project**
Run your automation tests with the following command:

mvn clean test

**¤# Project Structure**

.
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │             └── AccountsPage
│   │             └── BasePage
│   │             └── HomePage
│   │             └── TrialPage
│   │        └── tests
│   │        └── Utils
│   │            └── ToolsManager
│   └── test
│       └── java
│           └── base
│               └── BaseTest
│               tests
│               └── CreateAccountTest
│               └── CreateOrgTest
│               └── EditAccountTest
├── pom.xml
└── README.md
