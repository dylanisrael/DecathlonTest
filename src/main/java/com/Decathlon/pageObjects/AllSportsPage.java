package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class AllSportsPage extends Page {

    private final static String URL_TENNIS_TABLE_MATERIAL_CLUB="https://www.decathlon.fr/browse/c0-tous-les-sports/c1-tennis-de-table/c2-materiel-club/_/N-1ko42sp";
    private final static String URL_PECHE_CANASSIER_PECHE_TRUITE = "https://www.decathlon.fr/browse/c0-tous-les-sports/c1-peche-des-carnassiers/c2-peche-de-la-truite/_/N-84p8uz";

    @FindBy(xpath="//a[contains(text(),'une balle')]")
    private WebElement oneBallLink;

    @FindBy(xpath ="//h1[contains(text(),'Erreur 404')]")
    private WebElement errorMessage;

    @FindBy(xpath ="//a[contains(text(),'canne toc')]")
    private WebElement fakeCaneLink;

    @FindBy(xpath ="//a[contains(text(),'bombette')]")
    private WebElement theBombshellLink;

    @FindBy(xpath ="//header/nav[1]/a[1]")
    private WebElement logoDecathlon;

    private int nbVerif =0;

    public AllSportsPage(){
    }

    public void gotoPageIdeeCadeauTenisTableMaterielClubPage() throws InterruptedException {
        get(URL_TENNIS_TABLE_MATERIAL_CLUB);
        cookieManager();
    }

    public void clicksOnCanneToc() {

        clickOn(fakeCaneLink);
        try{
            if(!logoDecathlon.isDisplayed()){
                nbVerif++;
                System.out.println(nbVerif);
            }
        }
        catch(Exception e){nbVerif++;
            System.out.println(nbVerif);}

        driver.navigate().back();
    }

    public void clicksOnLabombete(){
        clickOn(theBombshellLink);
        try{
            if(!logoDecathlon.isDisplayed()){
                nbVerif++;
                System.out.println(nbVerif);
            }
        }catch(Exception e){
            nbVerif++;
            System.out.println(nbVerif);
        }
    }

    public void gotoPecheDeCarnassierPecheTruitePage(){
        driver.navigate().to(URL_PECHE_CANASSIER_PECHE_TRUITE);
        waitForLoadingPage();
        cookieManager();
    }

    public void clicksOnUneballe(){
        clickOn(oneBallLink);
    }

    public boolean aBallRelatedPageIsDisplayed() throws IOException{

        if (nbVerif==2){
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
    public boolean aBomshellRelatedPageIsDisplayed() throws IOException, InterruptedException {
        if(nbVerif==2){

            bugStatus = "KO";
            System.out.println("❌ "+bugStatus+" Les page sont toujours indisponible bug non corrige");
            return false;

        }
        else {
            bugStatus = "OK";
            System.out.println("✅ "+bugStatus+" Les page sont maintenant disponible bug corrige");
            return true;
        }
    }

}
