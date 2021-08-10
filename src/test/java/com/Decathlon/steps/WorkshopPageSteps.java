package com.Decathlon.steps;

import com.Decathlon.pageObjects.WorkshopPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class WorkshopPageSteps implements En {

    public WorkshopPageSteps(WorkshopPage workshopPage){

        Given("user is on Atelier page",workshopPage::gotoPage);

        When("user click on sport d'eau",workshopPage::clickOnWaterSport);

        Then("the presentation page of the quechua isothermal boxes and bottles should be displayed",()->{
            workshopPage.saveScreenShotPNG();
            Assert.assertTrue(workshopPage.imOnQuechaPresentationBoxesPage(),"le clic sur sport d'eau nous renvoi vers une page d'erreur ");
        });
    }
}
