package com.Decathlon.pageObjects;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.util.List;

public class MySportPage extends Page {

    private final static String URL = "https://www.decathlon.fr/account/mySports#";
    private final static String PICTURE_URL ="https://www.decathlon.fr/assets/images/sports/sport-4006.png";

    public MySportPage(){}

    public  void goToMySportPage() {
        get(URL);
        scroll(500);
    }

    public  boolean allImagesAreAvailableOnPage() throws IOException {

        waitForLoadingPage();

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        for(LogEntry logEntry : logs) {
            if (logEntry.toString().contains("Failed to load resource")){
                System.out.println("⚠️"+logEntry);
            }
        }

        if (getUrlResponseCode(PICTURE_URL) != 404){
            bugStatus = "OK";
            System.out.println("✅ "+bugStatus+" Les images sont maintenant disponible bug corrige");
            return true;
        }
        else{
            bugStatus = "KO";
            System.out.println("❌ "+bugStatus+" Les images sont toujours indisponible bug non corrige");
            return false;
        }

    }

}
