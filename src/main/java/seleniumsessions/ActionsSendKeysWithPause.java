package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Accessibility Testing-I want to enter Santosujit Mohanty,character by character slowly like a blind person

public class ActionsSendKeysWithPause {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		By locator = By.xpath("//textarea[@title='Search']");
//		WebElement locatorEle = driver.findElement(locator);
		String myName = "Santosujit Mohanty";

		doActionsSendKeysWithPause(locator, myName, 500);

//		char myname[] = myName.toCharArray();

//		Actions act = new Actions(driver);
////		Below inside sendKeys method character sequence is not character, It's string
//		for (char c : myname) {
//			act.sendKeys(locatorEle, String.valueOf(c)).pause(500).perform();
//		}

	}

	public static void doActionsSendKeysWithPause(By locator, String value, long pauseTime) {
		Actions act = new Actions(driver);
		char ch[] = value.toCharArray();
		for (char c : ch) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).perform();
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
