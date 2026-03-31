Feature: Shopping Cart Quantity Management
  As a user
  I want to view and verify the exact quantity of each item in my cart
  So that I can ensure I am purchasing the right amount before paying

  Background:
    Given They are on the products page
    And have nothing in their cart

  # ========== NORMAL PATH ==========
  @normal
  Scenario: Add single item to cart
    When add "Blue Top" to my cart once
    And navigate to the "Cart" page
    Then they should see "Blue Top" in the cart
    And the carts count should display "1"

  # ========== HAPPY PATH ==========
  @happy
  Scenario: Add multiple quantities of same item
    When adding "Blue Top" to my cart twice
    And navigating to the "Cart" page
    Then they should see "Blue Top" in my cart
    And the carts count should display "2"
    And quantity for "Blue Top" should be "2"
    And subtotal should reflect "2" times the unit price

