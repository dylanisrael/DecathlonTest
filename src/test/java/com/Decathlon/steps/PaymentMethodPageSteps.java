package com.Decathlon.steps;

import com.Decathlon.pageObjects.PaymentMethodPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class PaymentMethodPageSteps implements En {

    public PaymentMethodPageSteps(PaymentMethodPage paymentMethodPage){

        Given("user is on moyen de paiement page",paymentMethodPage::goToPage);

        Then("user clicks on carte illicado",paymentMethodPage::clicksOnCarteIllicado);

        And("user clicks on en savoir +",paymentMethodPage::clickOnEnsavoirPlus);

        Then("more informations about the illicado card are displayed",()->{
            paymentMethodPage.saveScreenShotPNG();
            Assert.assertTrue(paymentMethodPage.informationsAboutIllicadoCardAreDisplayed(),"le clic sur plus d'informations nous renvoi vers une page d'erreur");

        });
    }
}
