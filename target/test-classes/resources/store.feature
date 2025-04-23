Feature: DemoBlaze Cart Flow 

Scenario: Add multiple items to the cart and verify total price
  Given I am on the DemoBlaze Homepage
  When I add  the following Items to the cart:
    | Item name         |
    | Samsung galaxy s6 |
    | Nokia lumia 1520  |
  Then the cart should contain 2 items
  And the total price should equal sum of selected Items


Scenario: Complete purchase process
  Given the cart has Items
  When I proceed to place an Order 
  And I fill in the purchase details with name "Kabelo", country "South Africa", city "Cape Town", card "5536 3091 6673 7061", month "09", year "2029"
  And I confirm the purchase
  Then I should see a confirmation message containing "Thank you for your purchase!" 