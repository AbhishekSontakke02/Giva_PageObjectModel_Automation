package com.giva.qa.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.giva.qa.pages.LoginPage;
import com.giva.qa.util.TestUtil;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class  TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public static Logger logger= Logger.getLogger(TestBase.class);

    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\Abhi\\IdeaProjects\\Giva_PageObjectModel_Automation\\test_output\\ExtentReport.html");


    public TestBase(){
        PropertyConfigurator.configure("C:\\Users\\Abhi\\IdeaProjects\\Giva_PageObjectModel_Automation\\resources\\Log4j.properties");
        try {
            prop = new Properties();
            FileInputStream ip = null;
            ip = new FileInputStream("C:/Users/Abhi/IdeaProjects/Giva_PageObjectModel_Automation/src/main/java/com/giva/qa/config/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void initilization(){
        logger.info("Browser Name: " + prop.getProperty("browser"));
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        logger.info("Application URL : "+ prop.getProperty("url"));
        driver.get(prop.getProperty("url"));
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
