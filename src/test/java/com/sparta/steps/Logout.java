package com.sparta.steps;

import com.sparta.accounts.Accounts;
import com.sparta.pom.HomePage;
import com.sparta.pom.LoginSignup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Logout {

    @Managed
    LoginSignup loginSignup;
    HomePage homePage;

    @And("I am signed in")
    public void iAmSignedIn() {
        // Write code here that turns the phrase above into concrete actions
        loginSignup.open();
        loginSignup.enterLoginEmail(Accounts.account1.email());
        loginSignup.enterLoginPassword(Accounts.account1.password());
        loginSignup.pressLogin();
    }

    @When("I press sign out")
    public void iPressSignOut() {
        // Write code here that turns the phrase above into concrete actions
        homePage.logOut();
    }

    @Then("I should be signed out of my account")
    public void iShouldBeSignedOutOfMyAccount() {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(getDriver().getCurrentUrl(), Matchers.is("https://automationexercise.com/login"));
    }
}
