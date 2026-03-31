package com.sparta.pom;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".btn.btn-default.check_out")
    private WebElement checkoutButton;

    @FindBy(css = ".btn.btn-default.check_out")
    private WebElement payButton;

    @FindBy(css = ".cart_quantity button")
    private List<WebElementFacade> productQuantities;

    @FindBy(css = "#cart_info_table tbody tr")
    private List<WebElementFacade> cartRows;

    @FindBy(css = ".cart_quantity")
    private List<WebElementFacade> quantityElements;

    @FindBy(css = ".cart_price")
    private List<WebElementFacade> priceElements;

    @FindBy(css = ".cart_total_price")
    private List<WebElementFacade> subtotalElements;

    @FindBy(css = ".cart_quantity_input")
    private List<WebElementFacade> quantityInputs;

    @FindBy(css = ".btn-update, .update-cart")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".btn.btn-success.close-checkout-modal.btn-block")
    private WebElementFacade continueOnCartButton;

    @FindBy(css = "p.text-center a[href='/login']")
    private WebElementFacade registerLoginButton;

    @FindBy(css = ".empty-cart-message, .alert-warning, .cart-empty")
    private WebElementFacade emptyCartMessage;

    public String getProductQuantity(int index) {
        if (productQuantities.size() > index) {
            return productQuantities.get(index).getText().trim();
        }
        return "0";
    }

    public String getProductQuantity() {
        if (!quantityElements.isEmpty()) {
            return quantityElements.get(0).getText().trim();
        }
        return "0";
    }

    public String getProductUnitPrice(int index) {
        if (priceElements.size() > index) {
            return priceElements.get(index).getText().trim();
        }
        return "$0";
    }

    public String getProductSubtotal(int index) {
        if (subtotalElements.size() > index) {
            return subtotalElements.get(index).getText().trim();
        }
        return "$0";
    }

    public void updateQuantity(int index, String newQuantity) {
        if (quantityInputs.size() > index) {
            quantityInputs.get(index).clear();
            quantityInputs.get(index).sendKeys(newQuantity);
        }
    }

    public void clickUpdateCart() {
        if (updateCartButton != null && updateCartButton.isCurrentlyVisible()) {
            updateCartButton.click();
            waitABit(1000);
        }
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void clickContinueOnCart() {
        continueOnCartButton.click();
    }

    public void clickRegisterLogin() {
        registerLoginButton.click();
    }

    public void clickPay() {
        payButton.click();
    }

    public boolean isItemInCart(String itemName) {
        // Find all product rows in the cart table
        List<WebElementFacade> cartRows = findAll(By.cssSelector("#cart_info_table tbody tr"));

        // Loop through each row and check if it contains the item name
        for (WebElementFacade row : cartRows) {
            if (row.getText().contains(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCartEmpty() {
        List<WebElementFacade> cartRows = findAll(By.cssSelector("#cart_info_table tbody tr"));
        return cartRows.isEmpty() ||
                (emptyCartMessage != null && emptyCartMessage.isCurrentlyVisible());
    }

    public String getCartItemCount() {
        List<WebElementFacade> cartRows = findAll(By.cssSelector("#cart_info_table tbody tr"));
        int totalQuantity = 0;

        for (WebElementFacade row : cartRows) {
            WebElementFacade quantityElement = row.find(By.cssSelector(".cart_quantity"));
            if (quantityElement != null) {
                String qtyText = quantityElement.getText().replaceAll("[^0-9]", "");
                if (!qtyText.isEmpty()) {
                    totalQuantity += Integer.parseInt(qtyText);
                }
            }
        }
        return String.valueOf(totalQuantity);
    }

    public String getQuantityForItem(String itemName) {
        List<WebElementFacade> cartRows = findAll(By.cssSelector("#cart_info_table tbody tr"));

        for (WebElementFacade row : cartRows) {
            if (row.getText().contains(itemName)) {
                WebElementFacade quantityElement = row.find(By.cssSelector(".cart_quantity"));
                return quantityElement.getText().trim();
            }
        }
        return "0";
    }

    // Remove all items from cart using the delete button
    public void removeAllItems() {
        List<WebElementFacade> removeButtons = findAll(By.cssSelector(".cart_quantity_delete"));
        for (WebElementFacade button : removeButtons) {
            if (button.isCurrentlyVisible()) {
                button.click();
                waitABit(100);
            }
        }
    }

    // Remove specific item by name using the delete button
    public void removeItem(String itemName) {
        List<WebElementFacade> cartRows = findAll(By.cssSelector("#cart_info_table tbody tr"));

        for (WebElementFacade row : cartRows) {
            if (row.getText().contains(itemName)) {
                // Find the delete button within this row
                WebElementFacade removeButton = row.find(By.cssSelector(".cart_quantity_delete"));
                if (removeButton != null) {
                    removeButton.click();
                    waitABit(500);
                    break;
                }
            }
        }
    }
//
//    public void waitForPageLoad() {
//        waitForRenderedElementsToBePresent(cartRows);
//        waitABit(1000);
//    }

    public String getEmptyCartMessage() {
        if (emptyCartMessage != null && emptyCartMessage.isCurrentlyVisible()) {
            return emptyCartMessage.getText();
        }
        return "";
    }

    public int getCartRowCount() {
        List<WebElementFacade> cartRows = findAll(By.cssSelector("#cart_info_table tbody tr"));
        return cartRows.size();
    }
}