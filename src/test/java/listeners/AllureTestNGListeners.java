package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;

import java.io.IOException;

public class AllureTestNGListeners extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Pade test");
        try {
            takeScreenshot("Pao test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            takeScreenshot("Test završio");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
