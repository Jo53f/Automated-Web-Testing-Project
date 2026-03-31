package com.sparta.pom;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {

    @FindBy(css = "a[href='#Women']")
    WebElementFacade womenCategory;

    @FindBy(css = "a[href='#Men']")
    WebElementFacade menCategory;

    @FindBy(css = "a[href='#Kids']")
    WebElementFacade kidsCategory;

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

    public boolean areCategoryOptionsVisible() {
        return womenCategory.isVisible()
                && menCategory.isVisible()
                && kidsCategory.isVisible();
    }

    public void clickWomenCategory() {
        womenCategory.click();
        waitABit(1000);
    }

    public void clickMenCategory() {
        menCategory.waitUntilClickable().click();
    }

    public void clickKidsCategory() {
        kidsCategory.waitUntilClickable().click();
    }

    public WebElementFacade subCategory(String name) {
        return find(By.linkText(name));
    }

    public void clickSubCategory(String name) {
        WebElementFacade element = subCategory(name);
        element.waitUntilVisible().click();
        waitABit(500);
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

    public boolean isSubCategoryVisible(String name) {
        return subCategory(name).isVisible();
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
            consentButton.waitUntilClickable().click();
        } catch (Exception e) {
        }
    }
}
