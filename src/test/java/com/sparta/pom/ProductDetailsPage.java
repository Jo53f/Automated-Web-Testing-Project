package com.sparta.pom;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/product_details/{productId}")
public class ProductDetailsPage extends PageObject {

    // Product information
    @FindBy(css = ".product-information h2")
    private WebElementFacade productName;

    @FindBy(css = ".product-information span span")
    private WebElementFacade productPrice;

    @FindBy(css = "#quantity")
    private  WebElementFacade quantityInput;

    @FindBy(css = ".cart")
    private  WebElementFacade addToCartButton;

    // Modal + navigation
    @FindBy(css = "#cartModal")
    private  WebElementFacade successModal;

    @FindBy(css = "a[href='/view_cart']")
    private WebElementFacade viewCartButton;

    // Product details (category, availability, condition, brand)
    @FindBy(css = ".product-information p:nth-of-type(1)")
    private WebElementFacade category;

    @FindBy(css = ".product-information p:nth-of-type(2)")
    private WebElementFacade availability;

    @FindBy(css = ".product-information p:nth-of-type(3)")
    private WebElementFacade condition;

    @FindBy(css = ".product-information p:nth-of-type(4)")
    private WebElementFacade brand;

    @FindBy(css = "button[aria-label='Consent']")
    private  WebElementFacade consentButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public  void setQuantity(int qty) {
        quantityInput.clear();
        quantityInput.type(String.valueOf(qty));
    }

    public  void clickAddToCart() {
        addToCartButton.click();
    }

    public  boolean isSuccessModalVisible() {
        return successModal.isVisible();
    }

    public void clickViewCart() {
        viewCartButton.click();
    }

    public boolean isProductDetailVisible() {
        return productName.isVisible()
                && category.isVisible()
                && productPrice.isVisible()
                && availability.isVisible()
                && condition.isVisible()
                && brand.isVisible();
    }

    public  void acceptConsent() {
        try {
            if (consentButton.isVisible()) {
                consentButton.waitUntilClickable().click();
                consentButton.waitUntilNotVisible();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void openWithId(int productId) {
        getDriver().navigate().to(String.format("https://automationexercise.com/product_details/%d", productId));
    }
}


