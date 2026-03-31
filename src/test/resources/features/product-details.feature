Feature: View All Products and Product Detail Page

  Background:
    Given the user launches the browser
    And the user navigates to "http://automationexercise.com"

  Scenario: Verify home page is visible successfully
    Then the home page should be displayed

  Scenario: Verify navigation to All Products page
    When the user clicks on the "Products" button
    Then the All Products page should be displayed
    And the products list should be visible

  Scenario: Verify product detail page for first product
    Given the user is on the All Products page
    When the user clicks on "View Product" for the first product
    Then the product detail page should be displayed
    And the product name should be visible
    And the product category should be visible
    And the product price should be visible
    And the product availability should be visible
    And the product condition should be visible
    And the product brand should be visible

  Scenario: Add product to cart
    Given I have nothing in my cart
    When I add "Blue Top" to my cart twice
    And I navigate to the "Cart" page
    Then I should see "Blue Top" in my list
    And the cart count should display "2"