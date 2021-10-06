package com.Decathlon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LandingPage extends Page {
    
    private String errorPageUrl = env + "/landing/carte-cadeau-responsable-decathlon/_/carte-cadeau.decathlon.fr";
    
    @FindBy(id = "gl_22")
    private WebElement discoverECarteButton;
    
    @FindBy(css = "div.privacy-infos__holder")
    private WebElement cardContainer;
    
    @FindBy(className = "privacy-rules__item__title")
    private WebElement cardElement;
    
    @FindBy(xpath = "//label[contains(text(),'notre politique des ')]")
    private WebElement ourPolicyLink;
    
    @FindBy(id = "countrySelector")
    private WebElement arrowHead5h11h;
    
    private final String URL = env + "/landing/carte-cadeau-responsable-decathlon/_/R-a-carte-cadeau-responsable";
    public final String Url5h11h = env + "/landing/glaciere-ice-fresh-compact-quechua/_/R-a-glaciere-ice-fresh-compact-quechua";
    
    public LandingPage() {
    }
    
    public void gotoPage() {
        get(URL);
        waitUntil(visibilityOf(decathlonLogo));
        cookieManager();
        Log.info("im on carte cadeau page");
    }
    
    public void clicksOnDiscover() {
        
        driver.navigate().to(errorPageUrl);
        waitForLoadingPage();
        Log.info("Click on Discover");
    }
    
    public void clicksOnDiscoverECarte() {
        clickOn(discoverECarteButton);
        Log.info("click on discover ECarte");
        waitForLoadingPage();
        ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(0));
        driver.close();
        driver.switchTo().window(tabs_windows.get(1));
    }
    
    public void clicksOnOurPrivacy() {
        clickOn(ourPolicyLink);
        Log.info("Click on Our Privacy");
    }
    
    public void goto5h11hPage() {
        driver.navigate().to(Url5h11h);
        Log.info("im on carte 5h11h page");
    }
    
    public boolean aStructuredPageWellPositionedElementsIsDisplayed() {
        
        Rectangle size = getElementSize(arrowHead5h11h);
        System.out.println(getElementSize(arrowHead5h11h));
        System.out.println(size);
        
        if (size.getWidth() != 300) {
            Log.info("✅  Le contenu du menu est visible Bug corrige");
            return true;
        } else {
            Log.error("❌  La contenu du menu n'est pas visible Bug non corrige");
            return false;
        }
    }
    
    
    public boolean imOnPersolizedGiftCardPage() throws IOException {
        
        waitForLoadingPage();
        if (getUrlResponseCode(getPageUrl()) < 400 || getUrlResponseCode(getPageUrl()) > 499) {
            Log.info("✅ La page est maintenant disponible bug corrige");
            return true;
        } else {
            Log.error("❌  La page est toujours indisponible bug non corrige");
            return false;
        }
    }
    
    public boolean textDescriptionIsVisible() throws IOException {
        
        if (waitUntil(visibilityOf(cardContainer))) {
            
            waitUntil(visibilityOf(cardElement));
            
            List<WebElement> allConainerElts = driver.findElements(By.className("privacy-rules__item__title"));
            System.out.println("li element" + allConainerElts.size());
            Rectangle size = getElementSize(allConainerElts.get(1));
            int width = size.getWidth();
            System.out.println(width);
            
            if (width > 1) {
                Log.info("✅  Le contenu du menu est visible Bug corrige");
                return true;
            } else {
                Log.error("❌  La contenu du menu n'est pas visible Bug non corrige");
            }
        }
        return false;
    }
}
