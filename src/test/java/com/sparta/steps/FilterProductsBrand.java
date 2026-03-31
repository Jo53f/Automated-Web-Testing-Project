package com.sparta.steps;

import com.sparta.pom.ProductsPage;
import io.cucumber.java.en.*;

public class FilterProductsBrand {

    ProductsPage productsPage;

    @Given("I am on the {string} page")
    public void iAmOnThePage(String pageName) {
        productsPage.openAt("http://automationexercise.com");

        if (pageName.equalsIgnoreCase("ALL PRODUCTS")) {
            productsPage.clickProductsButton();
        }
    }

    @And("the brands list is visible on the left sidebar")
    public void theBrandsListIsVisibleOnTheLeftSidebar() {
        productsPage.verifyBrandsListVisible();
    }

    @When("I click on brand {string}")
    public void iClickOnBrand(String brand) {
        productsPage.clickBrand(brand);
    }

    @Then("I should be navigated to the brand-specific page")
    public void iShouldBeNavigatedToTheBrandSpecificPage() {
        productsPage.verifyBrandPageNavigation();
    }

    @And("I should see products belonging to {string} displayed")
    public void iShouldSeeProductsBelongingToDisplayed(String brand) {
        productsPage.verifyBrandProductsDisplayed(brand);

    }
}