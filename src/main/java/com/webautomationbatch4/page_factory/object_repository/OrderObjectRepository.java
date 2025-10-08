package com.webautomationbatch4.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderObjectRepository {
    
    @FindBy(xpath = "//div[contains(@class, 'user__name')]//following::input[@type='text']")
    public WebElement receiverElement;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    public WebElement selectCountryElement;

    @FindBy(css = ".action__submit")
    public WebElement placeOrderButton;

    public By countryOptions = By.cssSelector("button.ta-item");
    public By elementCountry = By.xpath("//input[@placeholder='Select Country']");


    public OrderObjectRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
