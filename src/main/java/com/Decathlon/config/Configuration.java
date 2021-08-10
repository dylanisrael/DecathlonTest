package com.Decathlon.config;

import com.Decathlon.Enum.Device;
import com.Decathlon.Enum.Urls;


public class Configuration {

    private static Configuration INSTANCE = new Configuration();

    private PropertiesConfig prop = PropertiesConfig.getInstance();

    private String webDriverPath;
    private Boolean headless;
    private String environment;
    private String browser;

    private Device device;
    private Urls env;

    public Configuration(){
        headless        = Boolean.valueOf(System.getProperty("headless", (String)prop.get("headless", "false")));
        environment     = System.getProperty("env", (String) prop.get("environment"));
        browser         = System.getProperty("browser", (String)prop.get("browser", "chrome"));
        webDriverPath   = (String)prop.get(browser.toLowerCase(), "chrome");

        device          = Device.valueOf(((String)prop.get("device", "desktop")).toUpperCase());
        env             = Urls.valueOf((String)environment.toUpperCase());

    }

    public Boolean getHeadless() {
        return headless;
    }

    public String getEnvironment() { return env.getUrl(); }

    public String getBrowser() {
        return browser;
    }

    public String getWebDriverPath() { return webDriverPath; }

    public Device getDevice(){ return device;}

    public static Configuration getInstance(){
        return INSTANCE;
    }
}
