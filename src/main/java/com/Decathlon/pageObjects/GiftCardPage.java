package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GiftCardPage extends Page {

    private String pageUrl ="https://www.decathlon.fr/landing/carte-cadeau/_/R-a-carte-cadeau";

    @FindBy(xpath="//a[contains(text(),'Consulter le solde')]")
    private WebElement checkBalance;

    @FindBy(xpath = "//body/div[@id='main-container']/div[1]/section[2]/form[1]/div[1]/input[1]")
    private WebElement giftCardNumberField;

    @FindBy(xpath = "")
    private WebElement pinCodeField;

    @FindBy(xpath = "//body/div[@id='main-container']/div[1]/section[2]/form[1]/div[3]/div[1]/div[1]/iframe[1]")
    private WebElement captchaFrame;

    @FindBy(xpath = "//body/div[@id='main-container']/div[1]/section[2]/form[1]/div[3]/div[1]/div[1]/iframe[1]")
    private WebElement checkCaptcha;

    public GiftCardPage(){}

    public void goToPage() {
        get(pageUrl);
        cookieManager();
    }

    public void clickOnCheckBalance() {

        clickOn(checkBalance);
        shortWait.until(frameToBeAvailableAndSwitchToIt(captchaFrame));

        shortWait.until(elementToBeClickable(checkCaptcha)).click();
    }



}
