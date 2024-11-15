package com.giva.qa.testcases;

import com.giva.qa.base.TestBase;
import com.giva.qa.listener.TestListener;
import com.giva.qa.pages.LoginPage;
import com.giva.qa.pages.SearchPage;
import com.giva.qa.util.ExcelFileReading;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class LoginPageTest extends LoginPage {
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        initilization();
        loginPage=new LoginPage();
    }




    @Test(priority = 1)
    @Description("User login the application")
    @Epic("EP001")
    @Feature("Feature1 : Login")
    @Story("Story : login the account with emailid and password ")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(){
        loginPage.loginTest();
    }


    @Test
    public void wishListShoppingTest(){
        loginPage.wishListTest();
    }


    @Test(priority = 2,dataProvider = "LoginData",dataProviderClass = ExcelFileReading.class)
    public void LoginWithMultipleUser(String emails,String passs) {
        loginPage.multipleUserLogin(emails,passs);
    }

    @Test(priority = 3)
    public void UserLogin1() {
        loginPage.UserLogin1(prop.getProperty("emailID"), prop.getProperty("pass"));
        //  System.out.println(properties.getProperty("emailId"));
    }


    @Test(priority = 4)
    public void getTitles(){
        String title = loginPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Buy Beautiful Silver, Gold & Lab Grown Diamond Jewellery at Best Price – GIVA Jewellery");
    }


    @AfterMethod
    public void tearDown(){
        closeDriver();
    }
}
