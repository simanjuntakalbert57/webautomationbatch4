package com.webautomationbatch4.page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationObjectRepository {

    @FindBy (css = ".hero-primary")
    public WebElement confirmationMessage;
    
    public ConfirmationObjectRepository(WebDriver driver)  {
        PageFactory.initElements(driver, this);
    }

}
