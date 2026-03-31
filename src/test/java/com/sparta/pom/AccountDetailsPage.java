package com.sparta.pom;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class AccountDetailsPage extends PageObject {

    private final By passwordField = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By address = By.id("address1");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile = By.id("mobile_number");
    private final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");

    public void fillAccountInfo(String password, String d, String m, String y) {
        // CORRECTION: Wait for the element to appear before interacting
        // This prevents the NoSuchElementException during page transitions
        $(passwordField).waitUntilVisible().type(password);

        $(days).selectByValue(d);
        $(months).selectByVisibleText(m);
        $(years).selectByValue(y);
    }

    public void fillAddressInfo(String fn, String ln, String addr, String ctry, String st, String ct, String zip, String mob) {
        // It's good practice to ensure the first element of a new section is visible too
        $(firstName).waitUntilVisible().type(fn);
        $(lastName).type(ln);
        $(address).type(addr);
        $(country).selectByVisibleText(ctry);
        $(state).type(st);
        $(city).type(ct);
        $(zipcode).type(zip);
        $(mobile).type(mob);
    }

    public void clickCreateAccount() {
        $(createAccountBtn).click();
    }
}