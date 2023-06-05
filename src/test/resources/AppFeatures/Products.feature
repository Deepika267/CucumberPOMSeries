Feature: Product Page Feature

Background:
Given user has already logged in to application
|username|password|
|test.123@gmail.com|Test_123|

@products
Scenario: Products page title
Given user is on Products page
When user gets the title of the page
Then page title should be "All Products - Ultimate QA"

@products
Scenario: Accounts section count
Given user is on Products page
Then user gets accounts section
|Coding and testing an authentication API [NodeJs + Cypress]|
|Complete Selenium WebDriver with Java Bootcamp|
|Modern React and NodeJS Development (hands-on projects)|
|TestProject Java SDK Tutorial|
|Complete Selenium Webdriver with C# - Build A Framework|
|C# For QA Automation Engineers with Selenium Webdriver|
And products section count should be 6

