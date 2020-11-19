package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SortedPages;

public class SortOpsStepdefs {
    private SortedPages sortedPages;

    public SortOpsStepdefs(){
        sortedPages = new SortedPages();
    }

    @When("Click option select by year")
    public void clickOptionSelectByYear() {
        String actualUrl = sortedPages.clickBySelectYear();
        Assert.assertNotSame("https://www.rightwayautosale.com/inventory", actualUrl);


        }


    @Then("Verify that list of car in fact is sorted")
    public void ListOfCarIsSorted() {
        Assert.assertTrue(sortedPages.listYearsCarsOnPage());

    }

    @When("Click option select by Make")
    public void clickOptionSelectByMake() {
        sortedPages.clickSortByMake();
    }

    @Then("Verify that list of car in fact is sorted by Make")
    public void verifyThatListOfCarInFactIsSortedByMake() {
        Assert.assertTrue(sortedPages.sortListByMakeOnPage());
    }

    @When("Click option select by Price")
    public void clickOptionSelectByPrice() {
        sortedPages.clickSortByPrice();
        sortedPages.clickSortByPrice();
    }

    @Then("Verify that list of car in fact is sorted by Price")
    public void verifyThatListOfCarInFactIsSortedByPrice() {
        Assert.assertTrue(sortedPages.sortListByPrice());
    }

    @When("Click option select by Mileage")
    public void clickOptionSelectByMileage() {
        sortedPages.clickSortByMileage();
    }

    @Then("Verify that list of car in fact is sorted by Mileage")
    public void verifyThatListOfCarInFactIsSortedByMileage() {
        Assert.assertTrue(sortedPages.sortListByPMileage());
    }
}
