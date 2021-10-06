package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BikeLockPage extends Page {
    
    @FindBy(partialLinkText = "Decathlon.ch")
    private WebElement decathlonChLink;
    
    private final String PAGE_URL = env + "/browse/c0-tous-les-sports/c1-velo-cyclisme/c2-antivols-velo/_/N-1ohyav9";
    
    public BikeLockPage() {
    }
    
    public void clickOnDecathlonCh() {
        longUntil(visibilityOf(decathlonChLink));
        clickOn(decathlonChLink);
    }
    
    public void gotoAntivolVeloPage() {
        get(PAGE_URL);
        cookieManager();
    }
    
    public Boolean aDecathlon_ch_RelatedPageIsDisplayed() {
        
        if (checkUrlResponseCode(getPageUrl())) {
            
            Log.info("✅  La page est maintenant disponible bug corrige");
            return true;
        } else {
            
            Log.error("❌  La page est toujours indisponible bug non corrige");
            return false;
        }
    }
}
