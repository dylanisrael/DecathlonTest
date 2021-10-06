package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardPage extends Page {
    
    private String pageUrl = env + "/landing/carte-cadeau/_/R-a-carte-cadeau";
    
    @FindBy(linkText = "Consulter le solde")
    private WebElement checkBalance;
    
    public GiftCardPage() {
    }
    
    public void goToPage() {
        get(pageUrl);
        cookieManager();
    }
    
    
}
