package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class BikeLockPage extends Page {

    @FindBy(xpath="//a[contains(text(),'Decathlon.ch')]")
    private WebElement decathlonChLink;

    @FindBy(xpath ="//h1[contains(text(),'404')]")
    private WebElement errorMessage;

    private final static String PAGE_URL="https://www.decathlon.fr/browse/c0-tous-les-sports/c1-velo-cyclisme/c2-antivols-velo/_/N-1ohyav9";

    public BikeLockPage(){}

    public void clickOnDecathlonCh() {
       wait.until(ExpectedConditions.elementToBeClickable(decathlonChLink));
        clickOn(decathlonChLink);
    }

    public  void gotoAntivolVeloPage()  {
        get(PAGE_URL);
        cookieManager();
    }

    public Boolean aDecathlon_ch_RelatedPageIsDisplayed() throws IOException {

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
