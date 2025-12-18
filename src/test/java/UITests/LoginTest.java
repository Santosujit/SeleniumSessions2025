package UITests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {

    // LoginTest is extending BaseTest, Its the child of parent class BaseTest
    // So LoginTest is the child class of BaseTest parent class
    // So 1st BaseTest or Parent Class code will be executed 1st
    // Then LoginTest or Child class code will be executed

    // AAA:
    // 1 test: @Test - only one assertion should be mentioned
    // For example, in login page, title, url, logo
    // all three are different validations,
    // so three different test cases should be created one for each validation
    // You should not mix multiple assertions in a single test case
    // If one assertion fails, rest of the assertions will be skipped, and the test
    // will teminate with fail status which is not fair

    // If you define driver at the class level,
    // all the methods inside the class can use thid driver
    // AAA Pattern - Arrange, Act, Assert, One Test One Assertion should be followed
    // If for Log in Page, write separate tests for Title, Logo, URL etc, and three
    // assertions too, Don't combine all in one test

    @Test(priority = 1)
    public void pageTitleTest() {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, "Account Login");

    }

    @Test(priority = 2)
    public void pageURLTest() {
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.contains("route=account/login"));
    }

    @Test(priority = 3)
    public void pageLogoTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector("img.img-responsive")).isDisplayed());
    }

}