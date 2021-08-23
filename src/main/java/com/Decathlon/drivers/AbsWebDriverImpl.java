package com.Decathlon.drivers;

import com.Decathlon.config.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public abstract class AbsWebDriverImpl {

    protected ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setHeadless(Properties.Config.getHeadless());

            if (Properties.Config.getHeadless()){
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("window-size=1200,1100");

            }
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--enable-automation");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-browser-side-navigation");

        return chromeOptions;
    }

    protected FirefoxOptions getFirefoxOptions(){
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(true);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setHeadless(Properties.Config.getHeadless());
        firefoxOptions.setProfile(firefoxProfile);
        firefoxOptions.setCapability("acceptSslCerts", true);

        return firefoxOptions;
    }
}
