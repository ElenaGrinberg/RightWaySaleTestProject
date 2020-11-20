package pages.inventoryPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;

public class SelectByBodyFunction extends BasePage {
    public final static String MORE_INFO_BTN = "//*[@id='products']/div[2]/div[3]/a";
    public final static String BODY_TYPE_MENU = "//a[text() = '%s']";
    public final static String BODY_TYPE_LABEL = "//h2[text() = 'Body Type']";
    public static final Logger logger = LogManager.getLogger(SelectByBodyFunction.class);


    public void userChoosesTypeOfCar(String type) {

        clickElementByXpath(String.format(BODY_TYPE_MENU, type));
        clickElementByXpath(MORE_INFO_BTN);
        System.out.println(BODY_TYPE_LABEL);
        logger.info("SelectByBodyFunction. userChoosesTypeOfCar. " + BODY_TYPE_LABEL);
    }

    public String getTypeBodyFromText() {
        String string = getTextFromTitle(BODY_TYPE_LABEL);
        String[] subString;
        subString = string.split("\n");
        System.out.println(subString[1]);
        logger.info("SelectByBodyFunction. getTypeBodyFromText. text = " + subString[1]);
        return subString[1];


    }
}
