package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactUsPage extends BasePage{
    public final static String CONTACT_US_TITLE = "//h1[text() = ' HOW CAN WE HELP YOU?']";
    public static final Logger logger = LogManager.getLogger(ContactUsPage.class);

    public boolean contactUsTitleDisplayed(){
        logger.info("contactUsTitleDisplayed.TitleDisplayed");
        return isElementDisplayed(CONTACT_US_TITLE);
    }

}
