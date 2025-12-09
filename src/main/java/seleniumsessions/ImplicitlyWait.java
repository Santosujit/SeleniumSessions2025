package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//sel 3.x
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// sel 4.x

        // global wait:
        // implicitly Wait will be applied on all the web elements by default
        // implicitly Wait can'not be applied for the specific web elements
        // implicitly Wait can'not be applied for the non webelements: title, url, windows pop ups or
        // tabs, JS pop(Alert)
        // ups

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        // login page: 10 secs
        driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");// 10
        // 10 secs: 2 secs: 2 secs
        // 10 secs: 12 secs: NSE timeout-NoSuchElement Exception
        // 10 secs: 5 secs: 5 secs

        driver.findElement(By.id("input-password")).sendKeys("naveen@123");// 10
        driver.findElement(By.xpath("//input[@value='Login']")).click();// 10

        // 1
        // 2
        // 3
        // 4
        // 50

        // home page: 20 secs, In Home Page I want to wait for max 20 sec so I have to
        // write implicitwait for 20sec again
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// 20
        // e4
        // e5
        // e6

        // login page: 10 secs:again write for 10 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// 10

        // register page: 5 secs - again write for 5 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// 5

        // search : 0 secs - again write for 0 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));// 0 -- nullify of implicitly wait

        // home page: 0 sec
        // e7 e8 e9

        // Suppose In Log in page userid and email and log in button are there
        // If 10sec implicitlyWait is aplied, it will wait for all three webelements mentioned above
        // which is mere time wastage
        // we have our selenium code, then we will call implicitly wait, then call to server tnen call to application
        // Each time It will call like this so lots of time wastage
        // So practically implicitlyWait is not used in Selenium
        // Even autoWait is bad, It will wait for each and every webElement slowing down the script
        // So we use Explicitly Wait for few web elements only

    }

}