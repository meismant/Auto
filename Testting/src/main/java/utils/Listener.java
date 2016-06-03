package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mac-250 on 2/26/16.
 */
public class Listener extends TestListenerAdapter{
    WebDriver driver;
    Logger logger;

    @Override
    public void onTestFailure(ITestResult testResult){
       log(testResult.getName()+"--Test method failed");

        takeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        log(testResult.getName()+"--Test method success");
    }


    private void takeScreenshot() {
        driver = BaseTest.getDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh:mm:ss");
        String destDir = "/Users/mac/IdeaProjects/TesttingResults/";
        new File(destDir).mkdir();
        String destFile = dateFormat.format(new Date())+".png";
        try{
            FileUtils.copyFile(scrFile, new File(destDir+"/"+destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String str){
        logger = BaseTest.getLogger();
        logger.info(str);
    }
}
