package stepdefenitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webautomationbatch4.page_factory.pages.CartPage;
import com.webautomationbatch4.page_factory.pages.ConfirmationPage;
import com.webautomationbatch4.page_factory.pages.DashboardPage;
import com.webautomationbatch4.page_factory.pages.LoginPage;
import com.webautomationbatch4.page_factory.pages.OrderPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;

public class StepImpl  {
    WebDriver driver;

    //Pico-container
    public StepImpl(Hooks hooks){
        this.driver = Hooks.getDriver();
    }

    // @Given("User is on the login page")
    // public void user_is_on_the_login_page() throws InterruptedException {
    //     // Write code here that turns the phrase above into concrete actions
    //     this.driver = Hooks.getDriver();
    // }

    @When("User logged in with valid credentials")
    public void user_logged_in_with_valid_credentials() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
         // Implement the test steps here using Page Object Model (POM)
        System.out.println("Login to the application using POM");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("simanjuntakalbert57@gmail.com", "XBf@rWNvByn!#K8");

        // Thread.sleep(3000);
    }

    @When("User logged in with {string} and {string}")
    public void user_logged_in_with(String username, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(username, password);

        // Thread.sleep(3000);
    }

    @Then("User is navigated to the products page")
    public void user_is_navigated_to_the_products_page() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

    @When("User adds a product to the cart {string}")
    public void user_adds_a_product_to_the_cart(String productName) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.addToCart(productName);

        // Thread.sleep(3000);

    }

    @And("User clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(3000);
        cartPage.goToCart();


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

    @Then("User is navigated to checkout page")
    public void user_is_navigated_to_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    
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

    @Then("User verify the order is placed successfully")
    public void user_verify_the_order_is_placed_successfully() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationOrder = confirmationPage.getConfirmationMessage();
        org.testng.Assert.assertTrue(confirmationOrder.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Then("User should see an error message")
    public void error_message(){
        System.out.println("See error message");
    }
}
