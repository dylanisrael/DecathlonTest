package com.Decathlon.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page{


    public HomePage(){ }

    private String bugStatus ="KO";
    private final static   String HOME_PAGE_URL = "https://www.decathlon.fr/";
    private  String userEmail = "malikadouma19@gmail.com";
    private  String userPassword="Malika2016";
    private  String cardNumber = "4074 6357 6884 9529";
    private  String cardOwner = "Brooklyn Berg";
    private  String cardDate = "1226";
    private  String cardValidationCode = "824";

    @FindBy(xpath ="//header/nav[1]/a[2]")
    private  WebElement logoToHomePage;

    @FindBy(xpath = "//button[@id='didomi-notice-agree-button']")
    private  WebElement acceptCookieButton;

    @FindBy(xpath ="//header/nav[1]/div[2]/div[3]/a[1]/*[1]")
    private  WebElement myAccountButton;

    @FindBy(xpath = "//input[@id='input-email']")
    private  WebElement emailField;

    @FindBy(xpath = "//button[@id='lookup-btn']")
    private  WebElement next;

    @FindBy(xpath = "//input[@id='input-password']")
    private  WebElement passwordField;

    @FindBy(xpath = "//button[@id='signin-button']")
    private  WebElement signinButton;

    @FindBy(xpath ="//body/div[@id='app']/main[1]/div[1]/article[1]/section[1]/section[5]/button[1]")
    private  WebElement disabledButton;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/section[2]/div[1]/div[1]/div[2]/div[3]/a[1]")
    private  WebElement article;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/article[1]/div[1]/div[4]/div[2]/button[1]")
    private  WebElement addToTheCartButton;

    @FindBy(xpath ="//body/div[@id='app']/main[1]/section[1]/div[1]/a[1]")
    private  WebElement viewMyCartButton;

    @FindBy(xpath ="/html[1]/body[1]/div[2]/main[1]/div[1]/article[1]/section[1]/div[1]/div[1]/button[1]")
    private  WebElement confirmOrderButton;

    public  void selectArticle(){article.click();}

    public  void addItemToTheCart(){addToTheCartButton.click();}

    public  void viewMyCart(){viewMyCartButton.click();}

    public  void confirmOrder(){confirmOrderButton.click();}

    public  void login(){

        get(HOME_PAGE_URL);
        cookieManager();
        clickOn(myAccountButton);
        shortWait.until(visibilityOf(emailField)).sendKeys(userEmail);
        clickOn(next);
        shortWait.until(visibilityOf(passwordField)).sendKeys(userPassword);
        clickOn(signinButton);
        clickOn(logoToHomePage);
    }
}
