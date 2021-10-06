package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class MaterialClubPage extends Page {
    
    @FindBy(linkText = "Le nettoyant")
    private WebElement theCleanserLink;
    
    public MaterialClubPage() {
    }
    
    public void clickOnLeNetoyant() throws InterruptedException {
        clickOn(theCleanserLink);
    }
    
    public boolean aPageWithCleanserIsDisplayed() throws IOException {
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
