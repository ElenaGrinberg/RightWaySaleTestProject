package steps;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.AboutUsPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AboutUsStepdefs {
    public static final Logger logger = LogManager.getLogger(AboutUsStepdefs.class);

    AboutUsPage aboutUsPage;

    public AboutUsStepdefs() {
        aboutUsPage = new AboutUsPage();
    }

    @And("Verify About US Page is loaded")
    public void verifyAboutUSPageIsLoaded() {
        logger.info("test.verifyAboutUSPageIsLoaded(). test get boolean = " + aboutUsPage.logoIsDisplayed());
        Assertions.assertTrue(aboutUsPage.logoIsDisplayed());

    }
}
