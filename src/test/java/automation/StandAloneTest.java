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
    public void setUp(){
        System.out.println("This is before method");
        System.setProperty("webdriver.chrome.driver", "/Users/albertsimanjuntak/AfterOffice/WebAutomationBatch4/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Navigate to a website
        driver.get("https://www.saucedemo.com/");

        wait = new WebDriverWait(driver, Duration.ofMillis(4000));

        /*
         * Kalau wait bakal berhenti kalau sudah menemukan element yang dicari
         * Kalau thread.sleep() bakal nunggu sampe waktu habis
         */

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
