Feature: Search for products
@Happy
  Scenario Outline: Search for different products
    Given I am on the products page
    When I search for a product named "<product>"
    Then I should see results related to "<product>"

    Examples:
      | product   |
      | T-shirt   |
      | Dress     |
      | Jeans     |
@Sad
  Scenario: Search for a non-existing product
    Given I am on the products page
    When I search for a product named "NonExistingItem"
    Then I should see a message saying no products found