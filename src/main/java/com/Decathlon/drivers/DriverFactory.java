package com.Decathlon.drivers;

import com.Decathlon.config.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory extends AbsWebDriverImpl{

    private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final static String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";

    private final WebDriver driver;

    public DriverFactory(String browser){
        this.driver = this.createWebDriver(browser);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeDriver(){
        driver.close();
    }

    private WebDriver createWebDriver(String browser){
        String prop,path;

        switch (browser) {
            case "firefox":
                prop = GECKO_DRIVER_PROPERTY;
                break;
            default:
                prop = CHROME_DRIVER_PROPERTY;
        }
        path = Properties.Config.getWebDriverPath();
        System.setProperty(prop, path);

        return browser.equals("firefox")?
                new FirefoxDriver(getFirefoxOptions()):
                new ChromeDriver(getChromeOptions());
    }
}
