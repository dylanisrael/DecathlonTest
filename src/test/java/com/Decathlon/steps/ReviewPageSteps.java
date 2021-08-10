package com.Decathlon.steps;

import com.Decathlon.pageObjects.ReviewPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class ReviewPageSteps implements En {
    public ReviewPageSteps(ReviewPage reviewPage){

        Given("user go to decathlon avis",reviewPage::gotoAvisPage);

        When("Click on Mp{int} Etanche", (Integer arg0) -> {
            reviewPage.clickOnMp3();
        });

        Then("the products presented are MP{int}", (Integer arg0) -> {
            reviewPage.saveScreenShotPNG();
            Assert.assertTrue(reviewPage.theProductsAreMP3(),"Le clic sur mp3 étanche nous ouvre un autre produit à la place");
        });
    }
}
