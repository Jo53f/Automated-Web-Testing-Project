package com.sparta.steps;

import com.sparta.pom.ContactUs;
import com.sparta.pom.HomePage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsSteps {

    @Managed
    HomePage homePage;
    ContactUs contactUs;


    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        homePage.open(); // uses @DefaultUrl
    }

    @When("the user navigates to the Contact Us page")
    public void navigateToContactUs() {
        homePage.goToContact();
    }

    @Then("the {string} section should be displayed")
    public void verifyGetInTouch(String text) {
        contactUs.getInTouchIsVisible();
    }

    @Given("the user is on the Contact Us page")
    public void userOnContactPage() {
        contactUs.open();
    }

    @When("the user enters valid name, email, subject and message and uploads a file")
    public void fillForm() {
        contactUs.fillForm("Legend", "theLegend@example.com", "Test", "Hello");
        contactUs.uploadFile("src/test/resources/testfile.txt");
    }

    @Then("the form fields should accept the input successfully")
    public void verifyInputs() {
        contactUs.shouldBeReadyForSubmission();  // assertTrue(submitButton.isEnabled());
    }



}