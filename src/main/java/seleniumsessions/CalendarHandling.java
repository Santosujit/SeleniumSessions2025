package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandling {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();

//		select a date
//		selectDate(17);

//		select future date

//		Let's say I want to click on 31st December
//		If you apply getText() method on parent, you will also get the children text
//		How many times we have to click Next button is not fixed so we have to use while or Do while loop

		selectFutureDate("December 2025", 31);

	}

	public static void selectDate(int day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

	public static void selectFutureDate(String expMonYear, int day) {
		String actMonYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();

		while (!actMonYear.equalsIgnoreCase(expMonYear)) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}

		selectDate(day);

	}

}
