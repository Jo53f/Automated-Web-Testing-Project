package com.sparta.steps;

import com.sparta.pom.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class NavigateToLoginSteps {

    @Managed
    HomePage homepage;

    @Given("I am on the homepage")
    public void iAmOnTheHomePage() {
        homepage.open();
    }

    @And("I have clicked Signup / Login")
    public void iHaveClickedOnSignUpAndLogin() {
        homepage.goToLogin();
    }

    @Then("I should land on the Signup / Login page")
    public void iShouldLandOnTheInventoryPage() {
        String url = getDriver().getCurrentUrl();
        MatcherAssert.assertThat(url, Matchers.is("https://automationexercise.com/login"));
    }
}
