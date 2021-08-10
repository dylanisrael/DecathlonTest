package com.Decathlon.steps;

import com.Decathlon.pageObjects.LandingPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class LandingPageSteps implements En {

    public LandingPageSteps(LandingPage landingPage){

        Given("user goes to carte cadeau page",landingPage::gotoPage);

        When("Click on Discover under The Personalized Gift Card", landingPage::clicksOnDiscover);

        Then("The page is available",()->{
            landingPage.saveScreenShotPNG();
            Assert.assertTrue(landingPage.imOnPersolizedGiftCardPage(),"le clic sur découvrir les cartes cadeaux presonalisées renvoi vers une page d'erreur");
        });

        Given("Click on Discover e-carte cadeau",landingPage::clicksOnDiscoverECarte);

        When("Click on our privacy policy", landingPage::clicksOnOurPrivacy);

        Then("text description is visible", ()-> {
            landingPage.saveScreenShotPNG();
            Assert.assertTrue(landingPage.textDescriptionIsVisible(),"les textes décrivant les icones ne sont pas affichés");
            }
        );

        When("user is on coolers and food boxes and clicks on {string}",(String arg0) ->{
            landingPage.goto5h11hPage();
        });

        Then("A structured page with well positioned elements is displayed",()->{
            landingPage.saveScreenShotPNG();
            Assert.assertTrue(landingPage.aStructuredPageWellPositionedElementsIsDisplayed(),"la page n'est pas structurée et les élements sont disproportionnés ");
        });

    }

}
