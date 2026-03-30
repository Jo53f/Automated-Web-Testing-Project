package com.sparta;

import com.sparta.pom.ProductPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class ProductTests {

    @Managed

    ProductPage productPage;

    @Test
    public void verifyAddToCartWithQuantity() {



        // Open the specific product page
        productPage.open();

        // Perform actions
        productPage.setQuantity(4);
        productPage.clickAddToCart();

        // Assertion
        assertTrue(productPage.isSuccessModalVisible());
    }
}
