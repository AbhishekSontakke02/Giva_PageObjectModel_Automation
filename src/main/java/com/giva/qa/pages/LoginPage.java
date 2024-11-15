package com.giva.qa.pages;

import com.giva.qa.base.TestBase;

import com.giva.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {
    //Initilize Page Object
    public LoginPage(){
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[@class=\"small-hide\"])[3]")
    WebElement accountLogo;

    @FindBy(name = "customer[email]")
    WebElement inputEmailId;

    @FindBy(name = "customer[password]")
    WebElement inputPassword;

    @FindBy(xpath = "(//button)[12]")
    WebElement loginButton;

    @FindBy(xpath = "(//span[@class=\"small-hide\"])[3]")
    WebElement wishlistIcon;

    @FindBy(xpath = "(//a[@id=\"btn\"])[1]")
    WebElement startShoppingBtn;

    public String email = prop.getProperty("emailID");
    public String pwd = prop.getProperty("pass");



    public void clickAccountLogo(){
        accountLogo.click();
    }

    public void enterInputEmailId(){
        inputEmailId.sendKeys(email);
    }

    public void enterInputPassword(){
        inputPassword.sendKeys(pwd);
    }

    public void enterInputEmailId1(String emailID){
        inputEmailId.sendKeys(emailID);
    }

    public void enterInputPassword1(String password){
        inputPassword.sendKeys(password);
    }

    public void clickloginButton(){
        loginButton.click();
    }

    public void clickWishlistIcon(){
        wishlistIcon.click();
    }

    public void clickStartShoppingBtn(){
        startShoppingBtn.click();
    }


    public String getTitle() {
        return driver.getTitle();
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateAccountButton(){
        return accountLogo.isDisplayed();
    }

    public void loginTest(){
        logger.info("User Login the application");
        clickAccountLogo();
        enterInputEmailId();
        enterInputPassword();
        clickloginButton();

    }

    public void wishListTest(){
        logger.info("User Login the application");
        clickAccountLogo();
        enterInputEmailId();
        enterInputPassword();
        clickloginButton();
        clickWishlistIcon();
        logger.info("Wishlist page is running");
        //   clickStartShoppingBtn();
    }


    public void multipleUserLogin(String emailID,String password){
        logger.info("Multiple User login the application");
        clickAccountLogo();
        enterInputEmailId1(emailID);
        enterInputPassword1(password);
        clickloginButton();
    }

    public void UserLogin1(String email,String pwd){
        clickAccountLogo();
        enterInputEmailId1(email);
        enterInputPassword1(pwd);
        clickloginButton();
    }









}
