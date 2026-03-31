package com.sparta.steps;

import com.sparta.pom.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CartQuantity {
    @Managed
    ProductsPageDetail productsPage;
    HomePageNavigations homePage;
    CartPage cart;

    @Given("They are on the products page")
    public void theyAreOnTheProductsPage() {
        // Write code here that turns the phrase above into concrete actions
        productsPage.open();
        productsPage.acceptConsent();
    }

    @And("have nothing in their cart")
    public void haveNothingInTheirCart() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("add {string} to my cart once")
    public void addToMyCartOnce(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        productsPage.clickAdd1ToCartButton();
        productsPage.clickContinueShopping();
    }

    @And("navigate to the {string} page")
    public void navigateToThePage(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        productsPage.clickCartUsingHref();
    }

    @Then("they should see {string} in the cart")
    public void theyShouldSeeInTheCart(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(cart.isItemInCart(arg0), Matchers.is(true));
    }

    @And("the carts count should display {string}")
    public void theCartsCountShouldDisplay(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(cart.getQuantityForItem(arg0), Matchers.is(arg0));
    }

    @When("adding {string} to my cart twice")
    public void addingToMyCartTwice(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        productsPage.clickAdd1ToCartButton();
        productsPage.clickContinueShopping();
        productsPage.clickAdd1ToCartButton();
        productsPage.clickContinueShopping();
    }

    @And("navigating to the {string} page")
    public void navigatingToThePage(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        getDriver().navigate().to("https://automationexercise.com/view_cart");
    }

    @Then("they should see {string} in my cart")
    public void theyShouldSeeInMyCart(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(cart.isItemInCart(arg0), Matchers.is(true));
    }

    @And("quantity for {string} should be {string}")
    public void quantityForShouldBe(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(cart.getCartItemCount(), Matchers.is(arg1));
    }

    @And("subtotal should reflect {string} times the unit price")
    public void subtotalShouldReflectTimesTheUnitPrice(String arg0) {
        // Write code here that turns the phrase above into concrete actions
//        int subTotal = Integer.parseInt(cart.getProductSubtotal(0)) * 2;
        MatcherAssert.assertThat(cart.getProductSubtotal(0), Matchers.is("Rs. 1000"));
    }
}
