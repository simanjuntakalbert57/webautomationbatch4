package stepdefenitions;

import org.openqa.selenium.WebDriver;

import com.webautomationbatch4.page_factory.pages.CartPage;
import com.webautomationbatch4.page_factory.pages.DashboardPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DashboardPageStepDef {
    WebDriver driver;

    //Pico-container
    public DashboardPageStepDef(Hooks hooks){
        this.driver = Hooks.getDriver();
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
    
}
