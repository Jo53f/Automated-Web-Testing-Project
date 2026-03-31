Feature: Browse products by category
  As a user,
  I want to view products organised by category and sub-category,
  so that I can easily find and browse items that match my interests.

  @Happy
  Scenario: Category Options are visible
    Given the user is on the home page
    Then category options should be visible in the left sidebar

#  @Happy
#  Scenario: User navigates through Women category
#    Given the user is on the home page
#    When the user clicks on the "Women" category
#    Then the category page should be displayed

#  @Happy
#  Scenario: User switches to a Men category
#    Given the user is on a category page
#    When the user clicks on a sub-category under "Men"
#    Then the corresponding category page should be displayed
#    And the page title should contain "MEN"
#
#  @Sad
#  Scenario: User clicks on a category with no subcategories
#    Given the user is on the home page
#    When the user clicks on a category with no subcategories
#    Then no sub-category options should be displayed