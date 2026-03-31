package com.sparta.steps;

import com.sparta.pom.LoginSignup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginSteps {
    @Managed
    LoginSignup loginSignUp;

    @Given("I am on the Signup and Login page")
    public void iAmOnSignUpAndLoginPage() {
        loginSignUp.open();
        loginSignUp.acceptConsent();
    }

    @And("I accept the cookies")
    public void iConsentToCookies() throws InterruptedException {
        getDriver().wait(5000L);
        loginSignUp.acceptConsent();
    }

    @And("I have entered the email {string}")
    public void iHaveEnteredTheUsername(String email) {
        loginSignUp.enterLoginEmail(email);
    }

    @And("I have entered the password {string}")
    public void iHaveEnteredThePassword(String password) {
        loginSignUp.enterLoginPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginSignUp.pressLogin();
    }

    @Then("I should land on the homepage")
    public void iShouldLandOnTheInventoryPage() {
        String url = getDriver().getCurrentUrl();
        MatcherAssert.assertThat(url, Matchers.is("https://automationexercise.com/"));
    }

    @Then("I should see an error message that contains the string: {string}")
    public void iShouldSeeAnErrorMessageThatContains(String message) {
        MatcherAssert.assertThat(loginSignUp.isLoginError(), Matchers.is(true));
        MatcherAssert.assertThat(loginSignUp.getLoginError(), Matchers.containsString(message));
    }
}
