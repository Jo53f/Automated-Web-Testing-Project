package com.sparta.steps;

import com.sparta.pom.ProductDetailsPage;
import com.sparta.pom.ProductsPage;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;


public class ProductDetails {

    @Steps
    ProductDetails productDetails;

    @Given("the user launches the browser")
    public void theUserLaunchesTheBrowser() {
        // Serenity automatically launches browser
    }

    @And("the user navigates to {string}")
    public void theUserNavigatesTo(String url) {
        ProductsPage.openHomePage(url);
    }

    @Then("the home page should be displayed")
    public void theHomePageShouldBeDisplayed() {
        ProductsPage.verifyHomePageVisible();
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        if (button.equalsIgnoreCase("Products")) {
            ProductsPage.clickProductsButton();
        }
    }

    @Then("the All Products page should be displayed")
    public void theAllProductsPageShouldBeDisplayed() {
        ProductsPage.verifyAllProductsPage();
    }

    @And("the products list should be visible")
    public void theProductsListShouldBeVisible() {
        ProductsPage.verifyProductsListVisible();
    }

    @Given("the user is on the All Products page")
    public void theUserIsOnTheAllProductsPage() {
        ProductsPage.clickProductsButton();
        ProductsPage.verifyAllProductsPage();
    }

    @When("the user clicks on {string} for the first product")
    public void theUserClicksOnForTheFirstProduct(String action) {
        if (action.equalsIgnoreCase("View Product")) {
            ProductsPage.clickFirstProduct();
        }
    }

    @Then("the product detail page should be displayed")
    public void theProductDetailPageShouldBeDisplayed() {
        ProductDetailsPage.verifyProductDetailPage();
    }

    @And("the product name should be visible")
    public void theProductNameShouldBeVisible() {
        ProductDetailsPage.verifyProductName();
    }

    @And("the product category should be visible")
    public void theProductCategoryShouldBeVisible() {
        ProductDetailsPage.verifyProductCategory();
    }

    @And("the product price should be visible")
    public void theProductPriceShouldBeVisible() {
        ProductDetailsPage.verifyProductPrice();
    }

    // -------- CART STEPS --------

    @Given("I have nothing in my cart")
    public void iHaveNothingInMyCart() {
        ProductDetailsPage.ensureCartIsEmpty();
    }

    @When("I add {string} to my cart twice")
    public void iAddToMyCartTwice(String productName) {
        ProductDetailsPage.addProductTwice(productName);
    }

    @And("I navigate to the {string} page")
    public void iNavigateToThePage(String page) {
        ProductDetailsPage.navigateToPage(page);
    }

    @Then("I should see {string} in my list")
    public void iShouldSeeInMyList(String productName) {
        ProductDetailsPage.verifyProductInCart(productName);
    }

    @And("the cart count should display {string}")
    public void theCartCountShouldDisplay(String count) {
        ProductDetailsPage.verifyCartCount(count);
    }

    @And("the product availability should be visible")
    public void theProductAvailabilityShouldBeVisible() {
        ProductDetailsPage.verifyProductAvailability();
    }

    @And("the product condition should be visible")
    public void theProductConditionShouldBeVisible() {
        ProductDetailsPage.verifyProductCondition();
    }

    @And("the product brand should be visible")
    public void theProductBrandShouldBeVisible() {
        ProductDetailsPage.verifyProductBrand();
    }
}