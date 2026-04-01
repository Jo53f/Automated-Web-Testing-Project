package com.sparta.steps;

import com.sparta.pom.ContactUs;
import com.sparta.pom.HomePage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsSteps {

    @Managed
    HomePage homePage;
    ContactUs contactUs;


    @When("the user navigates to the Contact Us page")
    public void navigateToContactUs() {
        homePage.goToContact();
    }

    @Then("the {string} section should be displayed")
    public void verifyGetInTouch(String text) {
        assertTrue(contactUs.isGetInTouchVisible());
    }

    @Given("the user is on the Contact Us page")
    public void userOnContactPage() {
        contactUs.open();
        homePage.acceptConsent();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the user enters valid name, email, subject, message and uploads a compatible file")
    public void the_user_enters_valid_name_email_subject_message_and_uploads_a_compatible_file() {
        contactUs.fillForm("Legend", "theLegend@example.com", "Test", "Hello");
//        File file = new File("src/test/resources/contact_message.txt");
//        contactUs.uploadFile("/Users/leonidas/GitHub/Automated-Web-Testing-Project/src/test/resources/contact_message.txt");
        contactUs.uploadFile("contact_message.txt");
        contactUs.submitForm();
        contactUs.acceptAlert();
    }

    @Then("the form fields should accept the input successfully")
    public void verifyInputs() {
        contactUs.shouldSeeSuccessMessage();  // assertTrue(submitButton.isEnabled());
    }

    @Given("the user leaves required fields empty")
    public void leaveFieldsEmpty() {
    }

    @When("the user attempts to submit the form")
    public void submitForm() {
    }

    @Then("the form should not be submitted")
    public void formShouldNotSubmit() {
        contactUs.formShouldNotSubmit();
    }

}