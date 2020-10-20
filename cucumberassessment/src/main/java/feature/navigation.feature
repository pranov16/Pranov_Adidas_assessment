Feature: Exercise 2 solution

Scenario: Navigation to different tabs

Given customer is on home page
When title of the page is confirmed
Then customer navigates to Laptop page
Then customer add one laptop to cart and customer accept the popup and customer navigates to home page
Then customer add another laptop to cart and customer accept the popup
Then customer navigates to cart
Then customer delete one laptop item
Then customer place the order 
And customer is on order details page
Then customer fill all the details and click on purchase
Then customer click on ok

