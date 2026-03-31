package com.sparta.steps;

import com.sparta.pom.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class BrowseProductsByCategory {

    @Managed
    HomePage homePage;

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homePage.open();
        homePage.acceptConsent();
    }

    @Then("category options should be visible in the left sidebar")
    public void categoryOptionsShouldBeVisibleInTheLeftSidebar() {
        MatcherAssert.assertThat(homePage.areCategoryOptionsVisible(), Matchers.is(true));
    }

}
