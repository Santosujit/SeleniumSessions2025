package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserWindowHandingConcept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/30-day-free-trial/");// parent window
        Thread.sleep(3000);

        // If atribute target="_blank" is there in the DOM,
        // clicking on that webelement it will open in a new window/tab
        // new window or new tab are same in selenium

        WebElement AboutUs = driver.findElement(By.xpath("//footer//a[normalize-space()='About Us']"));
        // AboutUs.click(); //child window.
        // If normal Click is not working, then use Actions Class Click
        // If Actions Click is not even working then use JavascriptExecutor Click
        Actions act = new Actions(driver);
        act.click(AboutUs).perform();// child window

        // 1. fetch the window ids for parent and child windows

        Set<String> handles = driver.getWindowHandles();

        // Set is a non-order based collection, no index is there
        // So you can't use for loop to extract the values
        // So we use iterator

        Iterator<String> it = handles.iterator();

        // this Iterator reference variable "it" points just above the Set
        // so we have to do it.next() to fetch the 1st value, then again it.next() to
        // fetch the 2nd value
        // window IDs are not static they ar dynamic
        // If you open the same in diff browser, window IDs may be different

        String parentWidnowId = it.next();
        System.out.println("parent window id : " + parentWidnowId);

        String childWindowId = it.next();
        System.out.println("child window id : " + childWindowId);

        // 2. switching work:

        driver.switchTo().window(childWindowId);
        System.out.println("child window title: " + driver.getTitle());
        driver.close();// close the child window, If you do driver.quit() here both parent n child
                       // window will be closed
        // driver is lost now, you have to switch back to parent window

        driver.switchTo().window(parentWidnowId);// back to parent window
        System.out.println("parent window title: " + driver.getTitle());

        driver.quit();// quit the parent window, It can quit all the windows or tabs

    }

}