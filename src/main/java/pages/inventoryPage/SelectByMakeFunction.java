package pages.inventoryPage;

import pages.BasePage;

public class SelectByMakeFunction extends BasePage {
    public static final String BODY_MAKE_MENU = "//a[text() = '%s']";
    public final static String MAKE_MORE_LINK = "(//i[@class = 'fa fa-caret-down'])[2]";
    public final static String AUTO_TITLE = "//h2[@class = 'eziVehicleName']";

    public void openFullMenuMake() {
        clickElementByXpath(MAKE_MORE_LINK);
    }

    public void userChoosesMake(String type) {
        clickElementByXpath(String.format(BODY_MAKE_MENU, type));
    }

    public String getInfoFromFirstAutoTitle() {
        String textFromAutoTitle = getTextFromTitle(AUTO_TITLE);
        String[] subString;
        subString = textFromAutoTitle.split(" ");
        return subString[1];
    }

}
