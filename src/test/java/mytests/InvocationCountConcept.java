package mytests;

import org.testng.annotations.Test;

public class InvocationCountConcept {

    @Test(invocationCount = 10, priority = 1)
    public void paymentTest() {
        System.out.println("payment test");
    }

    @Test(invocationCount = 10, priority = 2)
    public void cartTest() {
        System.out.println("cart test");
    }

}

// inovationcount 10 means that test will be executed 10 times
// This is useful in performance testing where you want to hit a particular API
// multiple times back to back to check its performance under load.