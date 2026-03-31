Feature: Shopping Cart Quantity Management
  As a user
  I want to view and verify the exact quantity of each item in my cart
  So that I can ensure I am purchasing the right amount before paying

  Background:
    Given I am on the products page
    And I have nothing in my cart

  # ========== NORMAL PATH ==========
  @normal
  Scenario: Add single item to cart
    When I add "Blue Top" to my cart once
    And I navigate to the "Cart" page
    Then I should see "Blue Top" in my cart
    And the cart count should display "1"

  # ========== HAPPY PATH ==========
  @happy
  Scenario: Add multiple quantities of same item
    When I add "Blue Top" to my cart twice
    And I navigate to the "Cart" page
    Then I should see "Blue Top" in my cart
    And the cart count should display "2"
    And the quantity for "Blue Top" should be "2"
    And the subtotal should reflect "2" times the unit price

