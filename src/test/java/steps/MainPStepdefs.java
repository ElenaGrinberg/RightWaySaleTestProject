package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pages.MainPage;
import pages.SortedPages;

public class MainPStepdefs {

    private MainPage mainPage;

    public MainPStepdefs() {
        mainPage = new MainPage();
    }


    @Given("User navigates to {string} page")
    public void userNavigateToPage(String url) {
        mainPage.navigateToMainPage(url);


    }


    @Then("Verify that {string} displayed")
    public void elementsIsDisplayed(String xpath) {
        Assertions.assertTrue(mainPage.elementsAreDisplayed(xpath));
    }

    @Then("Verify vehicles carousel is Displayed")
    public void verifyVehiclesCarouselIsDisplayed() {
        Assertions.assertTrue(mainPage.vehiclesCarouselIsDisplayed());

    }

    @And("Verify google review contents carousel iIs displayed")
    public void verifyGoogleReviewContentsCarouselIIsDisplayed() {
        Assertions.assertTrue(mainPage.googleReviewCarouselIsDisplayed());
    }


    @Then("Click to Home menu")
    public void clickToHomeMenu() {
        mainPage.clickOnHomeLink();
    }

    @And("Verify the Main Page is loaded")
    public void verifyTheMainPageIsLoaded() {
        String currentURL = mainPage.getUrlCurrentPage();
        String expectedURL = "https://www.rightwayautosale.com/";
        Assertions.assertEquals(expectedURL, currentURL);
    }

    @Then("Click to About US menu")
    public void clickToAboutUSMenu() {
        mainPage.clickAboutUSLink();
    }



    @Then("Click to Contact US menu")
    public void clickToContactUSMenu() {
        mainPage.clickContactUsLink();


    }

    @Then("Click to Inventory Link on top menu Main Page")
    public void clickToInventoryLinkOnTopMenuMainPage() {
        mainPage.clickInventorySLink();
    }

    @When("Verify that permanent elements are displayed")
    public void verifyThatPermanentElementsAreDisplayed() {
        Assert.assertTrue(mainPage.permanentElementsDisplayed());
    }
}
