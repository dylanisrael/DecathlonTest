package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkshopPage extends Page {
    
    private final String URL = env + "/browse/c0-services/c1-atelier/_/N-11tjdup";
    
    @FindBy(xpath = "//a/span[contains(text(),'Sports d')]")
    private WebElement waterSportLink;
    
    public WorkshopPage() {
    }
    
    public void gotoPage() {
        get(URL);
        cookieManager();
    }
    
    public void clickOnWaterSport() {
        clickOn(waterSportLink);
    }
    
    public boolean imOnQuechaPresentationBoxesPage() {
        
        if (getPageUrl().contains("eau")) {
            Log.info("✅ Le lien renvoi vers la page relative bug corrige");
            return true;
        } else {
            Log.error("❌  Le lien ne renvoi toujours pas vers la page relative bug non corrige");
            return false;
        }
        
    }
}
