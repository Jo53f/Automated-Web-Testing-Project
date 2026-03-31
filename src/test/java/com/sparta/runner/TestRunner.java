package com.sparta.runner;

import com.sparta.pom.AccountDetailsPage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestRunner {

        @Managed
        WebDriver driver;

        @Steps
        SignupPage signupPage;

        @Steps
        AccountDetailsPage detailsPage;
}




