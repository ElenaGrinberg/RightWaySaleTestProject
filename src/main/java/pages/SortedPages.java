package pages;
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


    public String clickBySelectYear() {
        clickElementByXpath(SORT_BY_YEAR);
        return getCurrentUrlPage();
    }


    public boolean listYearsCarsOnPage() {
        List<WebElement> cars = driver.findElements(By.xpath(CAR_NAME_TREE));
        ArrayList<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            header = header.substring(0, 3);
            yearsList.add(Integer.parseInt(header));
        }

        FileManager.createNewFile(cars, "listOfCar");

        for (int i = 0; i < yearsList.size() - 1; i++) {
            if (yearsList.get(i) < yearsList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickSortByMake() {
        clickElementByXpath(MAKE);
    }

    public boolean sortListByMakeOnPage() {
        List<WebElement> cars = driver.findElements(By.xpath(CAR_NAME_TREE));
        ArrayList<Character> makeList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            makeList.add(header.charAt(5));
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
        clickElementByXpath(SORT_BY_PRICE);


    }

    public boolean sortListByPrice() {
        List<WebElement> cars = driver.findElements(By.xpath(CAR_PRICE_TREE));
        ArrayList<Double> makeList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            String withPoint = header.substring(1, 6);
            String withDot = withPoint.replace(',', '.');

            makeList.add(Double.parseDouble(withDot));
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
        clickElementByXpath(SORT_BY_MILEAGE);


    }

    public boolean sortListByPMileage() {
        List<WebElement> cars = driver.findElements(By.xpath(MILEAGE_FROM_TITLE));
        ArrayList<Double> makeList = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            String header = cars.get(i).getText();
            String withPoint = header.substring(0, 6);
            String withDot = withPoint.replace(',', '.');

            makeList.add(Double.parseDouble(withDot));
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








