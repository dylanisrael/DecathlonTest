package com.Decathlon.steps;

import com.Decathlon.pageObjects.MaterialClubPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class MaterialClubPageSteps implements En {

    public MaterialClubPageSteps(MaterialClubPage materialClubPage){

        Given("user clicks on the cleanser",materialClubPage::clickOnLeNetoyant);

        Then("A page with cleanser is displayed",()->{
            materialClubPage.saveScreenShotPNG();
            Assert.assertTrue(materialClubPage.aPageWithCleanserIsDisplayed(),"le clic sur le nettoyant renvoi vers une page d'erreur");
        });

    }
}
