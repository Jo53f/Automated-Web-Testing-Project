package com.sparta.steps;

import com.sparta.pom.*;
//import com.sparta.pom.ProductsPageDetail;
//import com.sparta.pom.CartPage;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class AutoExTest {

    @Managed
    HomePageNavigations home;
    ProductsPageDetail products;
    LoginSignuptemp login;
    CartPage checkout;

    private WebDriverWait wait;

    @Test
    @DisplayName("Test Case 1: Verify home page loads successfully")
    public void verifyHomePageLoad() {

        home.open();

        home.acceptConsent();


        MatcherAssert.assertThat(
                "URL should match the base URL",
                home.getDriver().getCurrentUrl(),
                Matchers.equalTo("https://automationexercise.com/")
        );



    }

    @Test
    @DisplayName("User Story 12: Add Products into cart with grouped feature.")
    public void add2ItemsFromProductPage(){
        products.open();
        products.acceptConsent();
        products.scrollDown();

        products.clickAdd1ToCartButton();
        products.clickContinueShopping();
        products.clickAdd1ToCartButton();
        products.clickContinueShopping();

        products.clickAdd2ItemToCartButton();
        products.clickContinueShopping();
        products.clickAdd2ItemToCartButton();
        products.clickContinueShopping();
        products.clickAdd2ItemToCartButton();
        products.clickContinueShopping();

        products.clickCartUsingHref();

        assertEquals("2", checkout.getProductQuantity(0));
        assertEquals("3", checkout.getProductQuantity(1));
    }




    @Test
    @DisplayName("Test Case 13: Verify Product Quantity (3) in Cart")
    public void addItemsFromProductPage(){
        products.open();
        products.acceptConsent();
        products.scrollDown();

        products.clickAdd1ToCartButton();
        products.clickContinueShopping();
        products.clickAdd1ToCartButton();
        products.clickContinueShopping();
        products.clickAdd1ToCartButton();
        products.clickContinueShopping();

        products.clickCartUsingHref();


        assertEquals("3", checkout.getProductQuantity(0));

    }


    @Test
    @DisplayName("From product page i want to add first item on the page twice")
    public void addFourItemsFromProductPage(){
        products.open();
        products.acceptConsent();
        products.scrollDown();
        products.clickAdd1ToCartButton();
        products.clickContinueShopping();
        products.clickAdd1ToCartButton();
        products.clickContinueShopping();
        products.clickCartUsingHref();

        checkout.clickCheckoutButton();
//
//        checkout.clickContinueOnCart();

        checkout.clickRegisterLogin();

        login.enterLoginEmail("NewYS@bbj.com");
        login.enterLoginPassword("123");
        login.pressLogin();

        home.goToCart();

        checkout.clickPay();




        MatcherAssert.assertThat(
                "URL should match the base URL",
                products.getCurrentUrl(),
                Matchers.equalTo("https://automationexercise.com/")
        );

    }

    @Test
    @DisplayName("Cart should contain items after adding products")
    public void cartNotEmptyTest() {

        products.openWithConsent();

        products.clickAdd1ToCartButton();
        products.clickContinueShopping();

        products.clickCartUsingHref();
//
//        assertTrue(checkout.hasItemsInCart());
    }
}