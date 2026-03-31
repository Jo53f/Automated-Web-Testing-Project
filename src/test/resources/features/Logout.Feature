Feature: LogoutSteps
  As a logged in user,
  I want to be able to log out of my account,
  So that I can securely end my session

  @Happy
  Scenario: User logged is able to sign out
    Given I am on the homepage
    And I am signed in
    When I press sign out
    Then I should be signed out of my account