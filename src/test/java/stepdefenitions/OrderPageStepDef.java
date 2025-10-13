package stepdefenitions;

import org.openqa.selenium.WebDriver;

import com.webautomationbatch4.page_factory.pages.OrderPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class OrderPageStepDef {

    WebDriver driver;

    //Pico-container
    public OrderPageStepDef(Hooks hooks){
        this.driver = Hooks.getDriver();
    }

    @When("User fills in the shipping details")
    public void user_fills_in_the_shipping_details() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // Shipping page
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillShippingDetails("simanjuntakalbert57@gmail.com", "Indonesia");
        orderPage.placeOrder();
    }

    @And("User click on the Place Order button")
    public void user_click_on_the_place_order_button() {
        // Write code here that turns the phrase above into concrete actions
        OrderPage orderPage = new OrderPage(driver);
        orderPage.placeOrder();
    }
    
}
