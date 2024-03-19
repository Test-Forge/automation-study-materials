Feature: Add product to shopping cart

Scenario: This scenario tests whether a product is added successfully to shopping cart
	Given user navigates to shopping cart web site "https://www.saucedemo.com/"
	And user logs in with credentials "standard_user" and "secret_sauce"
	When user adds product from the list by index 0
	And user navigates to Shopping cart page
	Then added product is displayed in the list by index 0