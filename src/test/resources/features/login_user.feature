Feature: Register User with existing email

  Scenario: Register User with existing email
    Given They are on the Signup and Login page
    When They have entered the name "The Legend" and email "theLegend@example.com"
    And They click signup
    Then They should see the error message "Email Address already exist!"

  Scenario: Deny registration because email already exists (Case Insensitivity Check)
    Given They are on the Signup and Login page
    When They have entered the name "Kevin Musisi" and email "mUsisi@gMail.com"
    And They click signup
    # Changed to 'And' to match the step definition correctly
    Then They should see the error message "Email Address already exist!"