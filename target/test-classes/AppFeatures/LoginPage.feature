Feature: Login page feature

Scenario: Launch page title
Given user is on login page
When user gets the title of the page
Then page title should be "Sign In - Ultimate QA"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Search for available trains
Given user is on login page
When user enters emailid as "test.123@gmail.com"
And user enters password as "Test_123"
And user clicks on Login button
Then user gets the title of the page
And page title should be "All Products - Ultimate QA"