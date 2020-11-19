package steps;

import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.ContactUsPage;

public class ContactUsStepdefs {

    ContactUsPage contactUsPage;

    public ContactUsStepdefs(){
        contactUsPage = new ContactUsPage();
    }
    @And("Verify Contact US Page is loaded")
    public void verifyContactUSPageIsLoaded() {
       Assertions.assertTrue(contactUsPage.contactUsTitleDisplayed());
    }
}
