package com.sparta.steps;

import com.sparta.pom.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BrowseProductsByCategory {

    @Managed
    HomePage homePage;

    // @When ("the user is on the home page") is shared from ContactUsSteps

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homePage.open();
        homePage.acceptConsent();
    }

//    @When("the user clicks on the {string} category")
//    public void userClicksCategory(String category) {
//        switch (category.toLowerCase()) {
//            case "women":
//                homePage.clickWomenCategory();
//                break;
//            case "men":
//                homePage.clickMenCategory();
//                break;
//            case "kids":
//                homePage.clickKidsCategory();
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown category: " + category);
//        }
//    }
//
//    @Then("the category page should be displayed")
//    public void theCategoryPageShouldBeDisplayed() {
//        assertThat(homePage.isSubCategoryVisible("Dress")).isTrue();
//    }

    @Then("category options should be visible in the left sidebar")
    public void categoryOptionsShouldBeVisibleInTheLeftSidebar() {
        homePage.areCategoryOptionsVisible();
    }

}
