package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

//		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
//		int totalNoOfImages = imagesList.size();
//		System.out.println("Total Number of Images in this webpage are " + totalNoOfImages);
//
//		for (WebElement e : imagesList) {
//
//			String srcVal = e.getAttribute("src");
//			System.out.println(srcVal);
//
//		}

//		Capture all the Links
//		Print the LinkText and href values

		List<WebElement> linksText = driver.findElements(By.tagName("a"));
		int linksCount = linksText.size();
		System.out.println("The number of Links in the webpage are " + linksCount);
		for (WebElement e : linksText) {
			String text = e.getText();
			String hrefVal = e.getAttribute("href");
			System.out.println(text + " ---> " + hrefVal);
			
//			The above is called web scrapping
		}
		driver.quit();
	}

}
