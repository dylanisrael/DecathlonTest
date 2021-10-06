package com.Decathlon.pageObjects;

import com.Decathlon.config.Configuration;
import com.Decathlon.config.Properties;
import com.Decathlon.context.ScenarioContext;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Page {
    
    @FindBy(css = "div.didomi-popup-view")
    private WebElement popInCookieWrap;
    
    @FindBy(id = "didomi-notice-agree-button")
    private WebElement popInCookieButton;
    
    @FindBy(className = "decathlon-logo")
    protected WebElement decathlonLogo;
    
    String jsClickCode = "arguments[0].scrollIntoView(true); arguments[0].click();";
    String jsScrollCode = "arguments[0].scrollIntoView(true);";
    
    /***
     *
     */
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    protected Logger Log;
    
    /***
     * waiter
     */
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;
    
    protected Configuration config = Properties.Config;
    protected String env = Properties.Config.getEnvironment();
    protected ScenarioContext context;
    
    //    Page constructor
    Page() {
        // Init
        driver = Properties.DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
        Log = getLogger(this);
        
        
        //Waiter
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        if (Properties.Config.getHeadless()) {
            driver.manage().window().maximize();
        }
        
    }
    
    // waiters functions
    protected <V> boolean waitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            wait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    protected <V> boolean shortUntil(Function<? super WebDriver, V> isTrue) {
        try {
            shortWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /***
     *
     * @param isTrue
     * @param <V>
     * @return
     */
    protected <V> boolean middleUntil(Function<? super WebDriver, V> isTrue) {
        try {
            middleWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /***
     *
     * @param isTrue
     * @param <V>
     * @return
     */
    protected <V> boolean longUntil(Function<? super WebDriver, V> isTrue) {
        try {
            longWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /***
     * Waiting for a page to loaded
     */
    protected void waitForLoadingPage() {
        if (!longUntil(driver -> js.executeScript("return document.readyState").equals("complete") || js.executeScript("return document.readyState").equals("interactive"))) {
            throw new RuntimeException(driver.getCurrentUrl() + " not loaded");
        }
    }
    
    /***
     *get a page
     * @param url
     */
    protected void get(String url) {
        driver.get(url);
        waitForLoadingPage();
    }
    
    //    Click on an element
    protected void clickOn(WebElement element) {
        
        try {
            if (!shortUntil(visibilityOf(element))) {
                // Logger
                throw new RuntimeException("Element not visible after click");
            }
            
            if (!shortUntil(elementToBeClickable(element))) {
                // Logger
                throw new RuntimeException("Element not clickable");
            }
            scrollTo(element);
            element.click();
        } catch (Exception e) {
            try {
                ((JavascriptExecutor) driver).executeScript(jsClickCode, element);
            } catch (Exception ex) {
//                action.click().perform();
            }
            
        }
    }
    
    //    vertical scrolling on the page
    protected void scroll(int height) {
        js.executeScript("window.scrollBy(0," + height + ")", "");
    }
    
    protected void scrollTo(WebElement element) {
        js.executeScript(jsScrollCode, element);
    }
    
    // check if 2 elements are overlapping
    protected boolean areElementsOverlapping(WebElement element1, WebElement element2) {
        Rectangle r1 = element1.getRect();
        Point topRight1 = r1.getPoint().moveBy(r1.getWidth(), 0);
        Point bottomLeft1 = r1.getPoint().moveBy(0, r1.getHeight());
        
        Rectangle r2 = element2.getRect();
        Point topRight2 = r2.getPoint().moveBy(r2.getWidth(), 0);
        Point bottomLeft2 = r2.getPoint().moveBy(0, r2.getHeight());
        
        if (topRight1.getY() > bottomLeft2.getY()
                    || bottomLeft1.getY() < topRight2.getY()) {
            return false;
        }
        if (topRight1.getX() < bottomLeft2.getX()
                    || bottomLeft1.getX() > topRight2.getX()) {
            return false;
        }
        return true;
    }
    
    //    Get size of an element
    protected Rectangle getElementSize(WebElement element) {
        return element.getRect();
    }
    
    //    check if file is present in a directory
    protected boolean filePresent() {
        String path = "/Users/dylanIsrael/Downloads/";
        File folder = new File(path);
        //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        try {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    // System.out.println("File " + listOfFile.getName());
                    if (fileName.matches("oembed")) {
                        f = new File(path + fileName);
                        found = true;
                        System.out.println("fichier trouve  " + found);
                        System.out.println(f);
                        f.delete();
                        
                    }
                }
            }
        } catch (Exception e) {
            Assert.assertTrue(found, "Downloaded document is not found");
        }
        f.deleteOnExit();
        return found;
    }
    
    //    get http request response code
    protected int getUrlResponseCode(String url) throws IOException {
        HttpURLConnection c = (HttpURLConnection) new URL(url).openConnection();
        c.setRequestMethod("HEAD");
        c.connect();
        int r = c.getResponseCode();
        System.out.println("Http response code: " + r);
        return r;
    }
    
    //    get a page url
    protected String getPageUrl() {
        return driver.getCurrentUrl();
    }
    
    protected List<LogEntry> showBrowserLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();
        for (LogEntry logEntry : logs) {
            System.out.println("⚠️log du navigateur" + logEntry);
        }
        return logs;
    }
    
    
    public void cookieManager() {
        if (waitUntil(visibilityOf(popInCookieWrap))) clickOn(popInCookieButton);
    }
    
    @Attachment(value = "screenshot", type = "image/png")
    public void saveScreenShotPNG() {
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    
    public Boolean checkUrlResponseCode(String url) {
        
        try {
            HttpURLConnection c = (HttpURLConnection) new URL(url).openConnection();
            c.setRequestMethod("HEAD");
            c.connect();
            int r = c.getResponseCode();
            System.out.println("Http response code: " + r);
            return r != 200;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}
