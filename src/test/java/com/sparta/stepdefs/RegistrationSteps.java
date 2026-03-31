package com.sparta.stepdefs;

import com.sparta.pom.SignupPage;
import com.sparta.pom.AccountDetailsPage; // Ensure this import exists
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.By;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class RegistrationSteps {

    @Steps
    SignupPage signupPage;

    @Steps
    AccountDetailsPage detailsPage;

    @Given("the user is on the signup page")
    public void userIsOnSignupPage() {
        // Navigate to the specific signup URL or click the button from Home
        signupPage.open();
    }

    @When("they enter name {string} and email {string}")
    public void enterNameAndEmail(String name, String email) {
        signupPage.find(By.cssSelector("input[data-qa='signup-name']")).type(name);
        signupPage.find(By.cssSelector("input[data-qa='signup-email']")).type(email);
    }

    @When("they click signup")
    public void clickSignup() {
        signupPage.find(By.cssSelector("button[data-qa='signup-button']")).click();
    }

    @Then("they should be on the account details page")
    public void verifyAccountDetailsPage() {
        assertThat(detailsPage.getDriver().getCurrentUrl(), containsString("signup"));
    }

    @Then("they should see the error message {string}")
    public void verifyErrorMessage(String message) {
        // Select the specific p tag or form text for existing email error
        String bodyText = signupPage.find(By.tagName("body")).getText();
        assertThat(bodyText, containsString(message));
    }
}