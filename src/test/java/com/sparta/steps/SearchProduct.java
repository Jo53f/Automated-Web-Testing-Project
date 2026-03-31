package com.sparta.steps;

import com.sparta.pom.ProductsPage;
import io.cucumber.java.en.*;

public class SearchProduct {

    ProductsPage productsPage;

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        productsPage.openAt("http://automationexercise.com");
        productsPage.clickProductsButton();
    }

    @When("I search for a product named {string}")
    public void iSearchForAProductNamed(String product) {
        productsPage.searchProduct(product);
    }

    @Then("I should see results related to {string}")
    public void iShouldSeeResultsRelatedTo(String product) {
        productsPage.verifySearchResults(product);
    }

    @Then("I should see a message saying no products found")
    public void iShouldSeeAMessageSayingNoProductsFound() {
        productsPage.verifyNoProductsMessage();
    }
}