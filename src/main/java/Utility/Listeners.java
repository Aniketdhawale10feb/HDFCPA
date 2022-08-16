package Utility;

import Base_utility.Comman;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Comman implements ITestListener
{
    Comman comman= new Comman();
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test Case Execution Started :" +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ITestListener.super.onTestSuccess(result);
        System.out.println("Test Success :"+result.getName());
        try {
            comman.TakeScreenShot("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/SuccessScreens/",result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test Failed :"+result.getName());
        try {
            comman.TakeScreenShot("/home/lentraadmin/IdeaProjects/HDFCPA/ScreenShots/failedScreens/",result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("Test Skipped :"+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }


}
