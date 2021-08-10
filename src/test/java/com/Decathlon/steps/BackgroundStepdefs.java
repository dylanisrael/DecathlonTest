package com.Decathlon.steps;

import com.Decathlon.pageObjects.HomePage;
import io.cucumber.java8.En;

public class BackgroundStepdefs implements En {

    public BackgroundStepdefs(HomePage homePage){
        Given("user is login",homePage::login);
    }

}
