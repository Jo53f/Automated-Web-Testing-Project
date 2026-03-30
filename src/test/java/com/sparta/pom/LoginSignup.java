package com.sparta.pom;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com/login")
public class LoginSignup extends PageObject {

    @FindBy(css = "input[data-qa='login-email']")
    private WebElementFacade loginEmail;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElementFacade loginPassword;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElementFacade signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElementFacade signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElementFacade signupButton;

    @FindBy(css = ".login-form p[style*='color: red']")
    private WebElementFacade loginError;

    @FindBy(css = ".signup-form p[style*='color: red']")
    private WebElementFacade signupError;

    @FindBy(css = "button[aria-label='Consent']")
    private WebElementFacade consentButton;

    public void enterLoginEmail(String email) {
        loginEmail.type(email);
    }

    public void enterLoginPassword(String password) {
        loginPassword.type(password);
    }

    public void pressLogin() {
        loginButton.click();
    }

    public void enterSignupName(String name) {
        signupName.type(name);
    }

    public void enterSignupEmail(String email) {
        signupEmail.type(email);
    }

    public void pressSignup() {signupButton.click();}

    public boolean isLoginError() {
        return loginError.isVisible();
    }

    public String getLoginError(){
        return loginError.getTextContent();
    }

    public boolean isSignupError() {
        return signupError.isVisible();
    }

    public String getSignupError() {
        return signupError.getText();
    }

    public void acceptConsent() {
        try {
            if (consentButton.isVisible()) {
                consentButton.waitUntilClickable().click();
                consentButton.waitUntilNotVisible();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}