package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithDisableElement {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html?m=1");

//		driver.findElement(By.id("pass")).sendKeys("Naveen");//org.openqa.selenium.ElementNotInteractableException: element not interactable

		driver.findElement(By.id("pass")).click();//no exception

	}

}
