package pages.inventoryPage;

import pages.BasePage;

public class SelectYearFunction extends BasePage {
    public final static String MORE_YEAR_ARROW = "(//a[@class = 'eziSeeMoreLess'])[1]";
    public final static String AUTO_TITLE = "//h2[@class = 'eziVehicleName']";
    public final static String BODY_YEARS_MENU = "//a[text()='%s']";

    public void openMenuYearsByClickArrow() {
        clickElementByXpath(MORE_YEAR_ARROW);
    }

    public void userChoosesOnYearOnLeftPanel(String years) {
        clickElementByXpath(String.format(BODY_YEARS_MENU, years));
    }


           public String careIsSameYear(){
           String textFromTitle = getTextFromTitle(AUTO_TITLE);
            String subString = textFromTitle.substring(0, 4);
            System.out.println(subString);
               return subString;



        }
    }

