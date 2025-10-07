package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// drop down -- htmltag: <select> --> <option>
		// Use Select class
		// single selection
		// multi selection

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		By country = By.id("Form_getForm_Country");
//		WebElement country_ele = driver.findElement(country);
//		
//		Select select = new Select(country_ele);
//		select.selectByIndex(5); //month 1 to 12, or Year
//		Thread.sleep(1000);
//		select.selectByVisibleText("Brazil");
//		Thread.sleep(1000);
//		select.selectByValue("India");

		doSelectDropDownByIndex(country, 5);

		doSelectDropDownByVisibleText(country, "Brazil");

		doSelectDropDownByValue(country, "India");

		// 20 drop downs
//		doSelectDropDownByVisibleText(country, "Brazil");
//		doSelectDropDownByVisibleText(city, "Brazil");
//		doSelectDropDownByVisibleText(emp, "Brazil");
//		doSelectDropDownByVisibleText(comp, "Brazil");

	}

//	visibletext is which is visible in the UI or in the DOM as Text
//	value is the value of the value attribute in DOM, this may or may not be same as Text
//	index generally we don't use , only in case of month, days, year we can use though as index may change if some extra text gets added
//	in this example country is at index zero

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}