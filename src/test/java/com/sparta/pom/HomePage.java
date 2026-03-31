package com.sparta.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

    @FindBy(linkText = "Logout")
    private WebElementFacade logoutLink;

    @FindBy(linkText = "Delete Account")
    private WebElementFacade deleteAccountLink;

    @FindBy(css = ".recommended-items .carousel-item.active .productinfo h4 a")
    private WebElementFacade recommendedItemName;

    @FindBy(css = ".recommended-items")
    private WebElementFacade recommendedItemsSection;

    @FindBy(css = "a[data-product-id='4']")
    private WebElementFacade addToCartButton;

    @FindBy(css  = "a[href='/view_cart']")
    private WebElementFacade cartButtonByHref;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

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

    public void logOut() {
        loginLink.click();
    }

    public void deleteAccount() {
        deleteAccountLink.click();
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

    public void scrollToVeryBottom() {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight);");
        waitABit(1000);

    }
    public void addRecommendedItemToCart() {
        addToCartButton.click();
        waitABit(50);
    }
    public String getRecommendedItemName() {
        return recommendedItemName.getText();
    }

    @FindBy(css = ".btn.btn-success.close-modal.btn-block")
    private WebElement continueShoppingButton;

    public void clickContinueShopping() {
           continueShoppingButton.click();
            waitABit(500);

    }

    public void clickCartButton() {
        cartButtonByHref.waitUntilClickable();
        cartButtonByHref.click();
        waitABit(1000);
    }

    public void addItemFromRecommendedSection() {
        scrollToVeryBottom();
        waitABit(100);
        addRecommendedItemToCart();
        waitABit(500);
    }


}