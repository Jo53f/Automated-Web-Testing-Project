Feature: LoginSteps
  In order to login,
  As a registered user,
  I want to be able to enter my email and password to sign in

  @Happy
  Scenario: User Login with Valid Credentials
    Given I am on the Signup and Login page
    And I have entered the email "theLegend@example.com"
    And I have entered the password "passwordLegends1999"
    When I click the login button
    Then I should land on the homepage
