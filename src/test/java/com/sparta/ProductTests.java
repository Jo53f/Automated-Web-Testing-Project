package com.sparta;

import com.sparta.pom.ProductDetailsPage;
import com.sparta.pom.ProductsPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class ProductTests {

    @Managed
    WebDriver driver;

    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    @Test
    public void verifyAddToCartWithQuantity() {

        productsPage.open();
        productsPage.acceptConsent();

        productsPage.clickViewProduct();
        productsPage.shouldBeOnProductDetailsPage();


        productDetailsPage.setQuantity(4);
        productDetailsPage.clickAddToCart();

        assertTrue(productDetailsPage.isSuccessModalVisible());
    }

//    @Test
//    public void verifyAllProductsAndProductDetails() {
//
//        // Step 1–3: Open home page
//        productsPage.open();
//        productsPage.acceptConsent();
//        assertTrue(productsPage.isHomePageVisible(), "Home page should be visible");
//
//        // Step 4: Click Products
//        productsPage.clickProductsButton();
//
//        // Step 5: Verify ALL PRODUCTS page
//        assertTrue(productsPage.isAllProductsPageVisible(), "All Products page should be visible");
//
//        // Step 6: Verify products list
//        assertTrue(productsPage.isProductsListVisible(), "Products list should be visible");
//
//        // Step 7: Click first product's View Product
//        productsPage.clickViewProduct();
//
//        // Step 8: Verify user is on product detail page
//        assertTrue(productDetailsPage.isOnProductDetailsPage(), "Should be on product details page");
//
//        // Step 9: Verify product details
//        assertTrue(productDetailsPage.isProductNameVisible());
//        assertTrue(productDetailsPage.isCategoryVisible());
//        assertTrue(productDetailsPage.isPriceVisible());
//        assertTrue(productDetailsPage.isAvailabilityVisible());
//        assertTrue(productDetailsPage.isConditionVisible());
//        assertTrue(productDetailsPage.isBrandVisible());
//    }

}
