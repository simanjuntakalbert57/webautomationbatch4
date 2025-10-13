package stepdefenitions;

import org.openqa.selenium.WebDriver;

import com.webautomationbatch4.page_factory.pages.ConfirmationPage;

import hook.Hooks;
import io.cucumber.java.en.Then;

public class ConfirmationPageStepDef {
    WebDriver driver;

    //Pico-container
    public ConfirmationPageStepDef(Hooks hooks){
        this.driver = Hooks.getDriver();
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
