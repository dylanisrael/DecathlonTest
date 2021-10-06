package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BikeStemPage extends Page {
    
    @FindBy(linkText = "Ireland'")
    private WebElement irelandLink;
    
    @FindBy(className = "seemore-icon")
    private WebElement readMoreButton;
    
    @FindBy(id = "lgcookieslaw_accept")
    private WebElement cookieAcceptButton;
    
    @FindBy(xpath = "//p[contains(text(),'Pour changer une')]")
    private WebElement readMoreContent;
    
    private final String URL_PAGE = env + "/browse/c0-tous-les-sports/c1-velo-cyclisme/c2-potences-velo/_/N-11a2dco";
    
    public BikeStemPage() {
    }
    
    public void goToPotencesVelo() {
        get(URL_PAGE);
        cookieManager();
    }
    
    public void clickOnLirePlus() {
        wait.until(ExpectedConditions.elementToBeClickable(readMoreButton));
        clickOn(readMoreButton);
    }
    
    public void clickOnIreland() {
        waitUntil(visibilityOf(readMoreContent));
        clickOn(irelandLink);
    }
    
    public boolean anIrelandRelatedPageIsDisplayed() throws IOException {
        waitForLoadingPage();
        if (getUrlResponseCode(getPageUrl()) != 404) {
            Log.info("✅  La page est maintenant disponible bug corrige");
            return true;
        } else {
            Log.error("❌  La page est toujours indisponible bug non corrige");
            return false;
        }
    }
    
    
}
