package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BikeStemPage extends Page {

    @FindBy(xpath="//a[contains(text(),'Ireland')]")
    private  WebElement irelandLink;

    @FindBy(xpath="//button[@class='svelte-ymbksn']")
    private  WebElement readMoreButton;

    @FindBy(xpath = "//h1[contains(text(),'404')]")
    private  WebElement errorMessage;

    @FindBy(xpath ="//button[@id='lgcookieslaw_accept']")
    private  WebElement cookieAcceptButton;

    @FindBy(xpath="//p[contains(text(),'Pour changer une')]")
    private WebElement readMoreContent;

    private final static String URL_PAGE="https://www.decathlon.fr/browse/c0-tous-les-sports/c1-velo-cyclisme/c2-potences-velo/_/N-11a2dco";

    public BikeStemPage(){}

    public  void goToPotencesVelo() throws InterruptedException {
        get(URL_PAGE);
        cookieManager();
    }

    public  void clickOnLirePlus(){
        wait.until(ExpectedConditions.elementToBeClickable(readMoreButton));
        clickOn(readMoreButton);
    }

    public  void clickOnIreland(){
        waitUntil(visibilityOf(readMoreContent));
        clickOn(irelandLink);
    }

    public  boolean anIrelandRelatedPageIsDisplayed() throws IOException{
    waitForLoadingPage();
        if (!errorMessage.isDisplayed()){
            bugStatus = "OK";
            System.out.println("✅ "+bugStatus+" La page est maintenant disponible bug corrige");
            return true;
        }
        else{
            bugStatus = "KO";
            System.out.println("❌ "+bugStatus+" La page est toujours indisponible bug non corrige");
            return false;
        }
    }


}
