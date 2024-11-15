package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends TestBase {

    public CheckoutPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id=\"checkout\"]")
    WebElement checkoutButton;

    @FindBy(name = "email")
    WebElement inputEmailID;

    @FindBy(name = "firstName")
    WebElement inputFirstName;

    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(id = "shipping-address1")
    WebElement inputAddress;

    @FindBy(id = "TextField2")
    WebElement inputApartmentName;

    @FindBy(xpath = "(//ul[@id=\"shipping-address1-options\"]/li[1])")
    WebElement shippingoption1;


    @FindBy(name = "city")
    WebElement inputCityName;

    @FindBy(id = "TextField4")
    WebElement inputPinCode;

    @FindBy(id = "TextField5")
    WebElement inputPhoneNumber;

    @FindBy(id = "basic-paymentOnDelivery")
    WebElement paymentOnDelivery;


    public void scrollDown() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("window.scrollBy(0,2500)");
        }
    }


    public void enterInputEmailId(String emailId) {
        inputEmailID.sendKeys(emailId);
    }

    public void selectCountry() {
        WebElement drpCountryEle = driver.findElement(By.id("Select0"));
        Select drpInd = new Select(drpCountryEle);
        drpInd.selectByVisibleText("India");
    }


    public void enterInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void enterInputAddress() throws InterruptedException {
        inputAddress.sendKeys("Thane");
        Thread.sleep(3000);
        inputAddress.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        //shippingoption1.click();
    }
    public void clickonCheckoutButton() {
        checkoutButton.click();
    }
    public void enterInputApartmentName(String apartment) {
        inputApartmentName.sendKeys(apartment);
    }

    public void enterInputCityName(String city) {
        inputCityName.sendKeys(city);
    }

    public void enterInputPhoneNumber(String phone) {
        inputPhoneNumber.sendKeys(phone);
    }

    public void enterInputPinCode(String pincode) {
        inputPinCode.sendKeys(pincode);
    }


    public void enterPaymentOnDelivery() {
        paymentOnDelivery.click();
    }


    public void checkoutForGuestTests(String emailId, String firstName, String lastName, String apartment, String city, String pincode, String phone) throws InterruptedException {
        logger.info("Guest checkout securely");
        enterInputEmailId(emailId);
        selectCountry();
        enterInputFirstName(firstName);
        enterInputLastName(lastName);
        enterInputAddress();
        enterInputApartmentName(apartment);
        scrollDown();
        enterInputCityName(city);
        enterInputPinCode(pincode);
        enterInputPhoneNumber(phone);
        logger.info("Payment Done");
        enterPaymentOnDelivery();

    }


    public void checkoutForUserTests(String apartment, String city, String pincode, String phone) throws InterruptedException {
        scrollDown();
        clickonCheckoutButton();
        logger.info("User checkout securely");
        enterInputAddress();
        enterInputApartmentName(apartment);
        scrollDown();
        enterInputCityName(city);
        enterInputPinCode(pincode);
        enterInputPhoneNumber(phone);
        logger.info("Payment Done");
        enterPaymentOnDelivery();

    }


}

