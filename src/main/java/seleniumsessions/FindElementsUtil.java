package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtil {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By totalImages = By.tagName("img");
		By totalLinks = By.tagName("a");
		int totalLinksCount = getElementsCount(totalLinks);
		int totalImagesCount = getElementsCount(totalImages);
		System.out.println("Total Links counts is " + totalLinksCount);
		System.out.println("Total Images counts is " + totalImagesCount);

		printElementTextList(totalImages);
		System.out.println("********************************");
		printElementTextList(totalLinks);

		List<String> eleTextList = getElementsTextList(totalLinks);
		System.out.println("********************************");
		System.out.println(eleTextList.contains("About Us"));
		System.out.println(eleTextList.contains("Contact Us"));
		driver.quit();

//		So in this way in main method we have avoided writing Logic,
//		main method is the caller method

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();// we are creating a blank ArrayList

		for (WebElement e : eleList) {
			String eleText = e.getText();
			if (eleText.length() != 0) {
				eleTextList.add(eleText);// adding to the already created blank ArrayList
			}

		}
		return eleTextList;
	}

	public static void printElementTextList(By locator) {
		List<String> eleTextList = getElementsTextList(locator);
		for (String e : eleTextList) {
			System.out.println(e);
		}
	}

}
