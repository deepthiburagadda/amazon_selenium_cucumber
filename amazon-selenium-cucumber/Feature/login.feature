Feature: Login 
 
Background: Successful Login with Valid Credentials
	Given User is on Amazon Home Page
	When User Navigate to LogIn Page
	And User enters "sabaresh.maddula@gmail.com" and "Vulnerable58"
	Then Amazon User Home Page appears
	
Scenario: Search an Item and click on it
	Given User enters "handbags for women" in searchbox
	When navigates to the first search result and adds it to the cart
	Then User cart should contain the added item

