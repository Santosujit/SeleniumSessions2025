package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisabledEnabled {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html?m=1");
//
//		boolean b1 = driver.findElement(By.id("fname")).isDisplayed();// true
//		System.out.println(b1);
//
//		boolean b2 = driver.findElement(By.id("fname")).isEnabled();// true
//		System.out.println(b2);

//		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html?m=1");

//		boolean b3 = driver.findElement(By.id("pass")).isDisplayed();// true
//		System.out.println(b3);
//
//		boolean b4 = driver.findElement(By.id("pass")).isEnabled();// false
//		System.out.println(b4);

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		boolean b5 = driver.findElement(By.name("agree")).isDisplayed();// true
		System.out.println(b5);

		boolean b6 = driver.findElement(By.name("agree")).isEnabled();// true
		System.out.println(b6);
		boolean b7 = driver.findElement(By.name("agree")).isSelected();// false
		System.out.println(b7);

		driver.findElement(By.name("agree")).click();

		boolean b8 = driver.findElement(By.name("agree")).isSelected();// true
		System.out.println(b8);

	}

}
