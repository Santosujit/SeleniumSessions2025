package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {

    static WebDriver driver;

    public static void main(String[] args) {

        // Wait(until();) --> FluentWait(C): unit(){} + individual methods(){}
        // --> WebDriverWait (C): no methods
        // To explain above, Wait is an Interface, where until() abstract method is
        // there,
        // FluentWait is implementing wait interface, so until() in Fluentwait class is
        // having body
        // WebDriverWait is a class which is inheriting FluentWait Class
        // FluentWait is the parent of WebDriverWait

        driver = new ChromeDriver();// ChromeDriver class is the child of WebDriver interface
        driver.get("https://www.orangehrm.com/30-day-free-trial/");

        By firstName = By.id("Form_getForm_Name");

        // wait with fluent wait features: with dot and dot, It's called builder pattern
        // Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        // .withTimeout(Duration.ofSeconds(10)) -> 1 Feature of Fluent Wait
        // .pollingEvery(Duration.ofSeconds(2)) -> 2 Feature of Fluent Wait
        // .ignoring(NoSuchElementException.class) -> 3 Feature of Fluent Wait, It will
        // ignore NoSuchElementException till 10 sec
        // .withMessage("=====element is not found======"); -> 4 Feature of Fluent Wait,
        // This custom method will print message on console if element is not found
        // after 10 sec
        // On above lines we defined the wait object with fluent wait features
        // Below Line is the implementation or wait
        // wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Naveen");

        // WebDriverWait with fluent wait features:
        // WebDriverWait can access all the methods of FluentWait class, including
        // individual methods of FluentWait class
        // Generally we create object at the lowest level class, so here we can create
        // object of WebDriverWait class

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.pollingEvery(Duration.ofSeconds(2))
        // .ignoring(NoSuchElementException.class)
        // .ignoring(StaleElementReferenceException.class)//.class meaning It's already
        // compiled by Java
        // .ignoring(ElementNotInteractableException.class)
        // .withMessage("=====element is not found======" + firstName);
        // In above 3 exceptions are ignored

        // wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Naveen");
        // WebDriverWait has no methods inside it
        // Selenide, Appium uses Selenium open source code internally.
        // Selenide, Appium or anybody wanting to use Selenium code internally, that's
        // why FluentWait is created

        // Child class can inherit parent's class's methods, even individual methods
        // But parent class can't inherit child's class's methods, reference type check
        // will fail
        // Builder pattern is always applied on only object

        // driver.switchTo().newWindow(WindowType.WINDOW);//It'll switch to a new blank window
        // driver.get("https://www.google.com");//Enter Google in the blank new window
        // System.out.println(driver.getTitle());//Google
        //
        // driver.switchTo().newWindow(WindowType.TAB);//moving back to parent window
        // and opening a new tab in parent
        // driver.get("https://www.yahoo.com");

    }

    // WebDriverWait without fluent wait features:So no builder patternuent pattern
    public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}