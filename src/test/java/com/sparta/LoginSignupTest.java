package com.sparta;

import com.sparta.pom.HomePage;
import com.sparta.pom.LoginSignup;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginSignupTest {

    @Managed
    HomePage homepage;
    LoginSignup login;

    @BeforeEach
    public void setUp() {
        homepage.open();
        homepage.acceptConsent();
        homepage.goToLogin();
    }

    @Test
    @DisplayName("typed username")
    void typingRight(){
        login.enterLoginEmail("hello@hotmail.com");
        login.enterLoginPassword("password1");
        login.pressLogin();

        MatcherAssert.assertThat(login.isLoginError(), Matchers.is(true));
        MatcherAssert.assertThat(login.getLoginError(), Matchers.containsString("Your email or password is incorrect!"));
    }

    @Test
    @DisplayName("No error message if nothing is submitted")
    void noErrorBeforeSubmission(){
        MatcherAssert.assertThat(login.isLoginError(), Matchers.is(false));
    }
}
