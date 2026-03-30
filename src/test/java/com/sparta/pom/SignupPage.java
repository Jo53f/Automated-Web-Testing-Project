//package com.sparta.pom;
//
//
//import net.serenitybdd.annotations.DefaultUrl; // Ensure this is the Serenity 4 import
//import net.serenitybdd.core.pages.PageObject;
//import org.openqa.selenium.By;
//
//@DefaultUrl("https://automationexercise.com/login")
//public class SignupPage extends PageObject {
//
//    private final By nameInput = By.cssSelector("input[data-qa='signup-name']");
//    private final By emailInput = By.cssSelector("input[data-qa='signup-email']");
//    private final By signupBtn = By.cssSelector("button[data-qa='signup-button']");
//
//    public void enterNameAndEmail(String name, String email) {
//        $(nameInput).type(name);
//        $(emailInput).type(email);
//    }
//
//    public void clickSignup() {
//        $(signupBtn).click();
//    }
//}