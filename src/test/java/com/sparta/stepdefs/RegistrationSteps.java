package com.sparta.stepdefs;

import com.sparta.pom.SignupPage;
import com.sparta.pom.AccountDetailsPage;
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
    public void openSignup() {
        signupPage.open();
    }

    @When("they enter name {string} and email {string}")
    public void enterCredentials(String name, String email) {
        signupPage.enterNameAndEmail(name, email);
    }

    @And("they click signup")
    public void clickSignup() {
        signupPage.clickSignup();
    }

    @Then("they should see the error message {string}")
    public void verifySignupError(String expectedMessage) {
        String actualMessage = signupPage.find(By.cssSelector(".signup-form p")).getText();
        assertThat(actualMessage, containsString(expectedMessage));
    }

    @And("they fill account info {string}, {string}, {string}, {string}")
    public void fillAccount(String pass, String d, String m, String y) {
        detailsPage.fillAccountInfo(pass, d, m, y);
    }

    @And("they fill address info {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillAddress(String fn, String ln, String addr, String ctry, String st, String ct, String zip, String mob) {
        detailsPage.fillAddressInfo(fn, ln, addr, ctry, st, ct, zip, mob);
    }

    @And("they click create account")
    public void clickCreate() {
        detailsPage.clickCreateAccount();
    }

    @Then("the account should be created successfully")
    public void verify() {
        assertThat(detailsPage.getDriver().getCurrentUrl(), containsString("account_created"));
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        signupPage.getDriver().get("https://automationexercise.com/login");
    }

    @When("they enter login email {string} and password {string}")
    public void they_enter_login_credentials(String email, String password) {
        signupPage.find(By.cssSelector("form[action='/login'] input[data-qa='login-email']")).type(email);
        signupPage.find(By.cssSelector("form[action='/login'] input[data-qa='login-password']")).type(password);
    }

    @And("they click the login button")
    public void they_click_the_login_button() {
        signupPage.find(By.cssSelector("button[data-qa='login-button']")).click();
    }

    @Then("they should be logged in as {string}")
    public void verifyLoggedInUser(String expectedName) {
        String statusText = signupPage.find(By.partialLinkText("Logged in as")).getText();
        assertThat(statusText, containsString(expectedName));
    }
}