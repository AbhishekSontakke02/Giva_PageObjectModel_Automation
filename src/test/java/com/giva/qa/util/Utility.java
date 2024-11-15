package com.giva.qa.util;

import com.giva.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Utility extends TestBase {


    public static void failedTest(String failcase) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\Abhi\\IdeaProjects\\Giva_PageObjectModel_Automation\\Screenshots" +failcase+ ".png");
        FileHandler.copy(srcFile, destFile);
    }



}
