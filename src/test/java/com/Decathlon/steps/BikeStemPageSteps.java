package com.Decathlon.steps;

import com.Decathlon.pageObjects.BikeStemPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class BikeStemPageSteps implements En {

    public BikeStemPageSteps(BikeStemPage bicycleStemPage){

        Given("user is on bike stem page",bicycleStemPage::goToPotencesVelo);

        When("user clicks on see more link",bicycleStemPage::clickOnLirePlus);

        And("user clicks on ireland link",bicycleStemPage::clickOnIreland);

        Then("An ireland related page is displayed",()->{
            bicycleStemPage.saveScreenShotPNG();
            Assert.assertTrue(bicycleStemPage.anIrelandRelatedPageIsDisplayed(),"le click sur le lien ireland renvoi vers une page d'erreur");
        });
    }
}
