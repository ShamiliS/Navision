Feature: Login to the application and validate the page for Ooyala application 

Background: 
	Given launch an application URL 
	
@Smoke 
Scenario: Login in to the application with valid credentials. 
	Given I should see Login Page 
	When I enter username and password with valid credential 
	And I click Login button 
	Then I validate flash message after logged in successfully 
	And I Logout from the application 
	
#@Smoke 
#Scenario Outline: Login in to the application with invalid credentials. 
#	Given I enter "<Username>" and "<Password>" with invalid credential 
#	And I click Login button 
#	Then I validate Login page with valid "<ErrorMessage>" 
#	
#	Examples: 
#		| Username | Password             | ErrorMessage              |
#		| tomsmiht | SuperSecretPassword! | Your username is invalid! |
#		| tomsmith | SuperSecretPassword  | Your password is invalid! |
#	
#@Smoke 
#Scenario: Navigate and validate all the links in Secure Area page 
#Given I enter username and password with valid credential 
#And I click Login button 
#Then I navigate and validate all links in the Secure Area page 
#And I Logout from the application 
#			
