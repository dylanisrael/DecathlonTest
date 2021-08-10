package com.Decathlon.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DeliveryModePage extends Page{

    private  String pageUrl = "https://www.decathlon.fr/landing/modes-de-livraison/_/R-a-modes-livraison";

    @FindBy(xpath ="//body/div[@id='main-container']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/a[1]")
    private WebElement tableElement ;

    public DeliveryModePage(){}
    public  void goToPage() {
       get(pageUrl);
       cookieManager();
    }

    public  void clickOnTableElement() {
        clickOn(tableElement);}
    public  Boolean userIsOnAnewPage() throws InterruptedException {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<String> errorsTable = new ArrayList<>();
        List<LogEntry> logs = logEntries.getAll();
        for(LogEntry logEntry : logs) {
            if (logEntry.toString().contains("Uncaught TypeError: Cannot read property 'top' of undefined")){
                System.out.println("⚠️"+logEntry);
                errorsTable.add(logEntry.toString());
            }

        }
        if(!errorsTable.isEmpty()){
            bugStatus = "KO";
            System.out.println("❌ "+bugStatus+" Aucune reaction apres click bug non corrige");
            return false;
        }else {
            bugStatus = "KO";
            System.out.println("✅ "+bugStatus+" les elements reagissent apres le click bug non corrige");
            return true;
        }
        }
    }


