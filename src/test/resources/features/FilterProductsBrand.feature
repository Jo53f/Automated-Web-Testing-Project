Feature: Filter products by brand

  Scenario: View products by specific brand
    Given I am on the 'ALL PRODUCTS' page
    And the brands list is visible on the left sidebar
    When I click on brand "POLO"
    Then I should be navigated to the brand-specific page
    And I should see products belonging to "POLO" displayed