Feature: Register User with existing email (Test Case 5)

  Scenario: Register User with existing email
    Given the user is on the signup page
    When they enter name "The Legend" and email "theLegend@example.com"
    And they click signup
    Then they should see the error message "Email Address already exist!"

  Scenario: Deny registration because email already exists (Case Insensitivity Check)
    Given the user is on the signup page
    When they enter name "Kevin Musisi" and email "mUsisi@gMail.com"
    And they click signup
    # Changed to 'And' to match the step definition correctly
    And they should be on the account details page
    Then they should see the error message "Email Address already exist!"



  Scenario: Login User with correct email and password
    Given the user is on the home page
    Then the home page should be visible successfully
    When they click on the "Signup / Login" button
    Then "Login to your account" should be visible
    When they login with email "theLegend@example.com" and password "password123"
    Then they should see "Logged in as The Legend"
    When they click the "Delete Account" button
    Then they should see "ACCOUNT DELETED!"