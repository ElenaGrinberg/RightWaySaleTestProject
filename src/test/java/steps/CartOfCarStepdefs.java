package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.CartOfCarPage;

public class CartOfCarStepdefs {
    public static final Logger logger = LogManager.getLogger(CartOfCarStepdefs.class);
    CartOfCarPage cartOfCarPage;

    public CartOfCarStepdefs() {
        cartOfCarPage = new CartOfCarPage();
    }


    @Given("User navigates to page of auto")
    public void userNavigatesToPageOfAuto() {
        logger.info("test.userNavigatesToPageOfAuto(). Go to page and click on car");
        cartOfCarPage.goToPageAndClickOnCar();
    }

    @Then("On the page all {string} are displayed")
    public void onThePageAllElementsAreDisplayed(String elements) {
        logger.info("test.onThePageAllElementsAreDisplayed() test get string =  " + elements);
        Assert.assertTrue(cartOfCarPage.cartsElementsAreDisplayed(elements));
    }

    @Then("On the page verbal description is displayed")
    public void onThePageVerbalDescriptionIsDisplayed() {
        logger.info("test.onThePageVerbalDescriptionIsDisplayed(). test get boolean =  " + cartOfCarPage.verbalDescription());
        Assert.assertTrue(cartOfCarPage.verbalDescription());
    }
}

