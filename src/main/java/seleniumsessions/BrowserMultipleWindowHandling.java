package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserMultipleWindowHandling {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/30-day-free-trial/");// parent window

        String parentWindowId = driver.getWindowHandle();// Get the parent window ID

        // target="_blank" -- new window/tab
        // Scenario is I have a Parent wibsite having, I will 1st go to the parent
        // website
        // Then click on four links present in the footer section one after another
        // Then I want to close all the new tabs or window but not the parent window

        WebElement aboutUs = driver.findElement(By.xpath("//footer//a[normalize-space()='About Us']"));
        WebElement pressReleases = driver.findElement(By.xpath("//footer//a[normalize-space()='Press Releases']"));
        WebElement newsArticles = driver.findElement(By.xpath("//footer//a[normalize-space()='News Articles']"));
        WebElement AIPrinciples = driver
                .findElement(By.xpath("//footer//a[normalize-space()='OrangeHRM AI Principles']"));

        Actions act = new Actions(driver);
        act.click(aboutUs).perform();
        act.click(pressReleases).perform();
        act.click(newsArticles).perform();
        act.click(AIPrinciples).perform();

        // 1. fetch the window ids:
        // If you have two windows or tabs, then in Set 1st window is parent, 2nd is
        // child

        // Concept- When you apply ierator, the reference variable always point throw
        // to the location just above 1st value stored in the memory
        // then when you do it.next(), then it will point to 1st cell value

        // But If you have more than two windows, then as Set is a a non-order based
        // collection
        // which cell stores which window id is unknown

        // In non-oder or index based collection, always use iterator to traverse

        // So what we are doing here, we are main webpage now, now we are clicking on
        // four links present in the main or parent page one by one
        // so 4 child windows or tabs will be opened
        // Now from main web page go to child1, then close child1 tab, Now driver is lost
        // So now switch to child2 tab, close this tab, now again driver is lost
        // So now switch to child3 tab, close this tab, now again driver is lost
        // So now switch to child4 tab, close this tab, now again driver is lost
        // finally switch back to parent window


        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it = handles.iterator();

        while (it.hasNext()) {
            String windowId = it.next();
            driver.switchTo().window(windowId);
            System.out.println(driver.getTitle());

            if (!windowId.equals(parentWindowId)) {
                driver.close();
            }

            Thread.sleep(1500);
        }
        // Now driver is lost, switch back to parent window

        driver.switchTo().window(parentWindowId);

        System.out.println("parent window title: " + driver.getTitle());

    }

}
