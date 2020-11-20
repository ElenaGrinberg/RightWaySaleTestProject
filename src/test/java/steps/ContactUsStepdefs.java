package steps;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.ContactUsPage;

public class ContactUsStepdefs {
    public static final Logger logger = LogManager.getLogger(ContactUsStepdefs.class);

    ContactUsPage contactUsPage;

    public ContactUsStepdefs(){
        contactUsPage = new ContactUsPage();
    }
    @And("Verify Contact US Page is loaded")
    public void verifyContactUSPageIsLoaded() {
        logger.info("ContactUsStepdefs().test get boolean " + contactUsPage.contactUsTitleDisplayed());
       Assertions.assertTrue(contactUsPage.contactUsTitleDisplayed());
    }
}
