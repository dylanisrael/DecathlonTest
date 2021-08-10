package com.Decathlon.steps;

import com.Decathlon.pageObjects.CampingBivouacPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class CampingBivouacPageSteps implements En {

    public CampingBivouacPageSteps (CampingBivouacPage campingBivouacPage){

        Given("user is on camping bivouac, boire et manger",campingBivouacPage::goToBoireEtManger);

        When("user clicks on isothermals quechua boxes and bottles",campingBivouacPage::clickOnBoiteEtBouteille);

        Then("A boxes and bottles related page is displayed",()->{
            campingBivouacPage.saveScreenShotPNG();
            Assert.assertTrue(campingBivouacPage.boxAndBottlesRelatedPageIsDisabled(),"le clic sur les boites et bouteilles isothermales QUECHA renvoi vers une page d'erreur");
        });
    }
}
