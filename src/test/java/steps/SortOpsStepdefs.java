package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.SortedPages;

public class SortOpsStepdefs {
    public static final Logger logger = LogManager.getLogger(SortOpsStepdefs.class);
    private SortedPages sortedPages;

    public SortOpsStepdefs(){
        sortedPages = new SortedPages();
    }

    @When("Click option select by year")
    public void clickOptionSelectByYear() {
        String actualUrl = sortedPages.clickBySelectYear();
        logger.info("Click option select by year. NotSame " + "https://www.rightwayautosale.com/inventory  " + actualUrl);
        Assert.assertNotSame("https://www.rightwayautosale.com/inventory", actualUrl);
        }


    @Then("Verify that list of car in fact is sorted")
    public void ListOfCarIsSorted() {
        logger.info("ListOfCarIsSorted(). test get boolean " + sortedPages.listYearsCarsOnPage());
        Assert.assertTrue(sortedPages.listYearsCarsOnPage());

    }

    @When("Click option select by Make")
    public void clickOptionSelectByMake() {
        logger.info("Click option select by Make");
        sortedPages.clickSortByMake();
    }

    @Then("Verify that list of car in fact is sorted by Make")
    public void verifyThatListOfCarInFactIsSortedByMake() {
        logger.info("verifyThatListOfCarInFactIsSortedByMake(). test get boolean " + sortedPages.sortListByMakeOnPage());
        Assert.assertTrue(sortedPages.sortListByMakeOnPage());
    }

    @When("Click option select by Price")
    public void clickOptionSelectByPrice() {
        logger.info("clickOptionSelectByPrice. double click on price");
        sortedPages.clickSortByPrice();
        sortedPages.clickSortByPrice();
    }

    @Then("Verify that list of car in fact is sorted by Price")
    public void verifyThatListOfCarInFactIsSortedByPrice() {
        logger.info("verifyThatListOfCarInFactIsSortedByPrice(). test get boolean " + sortedPages.sortListByPrice());
        Assert.assertTrue(sortedPages.sortListByPrice());
    }

    @When("Click option select by Mileage")
    public void clickOptionSelectByMileage() {
        logger.info("clickOptionSelectByMileage()");
        sortedPages.clickSortByMileage();
    }

    @Then("Verify that list of car in fact is sorted by Mileage")
    public void verifyThatListOfCarInFactIsSortedByMileage() {
        logger.info("verifyThatListOfCarInFactIsSortedByMileage(). test get boolean = " + sortedPages.sortListByPMileage() );
        Assert.assertTrue(sortedPages.sortListByPMileage());
    }
}
