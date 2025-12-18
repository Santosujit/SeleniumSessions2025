package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
//		as shown above initDriver() method returns a driver, so we are storing here 
//		in WebDriver reference variable called driver
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(brUtil.getPageTitle());

		By emailID = By.id("input-email");
		By password = By.id("input-password");

		ElementUtil elUtil = new ElementUtil(driver);// we are passing the driver to ElementUtil class
		elUtil.doSendKeys(emailID, "test@gmail.com");
		elUtil.doSendKeys(password, "test@123");
		Thread.sleep(1000);

		brUtil.quitBrowser();

	}

}
