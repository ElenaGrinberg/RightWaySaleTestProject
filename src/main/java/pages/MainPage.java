package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPage extends BasePage{
    public final static String HOME_PATH = "(//a[text() = 'Home'])[1]";
    public final static String ABOUT_US_MENU_PATH = "(//a[text() = 'About Us'])[1]";
    public final static String CONTACT_US_MENU_PATH = "(//a[text() = 'Contact Us'])[1]";
    public final static String INVENTORY_MENU_PATH = "(//a[text() = 'Inventory'])[1]";
    public final static String CAR_CAROUSEL = "//div[@class = 'img-list-respnsivex']";
    public final static String GOOGLE_REVIEW_CAROUSEL = "//p[@class = 'review-content']";
    public final static String NAV_BRAND = "//a[@class= 'navbar-brand' ]";
    public final static String WELCOME = "//h1[text() = ' Welcome to Right Way Auto Sales in Hamilton, ON  ']";
    public final static String VIHICLES = "//h2[text() = 'Vehicles we offer']";
    public final static String FEATURED_VIHICLES = "//h2[contains(text(),'Featured Vehicles')]";
    public final static String GOOGLE_REVIEWS ="//h3[text() = ' Google Reviews ']";
    public final static String GOOGLE_MAPS ="//div[@class = 'google_map_home hidden-xs']";
    public final static String MORE_INFO ="//a[contains(text(),' MORE INFO')]" ;

    public static final Logger logger = LogManager.getLogger(MainPage.class);




    public void navigateToMainPage(String url) {
        logger.info("navigateToMainPage. go to page " + url);
        goToPage(url);
    }

    public boolean elementsAreDisplayed(String xpath){
        logger.info("elementsAreDisplayed. method get xpath " + xpath);
       return isElementDisplayed(xpath);
    }
    public boolean vehiclesCarouselIsDisplayed(){
        logger.info("vehiclesCarouselIsDisplayed");
        return isElementDisplayed(CAR_CAROUSEL);
    }

    public boolean googleReviewCarouselIsDisplayed(){
        logger.info("googleReviewCarouselIsDisplayed");
             return isElementDisplayed(GOOGLE_REVIEW_CAROUSEL);
    }

    public void clickOnHomeLink(){
        logger.info("clickOnHomeLink");
        clickElementByXpath(HOME_PATH);
    }
    public String getUrlCurrentPage(){
        logger.info("getUrlCurrentPage/ return = " + getCurrentUrlPage());
        return getCurrentUrlPage();
    }

    public void clickAboutUSLink(){
        logger.info("clickAboutUSLink ");
        clickElementByXpath(ABOUT_US_MENU_PATH);
    }
    public void clickContactUsLink(){
        logger.info("clickContactUsLink");
        clickElementByXpath(CONTACT_US_MENU_PATH);
    }
    public void clickInventorySLink(){
        logger.info("clickInventorySLink");
        clickElementByXpath(INVENTORY_MENU_PATH);
    }

    public boolean permanentElementsDisplayed(){
        logger.info("paramTest return false if [element] isn't displayed");
        String [] elements = {NAV_BRAND,WELCOME, VIHICLES, FEATURED_VIHICLES, GOOGLE_REVIEWS, GOOGLE_MAPS,MORE_INFO};
        for(int i=0; i<elements.length; i++){
            if(!isElementDisplayed(elements[i])){
                logger.info("element is visible =  " +elements[i] );
                return false;
            }
        }
        return true;
    }


}
