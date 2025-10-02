package automation;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class StandAloneTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.out.println("Before method in ScenarioE2ETest class");
        System.setProperty("webdriver.chrome.driver","/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofMillis(4000));

        Thread.sleep(3000);
    }

    @Test
    public void validLoginTest() throws InterruptedException{
        Thread.sleep(4000);

        System.out.println("This is test method");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("input.submit-button")).click();

        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("This is after method");
        if (driver != null) {
            driver.quit();
            
        }
    }
}
