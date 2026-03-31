package com.sparta.pom;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automationexercise.com/products")
public class ProductsPageDetail extends PageObject {


    @FindBy(css = "a[href='/view_cart']")
    private WebElementFacade cartButtonByHref;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;


    @FindBy(css = ".btn.btn-default.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "[data-product-id='1']")
    private WebElementFacade addFirstProductToCartButton;

    @FindBy(css = "[data-product-id='2")
    private WebElementFacade addSecondProductToCartButton;

    // Method 1: Using FindBy annotation
    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    private WebElement continueShoppingButton;

    public void clickAdd1ToCartButton() {
        addFirstProductToCartButton.click();
    }
    public void clickAdd2ItemToCartButton() {
        addSecondProductToCartButton.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }
    public void scrollDown() {
        evaluateJavascript("window.scrollBy(0, 500);");
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




    public void clickCartUsingHref() {
        cartButtonByHref.waitUntilClickable();
        cartButtonByHref.click();
        System.out.println("✓ Clicked Products button using href locator");
        waitABit(1000);
    }






    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

}
