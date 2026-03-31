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

  @Sad
  Scenario: User login with invalid email and valid password
    Given I am on the Signup and Login page
    And I have entered the email "ttt@example.com"
    And I have entered the password "passwordLegends1999"
    When I click the login button
    Then I should see an error message that contains the string: "Your email or password is incorrect!"

  @Sad
  Scenario: User login with valid email and invalid password
    Given I am on the Signup and Login page
    And I have entered the email "theLegend@example.com"
    And I have entered the password "password1999"
    When I click the login button
    Then I should see an error message that contains the string: "Your email or password is incorrect!"
