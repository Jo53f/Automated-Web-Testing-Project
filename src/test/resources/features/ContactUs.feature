Feature: ContactUs
  As a user,
  I want to submit a message through the contact form
  so that I can get in touch with the website team.

  @Happy
  Scenario: User navigates to Contact Us page
    Given the user is on the home page
    When the user navigates to the Contact Us page
    Then the "Get In Touch" section should be displayed

  @Happy
  Scenario: User submits contact form successfully
    Given the user is on the Contact Us page
    When the user enters valid name, email, subject, message and uploads a compatible file
    Then the form fields should accept the input successfully

  @Sad
  Scenario: User submits contact form with missing required fields
    Given the user leaves required fields empty
    When the user attempts to submit the form
    Then the form should not be submitted