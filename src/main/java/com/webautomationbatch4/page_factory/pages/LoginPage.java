package com.webautomationbatch4.page_factory.pages;

import org.openqa.selenium.WebDriver;

import com.webautomationbatch4.page_factory.object_repository.LoginObjectRepository;

public class LoginPage {

    private LoginObjectRepository loginObjectRepository;

    public LoginPage(WebDriver driver) {
        this.loginObjectRepository = new LoginObjectRepository(driver);
    }

    public void doLogin(String email, String password){
        loginObjectRepository.userEmail.sendKeys(email);
        loginObjectRepository.userPassword.sendKeys(password);
        loginObjectRepository.loginButton.click();
    }
}
