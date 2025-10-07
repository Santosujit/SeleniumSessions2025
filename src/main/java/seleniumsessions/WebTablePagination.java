package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);

		// single country selection and click the checkbox
//		while (true) {// it 'll lead to infinite loop so in some part apply break statment
////			driver.findElement(null)'ll throw NoSuchElement Exception If country is not found in the table
////			if element is on 1st Page
//
//			if (driver.findElements(By.xpath("//td[text()='Ukraine']")).size() > 0) {
//				selectCountry("Ukraine");
//				break;
//			} else {
//				// if element is not found on 1st Page
//				// Pagination logic
//				// Click on next button
//				// but at last page next button is disabled, so put a condition
//				WebElement next = driver.findElement(By.xpath("//button[@aria-label='Next']"));
//				if(next.getAttribute("class").contains("disabled")) {//Don't use InEnabled() here as It does not work always
//					System.out.println("Pagination is over...Country is not found");
//					break;
//				}
//				next.click();
//				Thread.sleep(1000);
//			}
//
//		}

//		multiple selection .If India is available multiple times, in multiple pages, check on all check boxes where India is present

		while (true) {
			// if element is on 1st Page
			if (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
				selectMultipleCountry("India");
				// we don't want to break here as India may be present in next page as well

			}
			// pagination logic
			WebElement next = driver.findElement(By.xpath("//button[@aria-label='Next']"));
			if (next.getAttribute("class").contains("disabled")) {// Don't use InEnabled() here as It does not work
																	// always
				System.out.println("Pagination is over...Country is not found");
				break;
			}
			next.click();
			Thread.sleep(1000);
		}

	}

	public static void selectCountry(String countryName) {
		driver.findElement(By.xpath("//td[text()='" + countryName + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static void selectMultipleCountry(String countryName) {
		List<WebElement> eles = driver.findElements(
				By.xpath("//td[text()='" + countryName +"']/preceding-sibling::td/input[@type='checkbox']"));// 1
																													// of
																													// 8
																													// on
																													// 1st
																													// page
		for (WebElement e : eles) {
			e.click();// it 'll go to each and every check box where India is present and lick on the
						// checkbox
		}
	}

}
