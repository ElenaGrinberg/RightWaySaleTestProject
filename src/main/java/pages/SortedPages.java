package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class SortedPages extends BasePage {
    public final String SORT_BY_YEAR = "//a[text() = 'Year']";
    public final String MAKE = "//a[text() = 'Make']";
    public final String SORT_BY_PRICE = "//a[text() = 'Price']";
    public final String SORT_BY_MILEAGE = "//a[text() = 'Mileage']";
    public final static String MILEAGE_FROM_TITLE = "//div[@class = 'inventory-details']/ul/li[8]/span";
    public final static String CAR_NAME_TREE = "//h2[@class = 'eziVehicleName']";
    public final static String CAR_PRICE_TREE = "//span[@class = 'eziVehiclePrice']";
    public static final Logger logger = LogManager.getLogger(SortedPages.class);


    public String clickBySelectYear() {
        logger.info("clickBySelectYear");
        clickElementByXpath(SORT_BY_YEAR);
        return getCurrentUrlPage();
    }


    public boolean listYearsCarsOnPage() {
        logger.info("listYearsCarsOnPage. get List WebElements and extract from it years" +
                "and verify that year of first cer is less than second car ");
        List<WebElement> cars = driver.findElements(By.xpath(CAR_NAME_TREE));
        ArrayList<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            header = header.substring(0, 4);
           yearsList.add(Integer.parseInt(header));
        }

        FileManager.createNewFile(cars, "listOfCar");

        for (int i = 0; i < yearsList.size() - 1; i++) {
            logger.info("car year = " +yearsList.get(i));
            if (yearsList.get(i) < yearsList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickSortByMake() {
        logger.info("clickSortByMake");
        clickElementByXpath(MAKE);
    }

    public boolean sortListByMakeOnPage() {
        logger.info("sortListByMakeOnPage. sortListByMakeOnPage. get List WebElements and extract from it make" +
                "verify that first letter of first cer is less than second car");
        List<WebElement> cars = driver.findElements(By.xpath(CAR_NAME_TREE));
        ArrayList<Character> makeList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            makeList.add(header.charAt(5));
            logger.info("first letter is "+ header.charAt(5));
            System.out.println(header.charAt(5));
        }

        for (int i = 0; i < makeList.size() - 1; i++) {
            if (makeList.get(i) > makeList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickSortByPrice() {
        logger.info("clickSortByPrice()");
        clickElementByXpath(SORT_BY_PRICE);


    }

    public boolean sortListByPrice() {
        logger.info("sortListByPrice(). get List WebElements and extract from it price and" +
                "verify that price first cer is less than second car");
        List<WebElement> cars = driver.findElements(By.xpath(CAR_PRICE_TREE));
        ArrayList<Double> makeList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            String withPoint = header.substring(1, 6);
            String withDot = withPoint.replace(',', '.');

            makeList.add(Double.parseDouble(withDot));
            logger.info("price is " + Double.parseDouble(withDot));
            System.out.println(Double.parseDouble(withDot));
        }

        for (int i = 0; i < makeList.size() - 1; i++) {
            if (makeList.get(i) < makeList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickSortByMileage() {
        logger.info("SortedPages(). ");
        clickElementByXpath(SORT_BY_MILEAGE);


    }

    public boolean sortListByPMileage() {
        logger.info("sortListByPMileage(). sortListByPMileage. get List WebElements and extract from it mileage" +
                "verify that mileage first cer is less than second car");
        List<WebElement> cars = driver.findElements(By.xpath(MILEAGE_FROM_TITLE));
        ArrayList<Double> makeList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            String withPoint = header.substring(0, 6);
            String withDot = withPoint.replace(',', '.');

            makeList.add(Double.parseDouble(withDot));
            logger.info("mileage is " + Double.parseDouble(withDot));
            System.out.println(Double.parseDouble(withDot));
        }

        for (int i = 0; i < makeList.size() - 1; i++) {
            if (makeList.get(i) < makeList.get(i + 1)) {
                return false;
            }
        }
        return true;

    }
}








