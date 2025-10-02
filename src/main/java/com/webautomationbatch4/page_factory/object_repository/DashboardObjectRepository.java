package com.webautomationbatch4.page_factory.object_repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjectRepository {

    public By listProducts = By.cssSelector(".mb-3");
    public By addToCartButton = By.cssSelector(".card-body button:last-of-type");
    public By productName = By.cssSelector("b");
    
    public DashboardObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
