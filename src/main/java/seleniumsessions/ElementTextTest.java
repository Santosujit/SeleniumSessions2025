package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementTextTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By header = By.tagName("h2");
		By paragraph = By.xpath("//*[@id=\"content\"]/div/div[1]/div/p[2]");
		By forgotPwdLink = By.linkText("Forgotten Password");
		By footerHeader = By.xpath("/html/body/footer/div/div/div[1]/h5");

		ElementUtil elUtil = new ElementUtil(driver);
		String headerText = elUtil.doGetElementText(header);
		String paraText = elUtil.doGetElementText(paragraph);
		String forgotPwdLinkText = elUtil.doGetElementText(forgotPwdLink);
		String footerHeaderText = elUtil.doGetElementText(footerHeader);

		System.out.println(headerText);
		System.out.println(paraText);
		System.out.println(forgotPwdLinkText);
		System.out.println(footerHeaderText);

	}

}
