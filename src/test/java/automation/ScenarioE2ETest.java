package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.webautomationbatch4.page_factory.pages.CartPage;
import com.webautomationbatch4.page_factory.pages.ConfirmationPage;
import com.webautomationbatch4.page_factory.pages.DashboardPage;
import com.webautomationbatch4.page_factory.pages.LoginPage;
import com.webautomationbatch4.page_factory.pages.OrderPage;

public class ScenarioE2ETest {
    public WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {
        System.out.println("Before method in ScenarioE2ETest class");
        System.setProperty("webdriver.chrome.driver","/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
    }


    @Test
    public void scenarioCheckout() throws InterruptedException {
        System.out.println("This is the scenario checkout test");
        /*
         * Steps to be implemented:
         * 1. Login to the application
         * 2. Add a product to the cart
         * 3. Proceed to checkout
         * 4. Verify the order confirmation
         */


        // Implement the test steps here
        System.out.println("Login to the application");
        driver.findElement(By.id("userEmail")).sendKeys("simanjuntakalbert57@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("XBf@rWNvByn!#K8");
        driver.findElement(By.cssSelector("input.login-btn")).click();

        Thread.sleep(3000);
        //Implement add product to cart
        List<WebElement> listProducts = driver.findElements(By.cssSelector(".mb-3"));
        // // step , looping->filtering
        // for(WebElement prod : listProducts) {
        //     System.out.println("Element text" + prod.findElement(By.cssSelector("b")).getText());
        //     if (prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ADIDAS ORIGINAL")) {
        //         prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        //         break;
        //     }else if
        // }

        WebElement product = listProducts.stream().filter(prod -> 
        prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ADIDAS ORIGINAL")).findFirst().orElse(null);
        
        
        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.cssSelector("button[routerlink*='/cart']")).click();

        // Verify the product in the cart
        Thread.sleep(3000);
        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
        Boolean match = cartProducts.stream().anyMatch(prod -> prod.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
        
        org.testng.Assert.assertTrue(match);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@class='totalRow']/following::button")).click();

        // Shipping page
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class, 'user__name')]//following::input[@type='text']")).sendKeys("simanjuntakalbert57@gmail.com");

        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
        Thread.sleep(3000);

        List<WebElement> countryOptions = driver.findElements(By.cssSelector("button.ta-item"));
        System.out.println("Total country options: " + countryOptions.size());
        System.out.println("List of country options: "+ countryOptions.get(0).getText());

        WebElement country = countryOptions.stream().filter(count -> count.getText().equalsIgnoreCase("Indonesia")).findFirst().orElse(null);
        country.click();

        driver.findElement(By.cssSelector(".action__submit")).click();

        
        Thread.sleep(3000);

        // Order confirmation
        String confirmationOrder = driver.findElement(By.className("hero-primary")).getText();
        org.testng.Assert.assertTrue(confirmationOrder.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }


    @Test
    public void initialCreateUntilDelete(){
        // Create -> idBooking
        // Update -> idBooking dari create
        // Delete -> idBooking dari create
    }

     @Test
    public void scenarioCheckoutPOM() throws InterruptedException {
        System.out.println("This is the scenario checkout test using POM");
        /*
         * Steps to be implemented:
         * 1. Login to the application
         * 2. Add a product to the cart
         * 3. Proceed to checkout
         * 4. Verify the order confirmation
         */

        // Implement the test steps here using Page Object Model (POM)
        System.out.println("Login to the application using POM");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("simanjuntakalbert57@gmail.com", "XBf@rWNvByn!#K8");

        Thread.sleep(3000);

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.addToCart("ADIDAS ORIGINAL");

        Thread.sleep(3000);

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        Thread.sleep(3000);
        
        Boolean match = cartPage.verifyProductInCart("ADIDAS ORIGINAL");
        org.testng.Assert.assertTrue(match);

        Thread.sleep(3000);
        cartPage.goToCheckout();

        // Shipping page
        Thread.sleep(3000);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillShippingDetails("simanjuntakalbert57@gmail.com", "Indonesia");
        orderPage.placeOrder();


        // Order confirmation

        Thread.sleep(3000);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationOrder = confirmationPage.getConfirmationMessage();
        org.testng.Assert.assertTrue(confirmationOrder.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        System.out.println("After method in ScenarioE2ETest class");
        Thread.sleep(3000);
        System.out.println("After method in Exploration class");
        driver.quit();
    }
}
