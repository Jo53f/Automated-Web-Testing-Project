package com.sparta.pom;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com/signup")
public class SignupPage extends PageObject {

    // Locators - Page 1
    private final By initialNameField = By.cssSelector("input[data-qa='signup-name']");
    private final By initialEmailField = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");

    // Locators - Page 2 (Account Info)
    private final By passwordField = By.id("password");
    private final By daysDropdown = By.id("days");
    private final By monthsDropdown = By.id("months");
    private final By yearsDropdown = By.id("years");

    // Locators - Page 2 (Address Info)
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By addressField = By.id("address1");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    public void enterInitialSignup(String name, String email) {
        $(initialNameField).type(name);
        $(initialEmailField).type(email);
        $(signupButton).click();
    }

    public void completeFullForm(String pass, String d, String m, String y,
                                 String fn, String ln, String add, String count,
                                 String st, String ct, String zip, String mob) {

        // Wait for Page 2 to load
        $(passwordField).waitUntilVisible();

        $(passwordField).type(pass);
        $(daysDropdown).selectByValue(d);
        $(monthsDropdown).selectByVisibleText(m); // e.g., "April"
        $(yearsDropdown).selectByValue(y);

        $(firstNameField).type(fn);
        $(lastNameField).type(ln);
        $(addressField).type(add);
        $(countryDropdown).selectByVisibleText(count); // e.g., "United States"
        $(stateField).type(st);
        $(cityField).type(ct);
        $(zipcodeField).type(zip);
        $(mobileNumberField).type(mob);

        $(createAccountButton).click();
    }
}