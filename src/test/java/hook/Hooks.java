package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    private static WebDriver driver;
    int x;

    @Before
    public void setUp() throws InterruptedException, IOException{
        System.out.println("Ini setup web automation");

        // Get Properties
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/webautomationbatch4/resources/GlobalData.properties");
        properties.load(fileInputStream);
        
        String browserName = properties.getProperty("browser");
        
        if (browserName.equalsIgnoreCase("chrome")) {
            // Otomatis setup driver
            WebDriverManager.chromedriver().setup();

            // Jalankan Chrome
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
            driver = new FirefoxDriver();
        }else{
            System.out.println("Put browser");
        }
        
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
    }

    @After
    public void tearDown(){
        System.out.println("Ini setup after web automation");
        if (driver != null) {
            driver.quit();
        }

    }

    public static WebDriver getDriver(){
        System.out.println("Get DRIVER");
        if (driver == null) {
            System.out.println("ini driver kosong");
        }
        return driver;
    }

}
