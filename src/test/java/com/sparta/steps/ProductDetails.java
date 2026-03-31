package com.sparta.steps;

import com.sparta.pom.ProductDetailsPage;
import com.sparta.pom.ProductsPage;
import io.cucumber.java.en.*;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductDetails {

    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;

    @Given("the user launches the browser")
    public void theUserLaunchesTheBrowser() {
        // handled by Serenity
    }

    @And("the user navigates to {string}")
    public void theUserNavigatesTo(String url) {
        productsPage.openAt(url);
    }

    @Then("the home page should be displayed")
    public void theHomePageShouldBeDisplayed() {
        productsPage.verifyHomePageVisible();
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        if (button.equalsIgnoreCase("Products")) {
            productsPage.clickProductsButton();
        }
    }

    @Then("the All Products page should be displayed")
    public void theAllProductsPageShouldBeDisplayed() {
        productsPage.verifyAllProductsPage();
    }

    @And("the products list should be visible")
    public void theProductsListShouldBeVisible() {
        productsPage.verifyProductsListVisible();
    }

    @Given("the user is on the All Products page")
    public void theUserIsOnTheAllProductsPage() {
        productsPage.clickProductsButton();
        productsPage.verifyAllProductsPage();
    }

    @When("the user clicks on {string} for the first product")
    public void theUserClicksOnForTheFirstProduct(String action) {
        if (action.equalsIgnoreCase("View Product")) {
            productsPage.clickFirstProduct();
        }
    }

    @Then("the product detail page should be displayed")
    public void theProductDetailPageShouldBeDisplayed() {
        productDetailsPage.verifyProductDetailPage();
    }

    @And("the product name should be visible")
    public void theProductNameShouldBeVisible() {
        productDetailsPage.verifyProductName();
    }

    @And("the product category should be visible")
    public void theProductCategoryShouldBeVisible() {
        productDetailsPage.verifyProductCategory();
    }

    @And("the product price should be visible")
    public void theProductPriceShouldBeVisible() {
        productDetailsPage.verifyProductPrice();
    }

    @And("the product availability should be visible")
    public void theProductAvailabilityShouldBeVisible() {
        productDetailsPage.verifyProductAvailability();
    }

    @And("the product condition should be visible")
    public void theProductConditionShouldBeVisible() {
        productDetailsPage.verifyProductCondition();
    }

    @And("the product brand should be visible")
    public void theProductBrandShouldBeVisible() {
        productDetailsPage.verifyProductBrand();
    }

    // -------- CART --------

    @Given("I have nothing in my cart")
    public void iHaveNothingInMyCart() {
        productDetailsPage.ensureCartIsEmpty();
    }

    @When("I add {string} to my cart twice")
    public void iAddToMyCartTwice(String productName) {
        productDetailsPage.addProductTwice(productName);
    }

    @And("I navigate to the {string} page")
    public void iNavigateToThePage(String page) {
        productDetailsPage.navigateToPage(page);
    }

    @Then("I should see {string} in my list")
    public void iShouldSeeInMyList(String productName) {
        productDetailsPage.verifyProductInCart(productName);
    }

    @And("the cart count should display {string}")
    public void theCartCountShouldDisplay(String count) {
        productDetailsPage.verifyCartCount(count);
    }
    }