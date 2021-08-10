package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;

public class PaymentMethodPage extends Page {

    private final static String URL="https://www.decathlon.fr/landing/moyens-de-paiement-decathlon/_/R-a-moyens-paiement\n";

    @FindBy(xpath="//body/div[@id='main-container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[7]/div[1]/div[1]/div[1]/h4[1]/a[1]")
    private  WebElement illicadoCardButton;

    public PaymentMethodPage(){}

    public  void goToPage(){
        get(URL);
        cookieManager();
    }

    @FindBy(xpath="//a[contains(text(),'En savoir +')]")
    public  WebElement findOutMoreButton;

    public  void clicksOnCarteIllicado() {
        clickOn(illicadoCardButton);
    }

    public  void clickOnEnsavoirPlus() {
        clickOn(findOutMoreButton);
        ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(0));
        driver.close();
        driver.switchTo().window(tabs_windows.get(1));
    }

    public  boolean informationsAboutIllicadoCardAreDisplayed() throws IOException {
        waitForLoadingPage();

        if (getUrlResponseCode(getPageUrl()) != 404) {
            bugStatus = "OK";
            System.out.println("✅ " + bugStatus + " La page est maintenant disponible bug corrige");
            return true;
        } else {
            bugStatus = "KO";
            System.out.println("❌ " + bugStatus + " La page est toujours indisponible bug non corrige");
            return false;
        }
    }
}
