package pages.inventoryPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;

public class SelectByMakeFunction extends BasePage {
    public static final String BODY_MAKE_MENU = "//a[text() = '%s']";
    public final static String MAKE_MORE_LINK = "(//i[@class = 'fa fa-caret-down'])[2]";
    public final static String AUTO_TITLE = "//h2[@class = 'eziVehicleName']";
    public static final Logger logger = LogManager.getLogger(SelectByMakeFunction.class);

    public void openFullMenuMake() {
        logger.info("SelectByMakeFunction. openFullMenuMake. click 'more link'");
        clickElementByXpath(MAKE_MORE_LINK);
    }

    public void userChoosesMake(String type) {
        logger.info("SelectByMakeFunction. userChoosesMake. click 'make'");
        clickElementByXpath(String.format(BODY_MAKE_MENU, type));
    }

    public String getInfoFromFirstAutoTitle() {

        String textFromAutoTitle = getTextFromTitle(AUTO_TITLE);
        String[] subString;
        subString = textFromAutoTitle.split(" ");
        logger.info("SelectByMakeFunction. getInfoFromFirstAutoTitle. text = " + subString[1]);
        return subString[1];
    }

}
