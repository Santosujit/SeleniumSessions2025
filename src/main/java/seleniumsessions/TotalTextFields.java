package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalTextFields {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//		find out all the text fields
//		find out the Placeholder value or Ghost text

		List<WebElement> textFieldsList = driver.findElements(By.className("form-control"));
		int totalNoOfTextFields = textFieldsList.size();
		System.out.println("Total no of Text Fields are " + totalNoOfTextFields);
		for (WebElement e : textFieldsList) {
			String GhostText = e.getAttribute("placeholder");
			System.out.println(GhostText);
		}
		driver.quit();
	}

}
