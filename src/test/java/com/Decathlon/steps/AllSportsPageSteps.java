package com.Decathlon.steps;

import com.Decathlon.pageObjects.AllSportsPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class AllSportsPageSteps implements En {

    public AllSportsPageSteps(AllSportsPage allSportsPage){

        Given("user select trout fishing in sport page -> canned fishing",allSportsPage::gotoPecheDeCarnassierPecheTruitePage);

        When("user clicks on fake cane",allSportsPage::clicksOnCanneToc);

        And("user clicks on the bombshell",allSportsPage::clicksOnLabombete);

        Then("A bombshell related page is displayed",()->{
            allSportsPage.saveScreenShotPNG();
            Assert.assertTrue(allSportsPage.aBomshellRelatedPageIsDisplayed(),"le clic sur une bombete renvoi vers une page d'erreur");
        });

        Given("user select material club in table tennis sport", allSportsPage::gotoPageIdeeCadeauTenisTableMaterielClubPage);

        When("user clicks on a ball", allSportsPage::clicksOnUneballe);

        Then("A ball related page is displayed", ()->{
            allSportsPage.saveScreenShotPNG();
            Assert.assertTrue(allSportsPage.aBallRelatedPageIsDisplayed(),"le clic sur une balle renvoi vers une page d'erreur");
        });
    }
}
