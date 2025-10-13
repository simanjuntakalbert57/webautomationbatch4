package stepdefenitions;

import org.openqa.selenium.WebDriver;

import com.webautomationbatch4.page_factory.pages.LoginPage;

import hook.Hooks;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

    WebDriver driver;

    //Pico-container
    public LoginPageStepDef(Hooks hooks){
        this.driver = Hooks.getDriver();
    }

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

    
}
