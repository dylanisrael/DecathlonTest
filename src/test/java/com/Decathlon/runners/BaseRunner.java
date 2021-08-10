package com.Decathlon.runners;

import com.Decathlon.config.Properties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseRunner extends AbstractTestNGCucumberTests {


    @Parameters({"browser", "device"})
    @BeforeClass
    public static void beforeTest(@Optional String browser, @Optional String device){
        String browserA;

        browserA = java.util.Optional
                .ofNullable(browser)
                .orElse(Properties.Config.getBrowser());

        Properties.DriverManager.setDriver(browserA);
    }

    @AfterClass
    public static void tearDown(){
        Properties.DriverManager.getDriver().quit();
    }

}
