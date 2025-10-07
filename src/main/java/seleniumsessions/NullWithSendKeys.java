package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NullWithSendKeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		driver.findElement(By.id("input-email")).sendKeys(null);//java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
//		As shown above you can't enter null values in textbox using sendKeys() method. It'll throw Exception

//		driver.findElement(By.id("input-email")).sendKeys("");//you can't enter blank too

		driver.findElement(By.id("input-email")).sendKeys("null");

	}

}
