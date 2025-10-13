package stepdefenitions;

import org.openqa.selenium.WebDriver;

import com.webautomationbatch4.page_factory.pages.CartPage;

import hook.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDef {
    WebDriver driver;

    //Pico-container
    public CartPageStepDef(Hooks hooks){
        this.driver = Hooks.getDriver();
    }

    @Then("User verify the product is added to the cart {string}")
    public void user_verify_the_product_is_added_to_the_cart(String productName) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyProductInCart(productName);
    }

    @When("User click on the checkout button")
    public void user_click_on_the_checkout_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
        
    }


}
