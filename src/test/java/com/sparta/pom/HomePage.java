package com.sparta.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {

    @FindBy(linkText = "Home")
    private WebElementFacade homeLink;

    @FindBy(linkText = "Products")
    private WebElementFacade productsLink;

    @FindBy(linkText = "Cart")
    private WebElementFacade cartLink;

    @FindBy(linkText = "Signup / Login")
    private WebElementFacade loginLink;

    @FindBy(linkText = "Contact us")
    private WebElementFacade contactLink;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    public void goToHome() {
        homeLink.click();
    }

    public void goToProducts() {
        productsLink.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public void goToLogin() {
        loginLink.click();
    }

    public void goToContact() {
        contactLink.click();
    }

    public void acceptConsent() {
        try {
            if (consentButton.isVisible()) {
                consentButton.waitUntilClickable().click();
                consentButton.waitUntilNotVisible();
            }
        } catch (Exception e) {
        }
    }
}
