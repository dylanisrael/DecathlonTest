package com.Decathlon.steps;

import com.Decathlon.pageObjects.BikeLockPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class BikeLockPageSteps implements En {

    public BikeLockPageSteps(BikeLockPage bikeLockPage){

        Given("user is on bike lock page",bikeLockPage::gotoAntivolVeloPage);

        When("user clicks on decathlon.ch link",bikeLockPage::clickOnDecathlonCh);

        Then("A decathlon.ch related page is displayed",()-> {
            bikeLockPage.saveScreenShotPNG();
            Assert.assertTrue(bikeLockPage.aDecathlon_ch_RelatedPageIsDisplayed(),"le clic sur decathlon.ch renvoi vers une page d'erreur");
        });
    }
}
