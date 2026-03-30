package com.sparta.runner;

import com.sparta.pom.SignupPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestRunner {

        @Managed

        SignupPage signupPage;

        @Test
        @DisplayName("Test the full signup process from start to finish")
        public void testFullSignup() {
                signupPage.open();


                String uniqueEmail = "sparta_tester" + System.currentTimeMillis() + "@test.com";


                signupPage.enterInitialSignup("Kevin", uniqueEmail);


                signupPage.completeFullForm(
                        "Sparta123!",       // Password
                        "15",               // Day
                        "April",            // Month (Must be full name)
                        "1995",             // Year
                        "Kevin",            // First Name
                        "Tester",           // Last Name
                        "123 Sparta Way",   // Address
                        "United States",    // Country
                        "New York",         // State
                        "New York City",    // City
                        "10001",            // Zip Code
                        "07123456789"       // Mobile Number
                );
        }
}