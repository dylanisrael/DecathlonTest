package com.Decathlon.utils;

import com.Decathlon.config.Properties;
import com.Decathlon.driverManager.WebDriverManager;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;

public class allureManager {
    public static WebDriverManager driverManager = WebDriverManager.getInstance();

    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                        put("Test URL", Properties.Config.getEnvironment()).
                        put("Headless mode", String.valueOf(Properties.Config.getHeadless())).
                        put("Local browser", String.valueOf(Properties.Config.getBrowser())).
                        build(),System.getProperty("user.dir")+"/allure-results/");
    }

    @Attachment(value = "Browser information", type = "text/plain")
    public static String addBrowserInformationOnAllureReport() {
        return driverManager.getInfo();
    }
}
