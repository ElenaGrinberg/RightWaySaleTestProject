package pages.inventoryPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    public final static String ENGINE_FROM_TITLE = "(//div[@class = 'inventory-details']/ul/li[7]/span)[1]";
    public final static String BODY_ENGINE_MENU = "//a[text() = '%s']";
    public static final Logger logger = LogManager.getLogger(InventoryPage.class);


    public boolean inventoryTitleIsDisplayed()
    { logger.info("InventoryPage.TitleIsDisplayed");
        return isElementDisplayed(INVENTORY_TITLE);
    }

    public boolean refineSearchLabelIsDisplayed() {
        logger.info("InventoryPage.refineSearchLabelIsDisplayed");
        return isElementDisplayed(REFINE_SEARCH_LABEL);
    }

    public void clickLeftMenuByYears2013() {
        logger.info("InventoryPage.clickLeftMenuByYears2013");
        clickElementByXpath(YEAR2013);
    }

    public String getTextFromAutoTitle() {
        logger.info("InventoryPage.getTextFromAutoTitle");
        String textFromAutoTitle = getTextFromTitle(AUTO_TITLE);
        String[] subString;
        subString = textFromAutoTitle.split(" ");
        logger.info("InventoryPage.getTextFromAutoTitle. substrint[0] = " + subString[0]);
        return subString[0];
    }

    public int countCarsOnPage() {
        logger.info("InventoryPage.countCarsOnPage");
        List<WebElement> cars = driver.findElements(By.xpath(AUTO_TITLE));
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getText());
            FileManager.createNewFile(cars, "carsOnPage");
            logger.info("InventoryPage.countCarsOnPage. car.size() = " + cars.size());
        }
        return cars.size();
    }

    public boolean titleOfBodyTypeIsDisplayed() {
        logger.info("InventoryPage.titleOfBodyTypeIsDisplayed");
        return isElementDisplayed(BODY_TYPE_LABEL);

    }


    public void selectEngineOnLeftMenuBar(String cylinders) {
        logger.info("InventoryPage.selectEngineOnLeftMenuBar");
        clickElementByXpath(String.format(BODY_ENGINE_MENU, cylinders));
    }

    public String getInfoEngineFromAutoTitle() {
        logger.info("InventoryPage.getInfoEngineFromAutoTitle");
        String textFromAutoTitle = getTextFromTitle(ENGINE_FROM_TITLE);
        String[] subString;
        subString = textFromAutoTitle.split(" "
        );
        System.out.println(subString[0] + " " + subString[1] + " " + subString[2]);
        logger.info("InventoryPage.getInfoEngineFromAutoTitle. " + subString[0] + " " + subString[1] + " " + subString[2]);
        return subString[0] + " " + subString[1] + " " + subString[2];
    }
}
