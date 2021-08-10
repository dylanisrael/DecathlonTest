package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkshopPage extends Page {

    private final static String URL = "https://www.decathlon.fr/browse/c0-services/c1-atelier/_/N-11tjdup";

    @FindBy(xpath ="//a/span[contains(text(),'Sports d')]")
    private  WebElement waterSportLink;

    public WorkshopPage(){}

    public  void  gotoPage(){
        get(URL);
        cookieManager();
    }

    public  void clickOnWaterSport(){
        clickOn(waterSportLink);
    }

    public boolean imOnQuechaPresentationBoxesPage(){

        if(getPageUrl().contains("eau")){
            bugStatus = "OK";
            System.out.println("✅ " + bugStatus + " Le lien renvoi vers la page relative bug corrige");
            return true;
        } else {
            bugStatus = "KO";
            System.out.println("❌ " + bugStatus + " Le lien ne renvoi toujours pas vers la page relative bug non corrige");
            return false;
         }

    }
}
