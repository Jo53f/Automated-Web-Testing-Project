package com.sparta.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://automationexercise.com/contact_us")
public class ContactUs extends PageObject {
    @FindBy(linkText = "Contact us")
    private WebElementFacade contactUsLink;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    private WebElementFacade getInTouchHeader;

    @FindBy(name = "name")
    private WebElementFacade nameInput;

    @FindBy(name = "email")
    private WebElementFacade emailInput;

    @FindBy(name = "subject")
    private WebElementFacade subjectInput;

    @FindBy(name = "message")
    private WebElementFacade messageInput;

    @FindBy(name = "upload_file")
    private WebElementFacade uploadFileInput;

    @FindBy(name = "submit")
    private WebElementFacade submitButton;

    @FindBy(xpath = "//*[contains(text(),'Success! Your details have been submitted successfully.')]")
    private WebElementFacade successMessage;

    @FindBy(linkText = "Home")
    private WebElementFacade homeButton;

    public void getInTouchIsVisible() {
        getInTouchHeader.shouldBeVisible();
    }

    public void fillForm(String name, String email, String subject, String message) {
        nameInput.type(name);
        emailInput.type(email);
        subjectInput.type(subject);
        messageInput.type(message);
    }

    public void uploadFile(String filePath) {
        uploadFileInput.sendKeys(filePath);
    }

    public void submitForm() {
        submitButton.waitUntilClickable().click();
    }

    public void shouldBeReadyForSubmission() {
        submitButton.shouldBeEnabled();
    }

}
