package com.Decathlon.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {
    
    
    public HomePage() {
    }
    
    private final String HOME_PAGE_URL = env;
    private String userEmail = "malikadouma19@gmail.com";
    private String userPassword = "Malika2016";
    
    @FindBy(css = ".svelte-n8aq2c>a")
    private List<WebElement> myAccountButton;
    
    @FindBy(id = "input-email")
    private WebElement emailField;
    
    @FindBy(id = "lookup-btn")
    private WebElement next;
    
    @FindBy(id = "input-password")
    private WebElement passwordField;
    
    @FindBy(id = "signin-button")
    private WebElement signinButton;
    
    
    public void login() {
        
        get(HOME_PAGE_URL);
        cookieManager();
        clickOn(myAccountButton.stream().filter(icon -> icon.getAttribute("href").toLowerCase().contains("account")).findFirst().get());
        shortWait.until(visibilityOf(emailField)).sendKeys(userEmail);
        Log.info("user enter");
        waitUntil(elementToBeClickable(next));
        clickOn(next);
        shortWait.until(visibilityOf(passwordField)).sendKeys(userPassword);
        clickOn(signinButton);
        clickOn(decathlonLogo);
    }
}
