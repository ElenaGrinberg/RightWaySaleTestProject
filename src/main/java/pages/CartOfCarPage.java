package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartOfCarPage extends BasePage {
    public static final String AUTO_PATH = "(//h2[@class ='eziVehicleName'])[1]";
    public static final String HEADING_OF_DESCRIPTION = "//div[@class = 'col-md-6 col-sm-6 col-xs-12 inventory-name-inner']";
    public static final String CART_OF_BODY = "//h2[text() = '%s']";
    public static final String INVENTORY_PAGE = "https://www.rightwayautosale.com/inventory";
    public static final String IMAGE1 = "(//li[@class = 'flex-active-slide'])[1]";
    public static final String IMAGE2 = "(//li[@class = 'flex-active-slide'])[2]";
    public static final String VIN = "//span[contains(text(), 'VIN #:')]";
    public static final String STOCK = "//span[contains(text(), 'Stock #:')]";
    public static final String TRIM = "//span[contains(text(), 'Trim #:')]";
    public static final String CONDITION = "//span[contains(text(), 'Condition #:')]";
    public static final String CERTIFICATION = "//span[contains(text(), 'Certification #:')]";
    public static final Logger logger = LogManager.getLogger(CartOfCarPage.class);


    public String goToPageAndClickOnCar() {
        goToPage(INVENTORY_PAGE);
        clickElementByXpath(AUTO_PATH);
        logger.info("goToPageAndClickOnCar. go to page, click on car, return current page =" +getCurrentUrlPage());
        return getCurrentUrlPage();
    }

    public boolean cartsElementsAreDisplayed(String param) {
        logger.info(" cartsElementsAreDisplayed" +String.format(CART_OF_BODY, param) );
        return isElementDisplayed(String.format(CART_OF_BODY, param));
    }

    public boolean verbalDescription() {
        logger.info("verbalDescription. Verify by loop header description, images carousel, text description vin, trim, condition, certification, carts");
        String[] words = {HEADING_OF_DESCRIPTION, IMAGE1, IMAGE2, VIN, STOCK, TRIM, CONDITION, CERTIFICATION};
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            logger.info(words[i]);
            if (!isElementDisplayed(words[i])) {
                return false;
            }
        }
        return true;
    }
}
