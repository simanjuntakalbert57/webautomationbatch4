// package automation;

// import java.time.Duration;
// import java.util.List;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

// public class LocatorScenario {

//     WebDriver driver;
//     WebDriverWait wait;

//     @BeforeMethod
//     public void setUp() throws InterruptedException{
//         System.out.println("This is before method");
//         System.setProperty("webdriver.chrome.driver", "/Users/albertsimanjuntak/AfterOffice/WebAutomationBatch4/chromedriver");
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.manage().deleteAllCookies();

//         // Navigate to a website
//         driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//         wait = new WebDriverWait(driver, Duration.ofMillis(4000));

//         /*
//          * Kalau wait bakal berhenti kalau sudah menemukan element yang dicari
//          * Kalau thread.sleep() bakal nunggu sampe waktu habis
//          */

//         Thread.sleep(4000);

//     }

//     @Test
//     public void staticDropdown() throws InterruptedException{

//         System.out.println("This is test method");

//         // Static Dropdown
//         // 1. Locate the dropdown element
//         // 2. Create an object of Select class and pass the element


//         // WebElement adalah tipe data untuk menampung element
//         WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_view_date2"));
//         Select dropdown = new Select(staticDropdown);

//         System.out.println("Get first selected option: " + dropdown.getFirstSelectedOption().getText());
//         System.out.println("Get all options: " + dropdown.getOptions().size());
//         System.out.println("Get text: " + dropdown.getOptions().get(2).getText());

//         // dropdown.selectByIndex(3);
//         dropdown.selectByValue("USD");

//         // String index2;
//         // System.out.println("get index 2 by xpath: " + driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']/option[3]")).getText());

//     }

//     @Test
//     public void dynamicDropdown() throws InterruptedException{
//         System.out.println("This is test method");

//         // Dynamic Dropdown
//         driver.findElement(By.id("divpaxinfo")).click();;

//         Thread.sleep(2000);
//         //Increment value
//         //Adult
//         for(int i=1;i<5;i++){
//             driver.findElement(By.id("hrefIncAdt")).click();
//         }
//         //Child
//         for(int i=1;i<3;i++){
//             driver.findElement(By.id("hrefIncChd")).click();
//         }

//         //Infant
//         for(int i=1;i<2;i++){
//             driver.findElement(By.id("hrefIncInf")).click();
//         }

//         driver.findElement(By.id("btnclosepaxoption")).click();

//         System.out.println("Get text: " + driver.findElement(By.id("divpaxinfo")).getText());
//         Assert.assertEquals("5 Adult, 2 Child, 1 Infant", "5 Adult, 2 Child, 1 Infant",
//                 "Passenger count is not correct");
//     }

//     @Test
//     public void flightDestination(){
//         // From Country
//         driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//         List<WebElement> listOptions = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//following::div[@class='dropdownDiv']/ul[1]/li"));
//         // System.out.println("Total options: " + listOptions.size());

//         for(WebElement option : listOptions){
//             System.out.println(option.getText());
//             if (option.getText().equals("Bengaluru (BLR)")) {
//                 option.click();
//                 break;
//             }
//         }


//         // Arrival Country
//         driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("AM");
//         List<WebElement> listOptions2 = driver.findElements(By.xpath("(//div[@id='dropdownGroup1']/div[@class='dropdownDiv'])[2]/ul"));

//         System.out.println("Total options: " + listOptions2.size());
//         for(WebElement option : listOptions2){
//             List<WebElement> listOptions3 = option.findElements(By.tagName("li"));
//             for(WebElement option2 : listOptions3){
//                 System.out.println(option2.getText());
//                 if (option2.getText().equals("Vishakhapatnam (VTZ)")) {
//                     option2.click();
//                     System.out.println(option2);
//                     break;
//                 }
//             }
//         }

//         driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//     }



//     @AfterMethod
//     public void tearDown() throws InterruptedException{
//         System.out.println("This is after method");
//         Thread.sleep(4000);
//         if (driver != null) {
//             driver.quit();
            
//         }
//     }
// }
