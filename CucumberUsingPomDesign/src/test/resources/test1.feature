Feature: Login Scenarions of Saleforce Application

Scenario: Login into saleforce with valid username and password
Given User Launch the saleforce application
When user enter username 
And user enter password 
Then Click on login button 

Scenario: Rememberme
Given User Launch the saleforce application
When user enter username 
And user enter password 
And Click Remember me
Then Click on login button
And Click username dropdown
And Click logout

Scenario: Fogot password
Given User Launch the saleforce application
When Click on forgot password link
And user enter email
Then Click on continue button

Scenario: Invalid login
Given User Launch the saleforce application
When Enter invalid email
And Enter invalid password
Then Click on login button
And validate

Scenario: Dropdown
Given User Launch the saleforce application
When user enter username 
And user enter password 
Then Click on login button
And Click username dropdown
And Click logout