package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewPage extends Page {
    
    private String URL_AVIS_PAGE = env + "/landing/avis-clients-decathlon/_/R-a-avis";
    
    @FindBy(className = "block-enhanced-products-img-img")
    private List<WebElement> mp3EtancheItems;
    
    @FindBy(css = "h1.svelte-1lk6rqz")
    private WebElement itemShown;
    
    @FindBy(css = "div.txtcenter>a.btn")
    private WebElement donnerAvisButton;
    
    
    public ReviewPage() {
    }
    
    public void gotoAvisPage() {
        get(URL_AVIS_PAGE);
        Log.info("im on avis page");
        cookieManager();
        Log.info("cookies accepted");
        
    }
    
    public void clickOnDonnerAvis() {
        donnerAvisButton.click();
    }
    
    public void userClicksOnNosServices() {
    
    }
    
    public void clickOnMp3() {
        int i = 0;
        System.out.println("nombre d'elts" + mp3EtancheItems.size());
        WebElement mp3 = null;
        for (WebElement element : mp3EtancheItems) {
            if (element.getAttribute("src").contains("mp3")) {
                mp3 = element;
                Log.info("i have located mp3 etance");
            }
        }
        clickOn(mp3);
        Log.info("i have clicked on mp3 etance");
    }
    
    public boolean theProductsAreMP3() {
        
        String articleDescription = itemShown.getText();
        
        System.out.println("l'article affcihé est : " + articleDescription);
        
        if (!driver.getPageSource().contains("mp3")) {
            
            Log.info("❌  L'article affiché ne correspond pas a l'article selectionné bug non corrige");
            return false;
        } else {
            Log.error("✅ L'article affiché correspond a l'article selectionné bug corrige");
            return true;
        }
    }
    
}
