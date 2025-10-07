package seleniumsessions;

import java.sql.Time;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Later we will see Notification pop up, Location Pop up, Advertisement Pop up etc - Do Research on these topics

public class JSPopUpHandling {

	public static void main(String[] args) throws InterruptedException {

		// JS alerts: Javascript Alerts, only three types of JS Pop up or alert
		// 1. alert
		// 2. confirmation alert
		// 3. prompt alert

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// 1. alert:
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
//		Thread.sleep(3000);
//
//		Alert alert = driver.switchTo().alert();//Alert is an Interface
//		
//		String text = alert.getText();
//		System.out.println(text);
//		alert.accept(); //click on OK		
//		//alert.dismiss();//just cancel this alert

		// 2. confirm:
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(3000);
//		
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		//alert.accept(); //click on OK
//		alert.dismiss();//just cancel this alert: click on cancel or mimicking pressing Escape key

		// 3. prompt: only one text field
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		// Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);

		alert.sendKeys("naveenautomationlabs");
		Thread.sleep(3000);

		alert.accept(); // click on OK
		// alert.dismiss();//just cancel this alert: click on cancel

		// NoAlertPresentException: no such alert in case of no JS popup on the page.
		
//		Once you accept the alert pop up, the driver automatically comes back to the main web page
//		we don't need to switch the driver back to the webpage, It automatically happens
		
//		At a Time, there can be maximum one JS Alert

	}

}
