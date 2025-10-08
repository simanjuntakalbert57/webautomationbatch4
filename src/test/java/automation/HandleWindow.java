// package automation;

// import java.util.Iterator;
// import java.util.Set;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

// public class HandleWindow {
//    public WebDriver driver;

//     @BeforeMethod
//     public void setUp() throws InterruptedException{
//         System.out.println("This is before method");
//         System.setProperty("webdriver.chrome.driver", "/Users/albertsimanjuntak/AfterOffice/WebAutomationBatch4/chromedriver");
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.manage().deleteAllCookies();

//         // Navigate to a website
//         driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

//         Thread.sleep(4000);

//     }

//     @Test
//     public void handleWindow() throws InterruptedException{
//         driver.findElement(By.cssSelector(".blinkingText")).click();
//          Thread.sleep(2000);
        
//         Set<String> windows = driver.getWindowHandles();
//         System.out.println("ini adalah windows" + windows);//[parentId, childId]

//         Iterator<String> iterator = windows.iterator();
//         String parentId = iterator.next();
//         String childId = iterator.next();

//         Thread.sleep(2000);

//         driver.switchTo().window(childId);
//         System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

//         String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

//         driver.switchTo().window(parentId);

//         driver.findElement(By.id("username")).sendKeys(emailId);

//         Thread.sleep(2000);

//     }

//     @AfterMethod
//     public void tearDown(){
//         System.out.println("This is after method");
//         // Close the browser
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }