package com.sparta.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://automationexercise.com/contact_us")
public class ContactUs extends PageObject {
    @FindBy(linkText = "Contact us")
    private WebElementFacade contactUsLink;

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
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

    public boolean isGetInTouchVisible() {
        getInTouchHeader.waitUntilVisible();
        return getInTouchHeader.isVisible();
    }

    public void fillForm(String name, String email, String subject, String message) {
        nameInput.type(name);
        emailInput.type(email);
        subjectInput.type(subject);
        messageInput.type(message);
    }

    public void getInTouchIsNotVisible() {
        getInTouchHeader.shouldNotBeVisible();
    }

    public void formShouldNotSubmit() {
        submitButton.shouldNotBeEnabled();
    }

    public void uploadFile(String filePath) {
        String projectRoot = System.getProperty("user.dir");
        String fullPath = projectRoot + "/src/test/resources/" + filePath;
        uploadFileInput.sendKeys(fullPath);
//        uploadFileInput.sendKeys(filePath);
    }

    public void submitForm() {
        submitButton.waitUntilClickable().click();
    }

    public void shouldBeReadyForSubmission() {
        submitButton.shouldBeEnabled();
    }

    public void shouldSeeSuccessMessage() {
        successMessage.shouldBeVisible();
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }

}
