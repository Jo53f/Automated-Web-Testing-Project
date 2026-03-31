Feature: Register User with existing email (Test Case 5)

  Scenario: Register User with existing email
    Given the user is on the signup page
    When they enter name "The Legend" and email "theLegend@example.com"
    And they click signup
    Then they should see the error message "Email Address already exist!"