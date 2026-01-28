package com.automation.listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.automation.tests.BaseTest;
import com.automation.utils.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new entry in the report for this test
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        try {

            Object currentClass = result.getInstance();
            WebDriver driver = ((BaseTest) currentClass).getDriver();

            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);


            test.get().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");

        } catch (Exception e) {
            test.get().fail("Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        if (extent != null) {
            extent.flush();
        }
    }
}