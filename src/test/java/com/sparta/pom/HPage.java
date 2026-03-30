package com.sparta.pom;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("https://automationexercise.com")
public class HPage extends PageObject{

    @FindBy(css = "a[href='/products']")
    private WebElementFacade productsButtonByHref;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    // Alternative method using href locator
    public void clickProductsUsingHref() {
        productsButtonByHref.waitUntilClickable();
        productsButtonByHref.click();
        System.out.println("✓ Clicked Products button using href locator");
        waitABit(1000);
    }

    public void acceptConsent() {
        try {
            if (consentButton != null && consentButton.isCurrentlyVisible()) {
                evaluateJavascript("arguments[0].scrollIntoView(true);", consentButton);
                consentButton.waitUntilClickable().click();
                waitABit(500);
            }
        } catch (Exception e) {
            // Consent button might not appear, that's fine
            System.out.println("Consent button not found or already accepted");
        }
    }

    public void openWithConsent() {
        open();
        waitABit(1000); // Wait for page to load
        acceptConsent();
    }
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }




}
