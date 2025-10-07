package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;// private as we don't want to expose ElementUtil driver to outside as it's
								// value as NULL

	public ElementUtil(WebDriver driver) {
		this.driver = driver;// we are brining the driver from WebElementConcept class
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doSendkeys(By locator, CharSequence... value) {// overloaded method
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetElementText(By locator) {
		String eleText = getElement(locator).getText();
		if (eleText != null) {
			return eleText;
		} else {
			System.out.println("Element Text is Null " + eleText);
			return null;
		}

	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is not displayed due to" + locator);
			return false;

		}
	}

	public boolean isElementPresent(By locator) {// for single element checking if element is present or not
		if (getElementsCount(locator) == 1) {
			return true;
		}
		return false;
	}

	public boolean isElementPresent(By locator, int expectedElmentCount) {// overloaded method for multiple
																			// elements chekcking if they are
																			// present or not
		if (getElementsCount(locator) == expectedElmentCount) {
			return true;
		}
		return false;
	}

	public boolean isElementNotPresent(By locator) {
		if (getElementsCount(locator) == 0) {
			return true;
		}
		return false;
	}

	public boolean isElementPresentMultipleTimes(By locator) {
		if (getElementsCount(locator) >= 1) {
			return true;
		}
		return false;
	}

	public String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<String> getElementsTextList(By locator) {
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

	public void printElementTextList(By locator) {
		List<String> eleTextList = getElementsTextList(locator);
		for (String e : eleTextList) {
			System.out.println(e);
		}
	}

	public boolean doSearch(By SeacrhField, By suggestions, String searchKey, String matckKey)
			throws InterruptedException {

//		driver.findElement(SeacrhField).sendKeys(searchKey);
		doSendkeys(SeacrhField, searchKey);// this generic method replaces above line
		Thread.sleep(3000);
		boolean flag = false;
//		List<WebElement> suggestionsList = driver.findElements(suggestions);
		List<WebElement> suggestionsList = getElements(suggestions);// this generic method replaces above line
		int totalSuggestions = suggestionsList.size();
		System.out.println("Total no of suggestions found is===" + totalSuggestions);
		if (totalSuggestions == 0) {// If no suggestions, negative scenario
			System.out.println("No Suggestions Found...");
			throw new FrameworkException("No Suggestions Found...!");
		}
		for (WebElement e : suggestionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(matckKey)) {
				e.click();
				flag = true;
				break;// break will never exits the condition, it exits the loop itself

			}

		}
		if (flag) {// negative scenario, if while searching selenium there is no cypress in the
					// drop down
			System.out.println(matckKey + " is found...!");
			return true;
		} else {
			System.out.println(matckKey + " is not found...!");
			return false;
		}
	}
	// ***************Select drop Down Utils***************//

	private Select createSelect(By locator) {
		Select select = new Select(getElement(locator));
		return select;// then with this select class refernce we can play with dropdown values
						// its for avoiding creating select class object repeatedly
	}

	public void doSelectDropDownByIndex(By locator, int index) {
		createSelect(locator).selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
		createSelect(locator).selectByVisibleText(visibleText);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		createSelect(locator).selectByValue(value);
	}

	public int getDropDownOptionsCount(By locator) {
		return createSelect(locator).getOptions().size();
	}

	public List<String> getDropDownOptions(By locator) {
		List<WebElement> optionsList = createSelect(locator).getOptions();

		List<String> optionsTextList = new ArrayList<String>();

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}

		return optionsTextList;
	}

	public void selectDropDownOption(By locator, String dropDownValue) {

		List<WebElement> optionsList = createSelect(locator).getOptions();

		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

	public void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// *****************Actions utils ***************//

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public void twoLevelMenuHandle(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(1000);
		doClick(childMenuLocator);
	}

	public void fourLevelMenuHandle(By parentMenuLocator, By firstChildMenuLocaor, By secondChildMenuLocaor,
			By thirdChildMenuLocaor) throws InterruptedException {

		Actions act = new Actions(driver);

		doClick(parentMenuLocator);
		Thread.sleep(1000);

		act.moveToElement(getElement(firstChildMenuLocaor)).build().perform();

		Thread.sleep(1000);

		act.moveToElement(getElement(secondChildMenuLocaor)).build().perform();

		Thread.sleep(1000);

		doClick(thirdChildMenuLocaor);

	}

	public void doActionsSendKeysWithPause(By locator, String value) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for (char c : val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
		}
	}	
}