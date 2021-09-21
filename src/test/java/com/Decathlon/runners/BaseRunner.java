package com.Decathlon.runners;

import com.Decathlon.config.Properties;
import com.Decathlon.utils.AllureFilesManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseRunner extends AbstractTestNGCucumberTests {
    
    private static final Logger Log =  LogManager.getLogger( BaseRunner.class);
    
    
    @Parameters({"browser", "device"})
    @BeforeClass
    public static void beforeTest(@Optional String browser, @Optional String device){
        String browserA;
        browserA = java.util.Optional
                .ofNullable(browser)
                .orElse(Properties.Config.getBrowser());
        Log.info("Tests are starting");
        Properties.DriverManager.setDriver(browserA);
        
    }
    
    @AfterClass
    public static void tearDown() throws IOException {
        AllureFilesManager.createEnvironmentPropertiesFile();
        AllureFilesManager.createCategorieJsonFile();
        AllureFilesManager.createExecutorJsonFile();
        Properties.DriverManager.getDriver().quit();
    }
}
