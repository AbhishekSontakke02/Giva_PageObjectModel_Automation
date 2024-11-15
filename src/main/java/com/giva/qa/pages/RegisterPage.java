package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase {
    public RegisterPage(){
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[@class=\"small-hide\"])[3]")
    WebElement accountLogo;

    @FindBy(linkText = "Create a new account")
    WebElement newAccount;

    @FindBy(name = "customer[first_name]")
    WebElement inputFirstName;

    @FindBy(name = "customer[last_name]")
    WebElement inputLastName;

    @FindBy(name = "customer[email]")
    WebElement inputEmailId;

    @FindBy(name = "customer[password]")
    WebElement inputPassword;

    @FindBy(xpath = "(//button)[11]")
    WebElement accountButton;

    public void clickAccountLogo(){
        accountLogo.click();
    }

    public void clickNewAccount(){
        newAccount.click();
    }

    public void enterInputFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
    }

    public void enterInputLastName(String lastName){
        inputLastName.sendKeys(lastName);
    }

    public void enterInputEmailId(String emailId){
        inputEmailId.sendKeys(emailId);
    }

    public void enterInputPassword(String pass){
        inputPassword.sendKeys(pass);
    }

    public void createAccountButton(){
        accountButton.click();
    }



    public void registerTest(String firstName,String lastName,String emailID,String password){
        logger.info("Register the application");
        clickAccountLogo();
        clickNewAccount();
        enterInputFirstName(firstName);
        enterInputLastName(lastName);
        enterInputEmailId(emailID);
        enterInputPassword(password);
        createAccountButton();

    }




}
