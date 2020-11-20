package pages.inventoryPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;

public class SelectYearFunction extends BasePage {
    public final static String MORE_YEAR_ARROW = "(//a[@class = 'eziSeeMoreLess'])[1]";
    public final static String AUTO_TITLE = "//h2[@class = 'eziVehicleName']";
    public final static String BODY_YEARS_MENU = "//a[text()='%s']";
    public static final Logger logger = LogManager.getLogger(SelectYearFunction.class);

    public void openMenuYearsByClickArrow() {
        logger.info("SelectYearFunction.openMenuYearsByClickArrow. click 'more' link");
        clickElementByXpath(MORE_YEAR_ARROW);
    }

    public void userChoosesOnYearOnLeftPanel(String years) {
        logger.info("SelectYearFunction.openMenuYearsByClickArrow. click year link");
        clickElementByXpath(String.format(BODY_YEARS_MENU, years));
    }


           public String careIsSameYear(){
           String textFromTitle = getTextFromTitle(AUTO_TITLE);
            String subString = textFromTitle.substring(0, 4);
            System.out.println(subString);
               logger.info("SelectYearFunction. careIsSameYear. get substring with year = " +subString);
               return subString;



        }
    }

