package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

	public static void main(String[] args) {

//		See the OneNotes Selenium Session 5

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By emailID = By.id("input-email");
		By password = By.id("input-password");// No call to server while creating By locator

		ElementUtil elUtil = new ElementUtil(driver);// while creating the object,1st constructor 'll be called
		elUtil.doSendkeys(emailID, "test@gmail.com");
		elUtil.doSendkeys(password, "test@123");

	}

}
