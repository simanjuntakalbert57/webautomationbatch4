package com.webautomationbatch4.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartObjectRepository {

    @FindBy (css = "button[routerlink*='/cart']")
    public WebElement cartButton;

    @FindBy (xpath = "//li[@class='totalRow']/following::button")
    public WebElement checkoutButton;

    public By cartProduct = By.xpath("//div[@class='cartSection']/h3");

    public CartObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
