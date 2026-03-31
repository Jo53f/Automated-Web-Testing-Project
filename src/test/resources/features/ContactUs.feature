Feature: ContactUs
  In order to be able to buy items

  As a registered user of the Sauce Labs website

  I want to be able to sign in to my account

  @Happy
  Scenario: User navigates to Contact Us page
    Given the user is on the home page
    When the user navigates to the Contact Us page
    Then the "GET IN TOUCH" section should be displayed

  @Happy
  Scenario: User submits contact form successfully
    Given the user has entered valid details
    When the user submits the form
    Then a confirmation alert should be displayed


#
#  @Sad
#  Scenario Outline: Login with valid username and invalid password
#
#    Given I am on the home page
#
#    And I have entered the username "standard_user"
#
#    And I have entered the password "known_sauce"
#
#    When I click the login button
#
#    Then I should see an error message that contains "Epic sadface"
#
#    Examples:
#      | passwords |
#
#      | wrong     |
#
#      | 12345     |
#
#      | invalid   |
