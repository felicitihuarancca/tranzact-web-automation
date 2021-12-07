package com.automation.web.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    private Logger log = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("THE TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("THE TEST FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // TODO Auto-generated method stub
    }
}
