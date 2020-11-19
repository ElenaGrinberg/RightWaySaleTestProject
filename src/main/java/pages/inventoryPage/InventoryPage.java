package pages.inventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.FileManager;
import java.util.List;

public class InventoryPage extends BasePage {
    public final static String INVENTORY_TITLE = "//h1[text() = ' View Inventory ']";
    public final static String YEAR2013 = "//a[text()='2013']";
    public final static String REFINE_SEARCH_LABEL = "//div[text() = 'Refine Your Search:']";
    public final static String AUTO_TITLE = "//h2[@class = 'eziVehicleName']";
    public final static String BODY_TYPE_LABEL = "//h2[text() = 'Body Type']";
    public final static String MAKE_TYPE_LABEL = "//h2[text() = 'Make']";
    public final static String MAKE_MORE_LINK = "(//i[@class = 'fa fa-caret-down'])[2]";
    public final static String ENGINE_FROM_TITLE = "(//div[@class = 'inventory-details']/ul/li[7]/span)[1]";
    public final static String BODY_ENGINE_MENU = "//a[text() = '%s']";






    public boolean inventoryTitleIsDisplayed() {
        return isElementDisplayed(INVENTORY_TITLE);
    }

    public boolean refineSearchLabelIsDisplayed() {
        return isElementDisplayed(REFINE_SEARCH_LABEL);
    }

    public void clickLeftMenuByYears2013() {
        clickElementByXpath(YEAR2013);
    }

    public String getTextFromAutoTitle() {
        String textFromAutoTitle = getTextFromTitle(AUTO_TITLE);
        String[] subString;
        subString = textFromAutoTitle.split(" ");
        return subString[0];
    }

    public int countCarsOnPage(){
        List <WebElement> cars = driver.findElements(By.xpath(AUTO_TITLE));
       for(int i = 0; i<cars.size(); i++){
           System.out.println(cars.get(i).getText());
           FileManager.createNewFile(cars, "carsOnPage");
       } return cars.size();
    }

    public boolean titleOfBodyTypeIsDisplayed() {
        return isElementDisplayed(BODY_TYPE_LABEL);
    }


    public void selectEngineOnLeftMenuBar(String cylinders) {
        clickElementByXpath(String.format(BODY_ENGINE_MENU, cylinders));
    }

    public String getInfoEngineFromAutoTitle() {
        String textFromAutoTitle = getTextFromTitle(ENGINE_FROM_TITLE);
        String[] subString;
        subString = textFromAutoTitle.split(" "
        );
        System.out.println(subString[0] + " " + subString[1] + " " + subString[2]);
        return subString[0] + " " + subString[1] + " " + subString[2];
    }
}
