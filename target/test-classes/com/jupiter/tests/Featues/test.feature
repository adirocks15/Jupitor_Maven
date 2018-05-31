Feature: Test facebook Smoke scenario

Scenario: Test login with Valid Credentials
Given Open firefox and start application
When I enter valid username and password
Then User should be able to login successfully