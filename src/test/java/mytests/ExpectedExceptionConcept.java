package mytests;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

    int age;

    @Test(expectedExceptions = { ArithmeticException.class, NullPointerException.class })
    public void paymentTest() {
        System.out.println("payment test");
        int i = 9 / 0;

        ExpectedExceptionConcept obj = null;
        obj.age = 20;// Null Pointer Exception

    }

}

// whenever Exception comes, test will fail
// However imagine a scenario where you want to give a Demo to Client in 30
// minutes and 70% test cases are failing, then you can use expectedExceptions
// concept
// to show the demo to client and later you can fix the issues
// But This is not exception hanling, this is just to ignore the exceptions for
// some time during urgency like Demo
// Exception is handled by try catch block only
