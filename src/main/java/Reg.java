import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

   public class Reg
   {

       private static WebDriver driver;


       @Test

           public void verifyhomepage() {
           System.setProperty("webdriver.chrome.driver", "src\\test\\java\\chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.NANOSECONDS);
           driver.manage().window().fullscreen();
           driver.get(" https://demo.nopcommerce.com/");
           driver.findElement(By.linkText("Register")).click();
           driver.findElement(By.id("gender-male")).click();
           driver.findElement(By.id("FirstName")).sendKeys("Tarun");
           driver.findElement(By.id("LastName")).sendKeys("Patel");
           driver.findElement(By.xpath("//div[@class=\"page registration-page\"]/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[5]")).click();
           driver.findElement(By.xpath("//div[@class=\"page registration-page\"]/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[3]")).click();
           driver.findElement(By.xpath("//div[@class=\"page registration-page\"]/div[2]/form/div[1]/div[2]/div[4]/div/select[3]/option[79]")).click();
           //Date format so no need to change email
           SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmm");
           Date date = new Date();
           String date1 = dateFormat1.format(date);
           driver.findElement(By.id("Email")).sendKeys("tkpatel22851789+" + date1 + "@gmail.com");
           driver.findElement(By.id("Company")).sendKeys("Shreeji Ltd");
           driver.findElement(By.id("Newsletter")).click();
           driver.findElement(By.id("Password")).sendKeys("Tarun123");
           driver.findElement(By.id("ConfirmPassword")).sendKeys("Tarun123");
           driver.findElement(By.id("register-button")).click();
           String actualRegisterSuccessMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
           Assert.assertEquals("Test case : Registration senario pass", "Your registration completed", actualRegisterSuccessMessage);
           driver.findElement(By.linkText("Log out")).click();
           driver.quit();

       }

       @Test
       public void Euro()
       {
           System.setProperty("webdriver.chrome.driver", "src\\test\\java\\chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(05, TimeUnit.NANOSECONDS);
           driver.manage().window().fullscreen();
           driver.get(" https://demo.nopcommerce.com/");
           driver.findElement(By.xpath("//div[@class=\"currency-selector\"]/select/option[2]")).click();
           driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]"));
           driver.quit();

       }
       @Test
       public void Email()
       {
           System.setProperty("webdriver.chrome.driver", "src\\test\\java\\chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);
           driver.manage().window().fullscreen();
           driver.get(" https://demo.nopcommerce.com/");
           driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[2]/div/div[2]/h2/a")).click();
           driver.findElement(By.xpath("//div[@class=\"overview-buttons\"]/div[3]")).click();
            driver.findElement(By.xpath("//input[@id=\'FriendEmail\']")).sendKeys("tkpatel2285@gmail.com");
            driver.findElement(By.xpath("//input[@id=\'YourEmailAddress\']")).sendKeys("tkpaagv@gmail.com");
            driver.findElement(By.xpath("//form[@method=\"post\"]/div[2]/input")).click();
            String actualerrormessage = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).getText();
           Assert.assertEquals("Test case : Registration senario pass", "Only registered customers can use email a friend feature", actualerrormessage);
           driver.quit();
       }

   }

