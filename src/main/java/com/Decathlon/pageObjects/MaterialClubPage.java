package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class MaterialClubPage extends Page {

    private  String url;

    @FindBy(xpath="//a[contains(text(),'Le nettoyant')]")
    private  WebElement theCleanserLink;

    public MaterialClubPage(){}
    public  void clickOnLeNetoyant() throws InterruptedException {
        clickOn(theCleanserLink);
    }

    public  boolean aPageWithCleanserIsDisplayed() throws IOException {
        waitForLoadingPage();
        if (getUrlResponseCode(getPageUrl()) != 404){
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
