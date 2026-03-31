package com.sparta.pom;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@DefaultUrl("https://automationexercise.com/products")
public class ProductsPage extends PageObject {
    @FindBy(xpath = "(//a[contains(@href,'/product_details/')])[1]")
    private  WebElementFacade viewProduct;

    @FindBy(xpath = "(//a[contains(@class,'add-to-cart')])[1]")
    private WebElementFacade addToCart;

    @FindBy(id = "cartModal")
    private WebElementFacade cartModal;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    private WebElementFacade continueShoppingButton;

    public static void clickProductsButton() {
    }

    public static void verifyHomePageVisible() {
    }

    public static void openHomePage(String url) {
    }

    public static void verifyAllProductsPage() {
    }

    public static void verifyProductsListVisible() {
    }

    public static void clickFirstProduct() {
    }

    public  void clickViewProduct() {
        viewProduct.click();
    }

    public void acceptConsent() {
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public  void shouldBeOnProductDetailsPage() {
        getDriver().getCurrentUrl().contains("product_details");
    }

    public void shouldShowAddToCartModal() {
        cartModal.shouldBeVisible();
    }

    public void shouldShowContinueShoppingButton() {
        continueShoppingButton.shouldBeVisible();
    }


    public void searchProduct(String product) {
    }

    public void verifySearchResults(String product) {
    }

    public void verifyNoProductsMessage() {
    }
}
