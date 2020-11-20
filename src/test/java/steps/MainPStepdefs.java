package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pages.MainPage;


public class MainPStepdefs {
    public static final Logger logger = LogManager.getLogger(MainPStepdefs.class);
    private MainPage mainPage;

    public MainPStepdefs() {
        mainPage = new MainPage();
    }


    @Given("User navigates to {string} page")
    public void userNavigateToPage(String url) {
        logger.info("go to page " + url);
        mainPage.navigateToMainPage(url);


    }


    @Then("Verify that {string} displayed")
    public void elementsIsDisplayed(String xpath) {
        logger.info("element is visible. test get xpath = " + xpath);
        Assertions.assertTrue(mainPage.elementsAreDisplayed(xpath));
    }

    @Then("Verify vehicles carousel is Displayed")
    public void verifyVehiclesCarouselIsDisplayed() {
        logger.info("carousel is displayed. test get boolean "+ mainPage.vehiclesCarouselIsDisplayed());
        Assertions.assertTrue(mainPage.vehiclesCarouselIsDisplayed());

    }

    @And("Verify google review contents carousel iIs displayed")
    public void verifyGoogleReviewContentsCarouselIIsDisplayed() {
        logger.info("google review is visible. test get boolean = " + mainPage.googleReviewCarouselIsDisplayed());
        Assertions.assertTrue(mainPage.googleReviewCarouselIsDisplayed());
    }


    @Then("Click to Home menu")
    public void clickToHomeMenu() {
        logger.info("clickToHomeMenu()");
        mainPage.clickOnHomeLink();
    }

    @And("Verify the Main Page is loaded")
    public void verifyTheMainPageIsLoaded() {
        String currentURL = mainPage.getUrlCurrentPage();
        String expectedURL = "https://www.rightwayautosale.com/";
        logger.info("verifyTheMainPageIsLoaded(). expectedURL = " +expectedURL +"  currentURL = " +currentURL);
        Assertions.assertEquals(expectedURL, currentURL);
    }

    @Then("Click to About US menu")
    public void clickToAboutUSMenu() {
        logger.info("Click to About US menu");
        mainPage.clickAboutUSLink();
    }



    @Then("Click to Contact US menu")
    public void clickToContactUSMenu() {
        logger.info("clickToContactUSMenu");
        mainPage.clickContactUsLink();


    }

    @Then("Click to Inventory Link on top menu Main Page")
    public void clickToInventoryLinkOnTopMenuMainPage() {
        logger.info("clickToInventory()");
        mainPage.clickInventorySLink();
    }

    @When("Verify that permanent elements are displayed")
    public void verifyThatPermanentElementsAreDisplayed() {
        logger.info("PermanentElementsAreDisplayed. test get boolean " + mainPage.permanentElementsDisplayed());
        Assert.assertTrue(mainPage.permanentElementsDisplayed());
    }
}
