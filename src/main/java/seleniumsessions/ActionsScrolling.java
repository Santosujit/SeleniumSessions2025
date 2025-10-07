package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://academy.naveenautomationlabs.com/");

		// partial scrolling - slowly It will go down the page slowly, mimicking page
		// down and page up keyboard actions.

		// Scroll down and up once
		Actions act = new Actions(driver);
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(500);
//		act.sendKeys(Keys.PAGE_UP).perform();

//		Going to Footer of the Page

//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(5000);

//				Going to the Top of the page
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();

//		Scroll to Element

		act.scrollToElement(driver.findElement(By.linkText("Refund policy")))
				.click(driver.findElement(By.linkText("Refund policy"))).perform();

//		Infinite scrolling is like scrolling down/up in Facebook, Linkedin, Instagram
//		Going to the bottom of webpage directly, end button, up Home button

	}

}
