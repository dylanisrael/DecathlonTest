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

   private  String errorPageUrl = "https://www.decathlon.fr/landing/carte-cadeau-responsable-decathlon/_/carte-cadeau.decathlon.fr";

   @FindBy(css = "#gl_21")
   private  WebElement discoverCartePersoButton;

   @FindBy(css = "div#gl_110.gl_autodiv")
   private  WebElement discoverECarteButton;

   @FindBy(xpath ="//h1[contains(text(),'Erreur 404')]")
   private  WebElement errorMessage;

   @FindBy(css = "body.product-page:nth-child(2) div.navigation--opened.ab-cado-main-container:nth-child(9) div.container.container-floor:nth-child(7) div.GC div.GC__infos div.modalv2.privacy-infos-modal:nth-child(7) div.modalv2__content div.modalv2__holder div.modalv2__body div.privacy-infos__holder div:nth-child(1) article.privacy-rules ul.privacy-rules__list li.privacy-rules__item:nth-child(2) > div:nth-child(2)")
   private  WebElement ecarteError;

   @FindBy(css = "div.privacy-infos__holder")
   private WebElement cardContainer;

   @FindBy(className = "privacy-rules__item__title")
   private WebElement cardElement;

   @FindBy(xpath ="//label[contains(text(),'notre politique des ')]")
   private  WebElement ourPolicyLink;

   @FindBy(id="countrySelector")
   private  WebElement arrowHead5h11h;

   private final static   String URL = "https://www.decathlon.fr/landing/carte-cadeau-responsable-decathlon/_/R-a-carte-cadeau-responsable";
   public final static String Url5h11h = "https://www.decathlon.fr/landing/glaciere-ice-fresh-compact-quechua/_/R-a-glaciere-ice-fresh-compact-quechua";

   public LandingPage(){}

   public  void gotoPage() {
      get(URL);
      cookieManager();
   }

   public  void clicksOnDiscover() {

      driver.navigate().to(errorPageUrl);
      waitForLoadingPage();
   }

   public  void clicksOnDiscoverECarte() {
      clickOn(discoverECarteButton);
      waitForLoadingPage();
      ArrayList<String> tabs_windows = new ArrayList<>(driver.getWindowHandles());
      driver.switchTo().window(tabs_windows.get(0));
      driver.close();
      driver.switchTo().window(tabs_windows.get(1));
   }

   public  void clicksOnOurPrivacy(){
      ourPolicyLink.click();
   }

   public  void goto5h11hPage(){
      driver.navigate().to(Url5h11h);
   }

   public  boolean aStructuredPageWellPositionedElementsIsDisplayed(){

      Rectangle size = getElementSize(arrowHead5h11h);
      System.out.println(getElementSize(arrowHead5h11h));
      System.out.println(size);

      if (size.getWidth() != 300){
         bugStatus = "OK";
         System.out.println("✅ "+bugStatus+" Le contenu du menu est visible Bug corrige");
         return true;
      }else{
         System.out.println("❌ "+bugStatus+" La contenu du menu n'est pas visible Bug non corrige");
         return false;
      }
   }


   public  boolean imOnPersolizedGiftCardPage() throws IOException {

      waitForLoadingPage();
      if (getUrlResponseCode(getPageUrl()) < 400 || getUrlResponseCode(getPageUrl()) > 499) {
         bugStatus = "OK";
         System.out.println("✅ "+bugStatus+" La page est maintenant disponible bug corrige");
         return true;
      }
      else{
         bugStatus = "KO";
         System.out.println("❌ "+bugStatus+" La page est toujours indisponible bug non corrige");
         return false;
      }
   }

   public boolean textDescriptionIsVisible() throws IOException {

      if (waitUntil(visibilityOf(cardContainer))){

         waitUntil(visibilityOf(cardElement));

         List<WebElement> allConainerElts = driver.findElements(By.className("privacy-rules__item__title"));
         System.out.println("li element" + allConainerElts.size());
         Rectangle size = getElementSize(allConainerElts.get(1));
         int width =size.getWidth();
         System.out.println(width);

         if (width > 1){
            bugStatus = "OK";
            System.out.println("✅ "+bugStatus+" Le contenu du menu est visible Bug corrige");
         return true;
         } else{
            System.out.println("❌ "+bugStatus+" La contenu du menu n'est pas visible Bug non corrige");
          }
      }
      return false;
   }
}
