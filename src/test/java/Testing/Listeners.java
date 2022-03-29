package Testing;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Pages.Driver_Class;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Listeners extends Driver_Class implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart method started"+context.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("finished:"+context.getName());
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started" +result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Date currentDate = new Date();
        String screenshotsFile =currentDate.toString().replace("","-").replace(":","-");
        TakesScreenshot ts =  (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File(".\\screenshots\\"+screenshotsFile+".png");
        try {
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("onTestSuccess Method" +result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        Date currentDate = new Date();
        String FailureScreenshotFilename =currentDate.toString().replace("","-").replace(":","-");
        TakesScreenshot ts =  (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File(".\\screenshots\\"+FailureScreenshotFilename+".png");
        try {
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("onTestFailure Method" +result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Method" +result.getName());
    }

}
