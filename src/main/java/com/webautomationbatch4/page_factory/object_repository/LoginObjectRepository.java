package com.webautomationbatch4.page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjectRepository {

    // Define web elements using @FindBy annotation
    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "userPassword")
    public WebElement userPassword;

    @FindBy(css = "input.login-btn")
    public WebElement loginButton;

    public LoginObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
