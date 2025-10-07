package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeyWithCharSequence {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		String name = "Naveen";
		StringBuilder sb = new StringBuilder("Automation");
		StringBuffer sf = new StringBuffer("Labs");

		driver.findElement(By.id("input-email")).sendKeys(name, sb, sf);// name is on 1st position of the array, sb on
																		// 2nd, sf on 3rd position
		// CharSequence is an Interface, three dot means keysToSend is an array
//		  String
//		  StringBuilder
//		  StringBuffer

//		So you can pass String/StringBuilder/StringBuffer in the sendKeys() method

	}

}
