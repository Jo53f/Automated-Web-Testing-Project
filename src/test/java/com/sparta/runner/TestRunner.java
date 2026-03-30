package com.sparta.runner;

import com.sparta.pom.SignupPage;
import com.sparta.pom.AccountDetailsPage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestRunner {

        @Managed
        WebDriver driver;

        @Steps
        SignupPage signupPage;

        @Steps
        AccountDetailsPage detailsPage;

        @Test
        public void testCompleteRegistrationFlow() {
                // PAGE 1: Initial Signup - FIXED LINE BELOW
                signupPage.openAt("https://automationexercise.com/login");

                String uniqueEmail = "sparta" + System.currentTimeMillis() + "@test.com";
                signupPage.enterNameAndEmail("Spartan User", uniqueEmail);
                signupPage.clickSignup();

                // PAGE 2: Detailed Information
                detailsPage.fillAccountInfo("SecurePass123", "10", "July", "1995");
                detailsPage.fillAddressInfo(
                        "John", "Doe", "123 High St",
                        "India", "Maharashtra", "Mumbai", "400001", "9876543210"
                );
                detailsPage.clickCreateAccount();

                // Final Assertion
                assertThat(driver.getCurrentUrl(), containsString("account_created"));
        } // Closes the Method
} // Closes the Class