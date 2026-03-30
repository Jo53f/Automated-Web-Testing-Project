package com.sparta.pom;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://automationexercise.com")
public class HomePage extends PageObject {

    @FindBy(id = "slider-carousel")
    private WebElementFacade sliderCarousel;

    @FindBy(id = "header")
    private WebElementFacade header;

    @FindBy(linkText = "Products")
    private WebElementFacade productsButton;

    @FindBy(css = "a[href='/products']")
    private WebElementFacade productsButtonByHref;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    @FindBy(css = ".shop-menu")
    private WebElementFacade navigationMenu;

    @FindBy(css = "button[aria-label='Close']")
    private WebElementFacade closePopupButton;

    public void clickProducts() {
        // Wait for the navigation menu to be visible
        navigationMenu.waitUntilVisible();

        // Scroll the products button into view
        evaluateJavascript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productsButton);
        waitABit(500);

        // Ensure the button is clickable and click it
        productsButton.waitUntilClickable();
        productsButton.click();
        System.out.println("✓ Clicked Products button");

        // Wait for page transition
        waitABit(1000);
    }


    // Alternative method using href locator
    public void clickProductsUsingHref() {
        navigationMenu.waitUntilVisible();
        productsButtonByHref.waitUntilClickable();
        productsButtonByHref.click();
        System.out.println("✓ Clicked Products button using href locator");
        waitABit(1000);
    }

    public boolean isHomePageVisible() {
        try {
            sliderCarousel.waitUntilVisible();
            boolean titleContains = getDriver().getTitle().contains("Automation Exercise");
            System.out.println("Page title: " + getDriver().getTitle());
            return titleContains && sliderCarousel.isCurrentlyVisible();
        } catch (Exception e) {
            System.out.println("Error checking homepage visibility: " + e.getMessage());
            return false;
        }
    }

//    public void acceptConsent() {
//        try {
//            if (consentButton != null && consentButton.isCurrentlyVisible()) {
//                evaluateJavascript("arguments[0].scrollIntoView(true);", consentButton);
//                consentButton.waitUntilClickable().click();
//                waitABit(500);
//            }
//        } catch (Exception e) {
//            // Consent button might not appear, that's fine
//            System.out.println("Consent button not found or already accepted");
//        }
//    }

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

    public void waitForPageToLoad() {
        sliderCarousel.waitUntilVisible();
        header.waitUntilVisible();
    }



}