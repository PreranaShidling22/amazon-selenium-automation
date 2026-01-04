# Amazon Selenium Automation

##  Project Overview
This project automates a basic e-commerce workflow on Amazon using Selenium WebDriver.
It demonstrates handling of dynamic web elements, waits, window switching, and screenshot capture.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## Automated Test Scenario
1. Navigate to Amazon homepage
2. Search for a product (Laptop)
3. Click the first product from search results
4. Validate that the product detail page is loaded
5. Capture a screenshot of the product page

## Key Automation Concepts Used
- Page Object Model (POM)
- Explicit waits (WebDriverWait)
- Dynamic window/tab handling
- Assertions using TestNG
- Screenshot capture for test evidence

## How to Run the Tests
Make sure Java and Maven are installed.

```bash
mvn test
