package com.Decathlon.steps;

import com.Decathlon.pageObjects.DeliveryModePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class DeliveryModePageSteps implements En {

    public DeliveryModePageSteps(DeliveryModePage deliveryModePage){

        Given("user is on mode de livraison page",deliveryModePage::goToPage);

        When("user Clicks on the different links in the table",deliveryModePage::clickOnTableElement);

        Then("user is on a new page",()->{
            deliveryModePage.saveScreenShotPNG();
            Assert.assertTrue(deliveryModePage.userIsOnAnewPage(),"les liens dans le tableau ne réagissent pas aux clics");
        });


    }
}
