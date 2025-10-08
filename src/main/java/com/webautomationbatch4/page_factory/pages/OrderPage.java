package com.webautomationbatch4.page_factory.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomationbatch4.abstractcomponents.AbstractComponents;
import com.webautomationbatch4.page_factory.object_repository.CartObjectRepository;
import com.webautomationbatch4.page_factory.object_repository.OrderObjectRepository;

public class OrderPage extends AbstractComponents {
    OrderObjectRepository orderObjectRepository;
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.orderObjectRepository = new OrderObjectRepository(driver);
        this.driver = driver;
    }

    public void chooseCountry(String country){
        List<WebElement> countryOptions = driver.findElements(orderObjectRepository.countryOptions);
        WebElement countryElement = countryOptions.stream().filter(count -> count.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
        countryElement.click();
    }

    public void fillShippingDetails(String receiver, String country){
        visibilityElement(orderObjectRepository.elementCountry);
        orderObjectRepository.receiverElement.sendKeys(receiver);
        orderObjectRepository.selectCountryElement.sendKeys(country);
        chooseCountry(country);
    }

    public void placeOrder(){
        orderObjectRepository.placeOrderButton.click();
    }
}
