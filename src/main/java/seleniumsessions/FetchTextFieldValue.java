package seleniumsessions;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchTextFieldValue {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//		Enter something in text field, and get the text, getText() 'll not work here.It's stored in value attribute, sometime value attribute is hidden

//		driver.findElement(By.id("input-firstname")).sendKeys("Naveen Automation Labs Loving it");
//		String text = driver.findElement(By.id("input-firstname")).getAttribute("value");
//		System.out.println(text);

		By Email = By.id("input-firstname");
		getElement(Email).sendKeys("Naveen you rock");
		String v1 = doGetElementAttribute(Email, "placeholder");
		String v2 = doGetElementAttribute(Email, "value");
		System.out.println(v1);
		System.out.println(v2);
		driver.quit();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	@SuppressWarnings("deprecation")
	public static @Nullable String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

}
