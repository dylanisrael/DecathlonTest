package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CampingBivouacPage extends Page {
    
    private String url = env + "/browse/c0-tous-les-sports/c1-camping-bivouac/c2-boire-et-manger/_/N-1di3h1c";
    
    @FindBy(partialLinkText = "boîtes alimentaires et bouteilles isothermes Quech")
    private WebElement quechaBottlesAndBoxes;
    
    public CampingBivouacPage() {
    }
    
    public void goToBoireEtManger() {
        get(url);
        cookieManager();
    }
    
    public void clickOnBoiteEtBouteille() {
        clickOn(quechaBottlesAndBoxes);
    }
    
    public boolean boxAndBottlesRelatedPageIsDisabled() throws IOException {
        
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
