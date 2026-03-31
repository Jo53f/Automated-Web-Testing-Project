package com.sparta;

import com.sparta.pom.HomePage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Page Object Model
@ExtendWith(SerenityJUnit5Extension.class)
public class HomePageAndContactUs {

    @Managed
    HomePage homePage;

    @Test
    @DisplayName("Test navbar works")
    public void successfulLoginTest() {
        homePage.open();
        homePage.acceptConsent();
        homePage.goToCart();
    }


}