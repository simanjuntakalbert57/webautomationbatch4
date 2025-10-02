package com.webautomationbatch4.page_factory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomationbatch4.page_factory.object_repository.CartObjectRepository;

public class CartPage {
    CartObjectRepository cartObjectRepository;
    WebDriver driver;

    public CartPage(WebDriver driver) {  
        this.cartObjectRepository = new CartObjectRepository(driver);
        this.driver = driver;
    }

    public void goToCart(){
        cartObjectRepository.cartButton.click();
    }

    public List<WebElement> getAllProductCart(){
        List<WebElement> cartProducts = driver.findElements(cartObjectRepository.cartProduct);
        return cartProducts;
    }

    public Boolean verifyProductInCart(String productName){
         Boolean match = getAllProductCart().stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(productName));
         return match;
    }

    public void goToCheckout(){
        cartObjectRepository.checkoutButton.click();
    }
}
