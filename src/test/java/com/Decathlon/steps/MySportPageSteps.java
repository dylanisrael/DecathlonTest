package com.Decathlon.steps;

import com.Decathlon.pageObjects.MySportPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class MySportPageSteps implements En {

    public MySportPageSteps(MySportPage mySportPage){

        Given("user go to preferences -> my sports",mySportPage::goToMySportPage);

        Then("all page images are loaded",()->{
            mySportPage.saveScreenShotPNG();
            Assert.assertTrue(mySportPage.allImagesAreAvailableOnPage(),"les images de tous les sports ne sont pas affichées");
        });

    }
}
