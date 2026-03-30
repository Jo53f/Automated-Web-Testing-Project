package com.sparta.steps;

import com.sparta.pom.*;
//import com.sparta.pom.ProductsPage;
//import com.sparta.pom.CartPage;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class AutoExTest {

    @Managed
    HomePage homePage;
    HPage home;

    @Managed
    PPage products;

    @Managed
    CPage checkout;

    @Managed
    ProductsPage productsPage;

    @Managed
    LoginSignup login;

    @Managed
    CartPage cartPage;

    private WebDriverWait wait;

    @Test
    @DisplayName("Test Case 1: Verify home page loads successfully")
    public void verifyHomePageLoad() {

        home.open();

        home.acceptConsent();


        MatcherAssert.assertThat(
                "URL should match the base URL",
                home.getCurrentUrl(),
                Matchers.equalTo("https://automationexercise.com/")
        );



    }




    @Test
    @DisplayName("From product page i want to add one items")
    public void addItemsFromProductPage(){
        products.open();
        products.acceptConsent();
        products.scrollDown();
        products.clickAddToCartButton();
        products.clickContinueShopping();
        products.clickCartUsingHref();

        checkout.clickCheckoutButton();
//
//        checkout.clickContinueOnCart();

        checkout.clickRegisterLogin();

        login.enterLoginEmail("hello@hotmail.com");
        login.enterLoginPassword("password1");
        login.pressLogin();



        MatcherAssert.assertThat(
                "URL should match the base URL",
                products.getCurrentUrl(),
                Matchers.equalTo("https://automationexercise.com/view_cart")
        );

    }





//
//    private void waitABit(long milliseconds) {
//        try {
//            Thread.sleep(milliseconds);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }

//        System.out.println("Step 2: Products page loaded successfully");
//
//        // Step 3: Get initial product count
//        int initialProductCount = productsPage.getProductCount();
//        System.out.println("Total products available: " + initialProductCount);
//
//        // Step 4: Add first product to cart
//        productsPage.addFirstProductToCart();
//        System.out.println("Step 3: Added first product to cart");
//
//        // Step 5: Click View Cart button from modal
//        productsPage.clickViewCart();
//        System.out.println("Step 4: Clicked View Cart button");
//
//        // Step 6: Verify cart page is displayed
//        MatcherAssert.assertThat(
//                "Cart page should be displayed",
//                cartPage.isCartPageDisplayed(),
//                Matchers.is(true)
//        );
//
//        // Step 7: Verify cart contains items
//        MatcherAssert.assertThat(
//                "Cart should contain items",
//                cartPage.hasItemsInCart(),
//                Matchers.is(true)
//        );
//
//        // Step 8: Verify cart has exactly 1 item
//        int cartItemCount = cartPage.getCartItemCount();
//        MatcherAssert.assertThat(
//                "Cart should have 1 item",
//                cartItemCount,
//                Matchers.equalTo(1)
//        );
//
//        // Step 9: Verify product name is displayed
//        String productName = cartPage.getFirstProductName();
//        MatcherAssert.assertThat(
//                "Product name should not be empty",
//                productName,
//                Matchers.not(Matchers.isEmptyOrNullString())
//        );
//
//        System.out.println("Step 5: Product in cart: " + productName);
//
//        // Step 10: Verify quantity is displayed
//        String quantity = cartPage.getFirstProductQuantity();
//        MatcherAssert.assertThat(
//                "Quantity should be displayed",
//                quantity,
//                Matchers.not(Matchers.isEmptyOrNullString())
//        );
//
//        System.out.println("Product quantity: " + quantity);
//        System.out.println("✓ Test Case 2 passed: Product successfully added to cart");
//    }
}