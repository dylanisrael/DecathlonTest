package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class AllSportsPage extends Page {
    
    private final String URL_TENNIS_TABLE_MATERIAL_CLUB = env + "/browse/c0-tous-les-sports/c1-tennis-de-table/c2-materiel-club/_/N-1ko42sp";
    private final String URL_PECHE_CANASSIER_PECHE_TRUITE = env + "/browse/c0-tous-les-sports/c1-peche-des-carnassiers/c2-peche-de-la-truite/_/N-84p8uz";
    
    @FindBy(linkText = "une balle")
    private WebElement oneBallLink;
    
    @FindBy(linkText = "canne toc")
    private WebElement fakeCaneLink;
    
    @FindBy(linkText = "bombette")
    private WebElement theBombshellLink;
    
    
    private int nbVerif = 0;
    
    public AllSportsPage() {
    }
    
    public void gotoPageIdeeCadeauTenisTableMaterielClubPage() {
        get(URL_TENNIS_TABLE_MATERIAL_CLUB);
        cookieManager();
    }
    
    public void clicksOnCanneToc() {
        
        clickOn(fakeCaneLink);
        try {
            if (!decathlonLogo.isDisplayed()) {
                nbVerif++;
                System.out.println(nbVerif);
            }
        } catch (Exception e) {
            nbVerif++;
            System.out.println(nbVerif);
        }
        
        driver.navigate().back();
    }
    
    public void clicksOnLabombete() {
        clickOn(theBombshellLink);
        try {
            if (!decathlonLogo.isDisplayed()) {
                nbVerif++;
                System.out.println(nbVerif);
            }
        } catch (Exception e) {
            nbVerif++;
            System.out.println(nbVerif);
        }
    }
    
    public void gotoPecheDeCarnassierPecheTruitePage() {
        driver.navigate().to(URL_PECHE_CANASSIER_PECHE_TRUITE);
        waitForLoadingPage();
        cookieManager();
    }
    
    public void clicksOnUneballe() {
        clickOn(oneBallLink);
    }
    
    public boolean aBallRelatedPageIsDisplayed() throws IOException {
        
        if (nbVerif == 2) {
            
            Log.info("✅  La page est maintenant disponible bug corrige");
            return true;
        } else {
            Log.error("❌  La page est toujours indisponible bug non corrige");
            return false;
        }
    }
    
    public boolean aBomshellRelatedPageIsDisplayed() throws IOException, InterruptedException {
        if (nbVerif == 2) {
            
            Log.error("❌  Les page sont toujours indisponible bug non corrige");
            return false;
        } else {
            
            Log.info("✅  Les page sont maintenant disponible bug corrige");
            return true;
        }
    }
    
}
