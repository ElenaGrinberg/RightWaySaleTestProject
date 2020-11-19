package pages;

public class ContactUsPage extends BasePage{
    public final static String CONTACT_US_TITLE = "//h1[text() = ' HOW CAN WE HELP YOU?']";

    public boolean contactUsTitleDisplayed(){
        return isElementDisplayed(CONTACT_US_TITLE);
    }

}
