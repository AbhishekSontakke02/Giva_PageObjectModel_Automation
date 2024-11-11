package com.giva.qa.testcases;

import com.giva.qa.base.TestBase;
import com.giva.qa.listener.TestListener;
import com.giva.qa.pages.RegisterPage;
import com.giva.qa.util.ExcelFileReading;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class RegisterPageTest extends RegisterPage{
    RegisterPage registerPage;

    @BeforeMethod
    public void setup(){
        initilization();
        registerPage=new RegisterPage();
    }



    @Test(dataProvider = "RegisterData",dataProviderClass = ExcelFileReading.class)
    public void registerTest(String firstName,String lastName,String emailID,String password){
        registerPage.registerTest(firstName,lastName,emailID,password);

    }



    @AfterMethod
    public void tearDown(){
        closeDriver();
    }


}
