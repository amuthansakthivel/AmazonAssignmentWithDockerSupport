package com.assignment.listeners;

import com.assignment.reports.ExtentReport;
import com.assignment.reports.LogType;
import org.testng.*;

import java.util.Arrays;

import static com.assignment.reports.FrameworkLogger.log;

public class TestListener implements ITestListener, ISuiteListener {


    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log(LogType.PASS, result.getMethod().getDescription() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log(LogType.FAIL, result.getMethod().getDescription() + " is failed");
        log(LogType.FAIL, result.getThrowable().toString());
        log(LogType.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }
}
