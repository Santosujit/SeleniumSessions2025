package mytests;

import org.testng.annotations.Test;

public class PriorityTest {

    // Integer.MIN_VALUE Its the lowest priority ever possible in TestNGFeatures
    // Integer.MAX_VALUE Its the highest priority ever possible in TestNGFeatures
    // If priority is not defined, by default its zero
    // If priority is at same level, then those test cases will be executed in
    // alphabetical order

    @Test(priority = Integer.MIN_VALUE)
    public void searchTest() {
        System.out.println("search test");
    }

    @Test(priority = 3)
    public void cartTest() {
        System.out.println("cart test");
    }

    @Test(priority = 2)
    public void paymentTest() {
        System.out.println("payment test");
    }

    @Test(priority = 5)
    public void aTest() {
        System.out.println("a test");
    }

    @Test(priority = 5)
    public void bTest() {
        System.out.println("b test");
    }

    @Test(priority = Integer.MAX_VALUE)
    public void cTest() {
        System.out.println("c test");

    }

    // priority is an integer so can be zero or negative, negative will be executed
    // first
    // Default value of priority is zero, If you don't give any priority, it will be
    // zero
    // If priority is same for multiple tests, then those tests will be executed in
    // alphabetical order
    // Is it a good practice to define the priorities?
    // NOT A GOOD PRACTICE as User will never use the system on single way
    // AAA pattern: Arrange Act Assert
    // Arrange - your test cases should be independent to each other, no order or
    // priority should be defined
    // Then Act in a way so that it can be asserted
    // Finally Assert the results

    // CRUD
    // CreateUserTest --T1 or Test Case No 1
    // ---fill the form and submit user id--> validate: POST

    // RetrieveUserTest -- T2
    // fill the form and submit and get userid (123): POST
    // get the user/userid(123) and validate: GET

    // UpdateUserTest -- T3
    // fill the form and submit and get userid (234): POST
    // get the user/userid(234): GET
    // update the user/userid(234): PUT

    // DeleteUserTest -- T4 : QA Env(234) --> stage env(900) -> Diff Env have diff
    // userids
    // fill the form and submit and get userid (234)
    // get the user/userid(234)
    // delete the user/userid(234)

    // As shown above T1 or Test case 2, T2, T3, T4 are independent test cases

    // Test cases should be independent to each other
    // No order or priority should be defined
    // when project grows, maintening dependent test cases will become nightmare

}
