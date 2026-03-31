package com.sparta.steps;

import com.sparta.pom.LoginSignup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class Registration {

    @Managed
    LoginSignup loginSignup;

    @Given("They are on the Signup and Login page")
    public void theUserIsOnTheSignupPage() {
        // Write code here that turns the phrase above into concrete actions
        loginSignup.open();
        loginSignup.acceptConsent();
    }

    @When("They have entered the name {string} and email {string}")
    public void theyEnterNameAndEmail(String name, String email) {
        // Write code here that turns the phrase above into concrete actions
        loginSignup.enterSignupName(name);
        loginSignup.enterSignupEmail(email);
    }

    @And("They click signup")
    public void theyClickSignup() {
        // Write code here that turns the phrase above into concrete actions
        loginSignup.pressSignup();
    }

    @Then("They should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(loginSignup.isSignupError(), Matchers.is(true));
        MatcherAssert.assertThat(loginSignup.getSignupError(), Matchers.is(errorMessage));
    }
}
