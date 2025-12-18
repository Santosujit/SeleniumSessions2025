package UITests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class OpenCartLoginPageTest extends BaseTest {

    // Data driven approach not framework ok: fetch the test data from data
    // providers: testng Data Provider,
    // Excel, CSV, JSon, DataBase, xml etc
    // this Data driven approach is called parameterization of test cases
    // Don't use the test data inside the test cases directly
    // Properties file is not suitable for test data, it's suitable for
    // configuration data

    // As shown below we are using TestNG Data Provider to supply test data
    // our created method getSearchData is annotated with

    // In modern test automation framework, It's always best practise to use
    // DataProvider provided by TestNG
    // Because if you use Excel, CSV, Json, DB etc you need to write lot of code to
    // read the data from these sources
    // You have to create utility classes to read the data from these sources
    // you have to use third party libraries to read the data from these sources
    // In Excel other automation engineer may delete your rows, there is no version
    // control
    // In DataProvider, you can track the data changes in your version control
    // system like Git
    // DataProvider is easy to maintain, easy to read, easy to write and no third
    // party libraries are required, same with csv, json, xml etc
    // Even supplying data from DB is also worst approach, because you have to write
    // lot of code to connect to DB, fetch the data etc
    // you can't use the App data, you have to create separate test data in DB for
    // Test automation
    // DataProvider is best approach to supply test data in modern test automation
    // Many times Excel crashes, json file format issue etc may lead to failure of
    // test
    // Data base connectivity issue is there, network issue etc may lead to failure
    // of test
    // Fetching your test data from code itself using DataProvider is best approach
    // Thirdparty libraries may have bugs, issues etc which may lead to failure of
    // test
    // Thirdparty libraries may become obsolete, no longer maintained etc which may
    // lead to failure of test
    // Thirdparty libraries may have compatibility issues with new versions of your
    // programming language,
    // test framework or build tools which may lead to failure of test
    // Compatibility issue had arisen in ApachePOI when Excel migrated from xls to
    // xlsx format
    // Even some one may delete the row in DB, or drop the table etc leading to
    // failure of test
    // DataProvider is best approach to supply test data in modern test automation
    // It's great for test automation mentainance

    // If you have 100 test cases in a regression suite, then always go for parallel
    // execution
    // Parallel execution will reduce the execution time of your test suite
    // Use Docker so that you can increase thread-count as it's using cloud's RAM,
    // and CPU

    // Industry practise is to use parallel=test not methods in testng.xml

    // DataProvider
    // This method returns 2D object array which contains multiple sets of test data
    // below method has two columns and 4 rows, so the test will run 4 times with
    // diff test data provided here
    // DataProvider is always returning 2D object array,
    // Each row is one set of test data
    // DataProvider always support 2D array
    // You can write n number of dataproviders in a single test class
    // you can give any name to the data provider method
    // but it's always best practise to give meaningful name to the data provider
    // you can mentain multiple data providers in a single test class
    // You can have n number columns and n number of rows in data provider
    // You can mentain DataProvider in separate class also and call it in test class
    // But not recommended
    // But if you have large data, then go with Excel or CSV file approach
    // The below DataProvider is for search related data
    // For Registration, create separate DataProvider
    // For Checkout, create separate DataProvider
    // 1st test should be serach test and 2nd test should be registration test and
    // so on
    // Create two test classes one for search related tests and another for
    // registration related tests

    @DataProvider
    public Object[][] getSearchData() {
        return new Object[][] {
                { "macbook", "MacBook Pro" },
                { "imac", "iMac" },
                { "samsung", "Samsung Galaxy Tab 10.1" },
                { "samsung", "Samsung SyncMaster 941BW" },
        };
    }

    // As shown above 1st column is search key, 2nd column is product name
    // 1st time macbook will be given to searchKey parameter and MacBook Pro to
    // productName parameter
    // 2nd time imac will be given to searchKey parameter and iMac to productName
    // parameter
    // and so on...It's done by TestNG internally

    @Test(dataProvider = "getSearchData") // just u have to do mapping of data provider with test method
    public void searchTest(String searchKey, String productName) {// we created two holding variables or parameters to
                                                                  // hold the data
                                                                  // from data provider
        driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(searchKey);
        driver.findElement(By.cssSelector("div#search button")).click();
        driver.findElement(By.linkText(productName)).click();
        String header = driver.findElement(By.tagName("h1")).getText();
        System.out.println(header);
        Assert.assertEquals(header, productName);

    }

}
