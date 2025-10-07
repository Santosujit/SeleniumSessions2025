package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Actions class: default
		// user actions: mouse and keyboard
		driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");

		// ParentChildMenu("Add-ons", "Visa Services");

		// ParentChildMenu("SpiceClub", "Benefits");

		By parentMenu = By.xpath("//div[text()='SpiceClub']");
		By childMenu = By.xpath("//div[text()='Benefits']");

		ParentChildMenu(parentMenu, childMenu);

	}

//	In below generic utility you have to mentain By locator
	public static void ParentChildMenu(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(1500);
		getElement(childMenu).click();
	}

//    In below genericutility you don't have to mentain by locator
	public static void ParentChildMenu(String parentMenu, String childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(By.xpath("//*[text()='" + parentMenu + "']"))).perform();// * or wildcard is used
																								// as some XPaths may be
																								// starting with tag div
																								// or a
		Thread.sleep(1500);
		getElement(By.xpath("//*[text()='" + childMenu + "']")).click();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}