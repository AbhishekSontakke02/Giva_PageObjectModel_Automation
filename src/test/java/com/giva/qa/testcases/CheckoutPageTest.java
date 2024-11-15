package com.giva.qa.testcases;

import com.giva.qa.listener.TestListener;
import com.giva.qa.pages.AddToCartPage;
import com.giva.qa.pages.CheckoutPage;
import com.giva.qa.pages.LoginPage;
import com.giva.qa.pages.SearchPage;
import com.giva.qa.util.ExcelFileReading;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CheckoutPageTest extends CheckoutPage {

    LoginPage loginPage;
    SearchPage searchPage;
    AddToCartPage addToCart;
    CheckoutPage checkoutPage;


    @BeforeMethod
    public void setup(){
        initilization();
        loginPage=new LoginPage();
        searchPage=new SearchPage();
        addToCart=new AddToCartPage();
        checkoutPage=new CheckoutPage();

    }


    @Test(priority = 1,dataProvider = "CheckoutGuestData",dataProviderClass = ExcelFileReading.class)
    public void CheckoutForGuestTest(String emailId,String firstName,String lastName,String apartment,String city,String pincode ,String phone) throws InterruptedException {
        searchPage.searchByGuestTests();
        checkoutPage.checkoutForGuestTests( emailId, firstName, lastName, apartment, city,pincode, phone);
    }

    @Test(priority = 2,dataProvider = "CheckoutUserData",dataProviderClass = ExcelFileReading.class)
    public void CheckoutForUserTest(String apartment,String city,String pincode ,String phone) throws InterruptedException {
        searchPage.searchByUserTests();
        addToCart.AddToCartTest();
        checkoutPage.checkoutForUserTests(apartment, city,pincode, phone);
    }




    @AfterMethod
    public void tearDown(){
        closeDriver();
    }


}
