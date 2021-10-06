package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodPage extends Page {
    
    private final String URL = env + "/landing/moyens-de-paiement-decathlon/_/R-a-moyens-paiement";
    
    @FindBy(className = "collapsed")
    private List<WebElement> cardButtons;
    
    @FindBy(className = "cta-v2--alt cta-v2--s mb20")
    public WebElement findOutMoreButton;
    
    
    public void goToPage() {
        get(URL);
        cookieManager();
    }
    
    public void clicksOnCarteIllicado() {
        Log.info("search for carte illicado");
        for (WebElement card : cardButtons) {
            if (card.getText().contains("illicado")) {
//                clickOn(card);
                card.click();
                Log.info("click on carte illicado");
            }
        }
    }
    
    public void clickOnEnsavoirPlus() {
        clickOn(findOutMoreButton);
        ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(0));
        driver.close();
//        driver.switchTo().window(tabs_windows.get(1));
    }
    
    public boolean informationsAboutIllicadoCardAreDisplayed() throws IOException {
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
