package com.Decathlon.pageObjects;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.util.List;

public class MySportPage extends Page {
    
    private final String URL = env + "/account/mySports#";
    private final String PICTURE_URL = env + "/assets/images/sports/sport-4006.png";
    
    public MySportPage() {
    }
    
    public void goToMySportPage() {
        get(URL);
        scroll(500);
    }
    
    public boolean allImagesAreAvailableOnPage() throws IOException {
        
        waitForLoadingPage();
        
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        
        if (getUrlResponseCode(PICTURE_URL) != 404) {
            Log.info("✅  Les images sont maintenant disponible bug corrige");
            return true;
        } else {
            Log.error("❌  Les images sont toujours indisponible bug non corrige");
            return false;
        }
        
    }
    
}
