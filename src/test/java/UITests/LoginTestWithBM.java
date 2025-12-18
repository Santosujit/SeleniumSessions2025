package UITests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Let me tell you a concept, you can design multiple test cases in BT, T, AT
// Meanig BeforeTest,Test, AfterTest where BT opening browser code is there
//AF where closing browser code is there
// But that is not a good practice, It's a good practise only for Sanity test suite
// But for Regression suite it's not a good practice
// why because Lets say there are 100 test cases, and one BT and one AfterClass
// The  suppose the browser crashes or gets closed after 5th test case execution
// due to many navigations, so rest of the 95 test cases will not be executed
// So it's better to have BeforeMethod ,Test and AfterMethod in Regression Suite or
// any large test suite, or test suite where lots of navigations are there 
// as browser crashes or gets closed frequently in heavy navigation scenario
// But you can use BT,T,AT for Sanity check as very little navigation and less test cases are there

public class LoginTestWithBM {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void pageTitleTest() {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, "Account Login");

    }

    @Test
    public void pageURLTest() {
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.contains("route=account/login"));
        // assertTrue() method is expecting true, so If true assertion passes or else
        // fails)
    }

    @Test
    public void pageLogoTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector("img.img-responsive")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
