package com.giva.qa.testcases;

import com.giva.qa.listener.TestListener;
import com.giva.qa.pages.AddToCartPage;
import com.giva.qa.pages.LoginPage;
import com.giva.qa.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AddToCartPageTest extends AddToCartPage {
    LoginPage loginPage;
    SearchPage searchPage;
    AddToCartPage addToCart;

    @BeforeMethod
    public void setup(){
        initilization();
        loginPage=new LoginPage();
        searchPage=new SearchPage();
        addToCart = new AddToCartPage();
    }


    @Test(priority = 1)
    public void AddToCartTest(){
        addToCart.AddToCartTest();
    }


    @Test(priority = 2)
    public void cartTest() throws InterruptedException {
        searchPage.searchByUserTests();
        addToCart.CartTest();
    }




    @AfterMethod
    public void tearDown(){
        closeDriver();
    }



}
