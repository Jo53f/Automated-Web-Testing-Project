package com.sparta.pom;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CPage extends PageObject {

    @FindBy(css = ".btn.btn-default.check_out")
    private WebElement checkoutButton;

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    @FindBy(css = ".btn.btn-success.close-checkout-modal.btn-block")
    private WebElementFacade continueOnCartButton;

    public void clickContinueOnCart() {
        continueOnCartButton.click();
    }

    @FindBy(css = "p.text-center a[href='/login']")
    private WebElementFacade registerLoginButton;

    public void clickRegisterLogin() {
        registerLoginButton.click();
    }



}
