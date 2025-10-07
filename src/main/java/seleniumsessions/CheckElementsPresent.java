package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckElementsPresent {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By logo = By.cssSelector(".img-responsive");
		By rightPanelLinks = By.xpath("//div[@class='list-group']/a");// checking if Naveen Automation logo is present
																		// or not
		System.out.println(isElementPresent(logo));
		System.out.println(isElementPresent(rightPanelLinks, 13));// checking if right panel has 13 links or not

	}

	public static boolean isElementPresent(By locator) {// for single element checking if element is present or not
		if (getElementsCount(locator) == 1) {
			return true;
		}
		return false;
	}

	public static boolean isElementPresent(By locator, int expectedElmentCount) {// overloaded method for multiple
																					// elements chekcking if they are
																					// present or not
		if (getElementsCount(locator) == expectedElmentCount) {
			return true;
		}
		return false;
	}

	public static boolean isElementNotPresent(By locator) {
		if (getElementsCount(locator) == 0) {
			return true;
		}
		return false;
	}

	public static boolean isElementPresentMultipleTimes(By locator) {
		if (getElementsCount(locator) >= 1) {
			return true;
		}
		return false;
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

}
