Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on login link on HomePage and land on secure sign in Page
When User enters <username>  and <password> and logs in
Then Verify that the user is successfully logged in

Examples:
|username|password|
|test99@gmail.com|12356|
|test999@gmail.com|12345678|