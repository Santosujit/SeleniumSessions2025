package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElements {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		Single Element -> FindElement()
//		Multiple Elements -> FindElements()

//		Find out all the Links of the Page
//		Print the text of each link, and ignore any blank space

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		int linksCount = linksList.size();
		System.out.println("No of Links in the Webpage are -" + linksCount);

//		Using for loop
		for (int i = 0; i < linksCount; i++) {

			String text = linksList.get(i).getText();
			if (text.length() != 0) {
				System.out.println(i + " = " + text);// As there are many Links having no Text
			}

		}

		System.out.println("****************************************************************");

//		Using extende for loop

		int count = 0;
		for (WebElement e : linksList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(count + " = " + text);// As there are many Links having no Text
			}
			count++;
		}
		driver.quit();
	}

}
