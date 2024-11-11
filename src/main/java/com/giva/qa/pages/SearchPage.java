package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends TestBase {
    public SearchPage(){
        super();
        PageFactory.initElements(driver,this);
    }
    LoginPage loginPage = new LoginPage();



    @FindBy(xpath = "//input[@id=\"Search-In-Modal\"]")
    WebElement searchBox;

    @FindBy(className = "search__button")
    WebElement searchIcon;

    @FindBy(xpath = "(//a[@id='CardLink--7629238173858'])[1]")
    WebElement productItem;

    @FindBy(xpath = "//button[@id='ProductBuyButton-template--17210449821858__main']")
    WebElement buyButton;

    @FindBy(id="ProductSubmitButton-template--17210449821858__main")
    WebElement addToCartBtn;

    public void inputSearchBox(){
        searchBox.sendKeys("Rings");
    }

    public void clickSearchIcon(){
        searchIcon.sendKeys(Keys.ENTER);
    }

    public void scrollDown(){
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("window.scrollBy(0,200)");
        }
    }

    public void clickProductItem(){
        productItem.sendKeys(Keys.ENTER);
    }

    public void clickbuyButton(){
        buyButton.click();
    }

    public void clickAddToCart(){
        addToCartBtn.click();
    }

    public void searchByGuestTests() throws InterruptedException {
        logger.info("Guest searching the product in application");
        inputSearchBox();
        clickSearchIcon();
        scrollDown();
        Thread.sleep(4000);
        clickProductItem();
        logger.info("Guest buy the product item");
        clickbuyButton();
    }

    public void searchByUserTests() throws InterruptedException {
        logger.info("User Trying to login into the application");
        loginPage.UserLogin1(prop.getProperty("emailID"),prop.getProperty("pass"));
        logger.info("User searching the product in application");
        inputSearchBox();
        clickSearchIcon();
        scrollDown();
        Thread.sleep(4000);
        clickProductItem();
        logger.info("User Add the product item into cart");
        clickAddToCart();
        Thread.sleep(5000);
    }
}
