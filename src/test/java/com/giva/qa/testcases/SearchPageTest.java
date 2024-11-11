package com.giva.qa.testcases;

import com.giva.qa.base.TestBase;
import com.giva.qa.listener.TestListener;
import com.giva.qa.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SearchPageTest extends SearchPage {
    SearchPage searchPage;

    @BeforeMethod
    public void setup(){
        initilization();
        searchPage=new SearchPage();
    }

    @Test
    public void searchByGuestTest() throws InterruptedException {
        searchPage.searchByGuestTests();
    }

    @Test
    public void searchByUserTest() throws InterruptedException {

        searchPage.searchByUserTests();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
