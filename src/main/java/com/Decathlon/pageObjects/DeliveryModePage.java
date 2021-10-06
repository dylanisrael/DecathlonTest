package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeliveryModePage extends Page {
    
    private String pageUrl = env + "/landing/modes-de-livraison/_/R-a-modes-livraison";
    private String title;
    
    @FindBy(css = ".stable>li>a")
    private List<WebElement> tableElements;
    
    public DeliveryModePage() {
    }
    
    public void goToPage() {
        get(pageUrl);
        cookieManager();
        title = getTitle();
    }
    
    public void clickOnTableElement() {
        for (WebElement element : tableElements) {
            clickOn(element);
        }
        
    }
    
    public Boolean userIsOnAnewPage() {
        
        if (title.equals(getTitle())) {
            Log.info("le titre de la page est {}", getTitle());
            Log.error("❌  Aucune reaction apres click bug non corrige");
            
            return false;
        } else {
            Log.info("✅  les elements reagissent apres le click bug non corrige");
            return true;
        }
    }
}


