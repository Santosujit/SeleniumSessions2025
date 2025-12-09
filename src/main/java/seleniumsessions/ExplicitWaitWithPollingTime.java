package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitWithPollingTime {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        By emailId = By.id("input-email");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

        // The concept of Pooling time or interval time is we give request to selenium
        // server
        // Then selenium server give request to the Appplication
        // Bydefault Selenium checks the application at 500 milli second interval
        // However we can set our pooling time too like done above
        // Above 10 second is the total timeout, 2 second is the pooling time, that
        // means
        // Selenium will check the application on a 2 second interval, so 5 times before
        // throwing timeout exception
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 500 milli second is the default
        // Pooling time, or interval time, is the frequency with which the condition is
        // checked before throwing
        // ms default polling time
        // However you can use the 2nd constructor, to set your own polling time

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys("test@gmail.com");

        By terms = By.linkText("Terms & Conditions");

        ElementUtil elUtil = new ElementUtil(driver);
        elUtil.waitForElementAndClick(terms, 10);

    }

}