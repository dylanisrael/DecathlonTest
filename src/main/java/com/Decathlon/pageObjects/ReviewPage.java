package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ReviewPage extends Page {

    private String URL_AVIS_PAGE ="https://www.decathlon.fr/landing/avis-clients-decathlon/_/R-a-avis";

    @FindBy(xpath  ="/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/a[1]/img[1]")
    private  WebElement mp3EtancheItem;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/article[1]/div[1]/h1[1]")
    private  WebElement itemShown;

    @FindBy(xpath = "//body/div[@id='main-container']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/a[1]")
    private  WebElement donnerAvisButton;

    @FindBy(xpath ="")
    private  WebElement nosServicesButton;

    public ReviewPage(){}

    public  void gotoAvisPage(){
        get(URL_AVIS_PAGE);
        cookieManager();
    }

    public  void clickOnDonnerAvis(){
        donnerAvisButton.click();
    }

    public  void userClicksOnNosServices(){

    }

    public  void clickOnMp3(){
        mp3EtancheItem.click();
    }

    public  boolean theProductsAreMP3(){

        String articleDescription = wait.until(visibilityOf(itemShown)).getText();

        System.out.println("l'article affcihé est : "+articleDescription);

        if (!articleDescription.contains("mp")){
            bugStatus = "KO";
            System.out.println("❌ "+bugStatus+" L'article affiché ne correspond pas a l'article selectionné bug non corrige");
            return false;
        }
        else {
            bugStatus = "OK";
            System.out.println("✅ "+bugStatus+"L'article affiché correspond a l'article selectionné bug corrige");
            return true;
        }
    }

}
