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

        productDetailsPage.acceptConsent();

        productDetailsPage.setQuantity(4);
        productDetailsPage.clickAddToCart();

        assertTrue(productDetailsPage.isSuccessModalVisible());
    }
}
