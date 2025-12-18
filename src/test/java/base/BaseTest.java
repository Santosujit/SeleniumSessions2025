package base;

import java.time.Duration;

// All the common codes needed by diff calsses are stored in BaseTest class

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

// All the common codes needed by diff calsses are stored in BaseTest class
// Common Code like browser initiation, url launch, window maximize, delete cookies, timeouts, browser quit etc
//It's always best practise to organise the imports by pressing Ctrl+Alt+O

public class BaseTest {

    protected WebDriver driver;// this driver will be given to all the inheriting child classes
    // but why the above modifier is protected
    // If public then all including src/main/java or src/test/java classes can
    // access
    // If private then no one can access
    // If default then only same package classes can access
    // So protected is the best choice here

    @Parameters({ "url", "browser" }) // this catches or reads
    // the parameter values
    // passed from the runner xml file, name should be same as in xml file
    // then the prameter values are passed
    // to setUp() method

    // You have run from xml so the parameters will be passed from xml file
    // If you run this class directly without xml file then you have to give default
    // values using @Optional annotation in below method signature

    @BeforeTest
    public void setUp(@Optional("https://naveenautomationlabs.com/opencart/index.php?route=account/login") String url, 
                      @Optional("chrome") String browserName) {// these catching variables can be anything

        System.out.println("browser is : " + browserName);

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("plz supply the right browser...." + browserName);
                throw new IllegalArgumentException("WRONG BROWSER : " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
