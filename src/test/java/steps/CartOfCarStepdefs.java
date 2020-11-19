package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartOfCarPage;

public class CartOfCarStepdefs {
    CartOfCarPage cartOfCarPage;

    public CartOfCarStepdefs() {
        cartOfCarPage = new CartOfCarPage();
    }


    @Given("User navigates to page of auto")
    public void userNavigatesToPageOfAuto() {
        cartOfCarPage.goToPageAndClickOnCar();
    }

    @Then("On the page all {string} are displayed")
    public void onThePageAllElementsAreDisplayed(String elements){
        Assert.assertTrue(cartOfCarPage.cartsElementsAreDisplayed(elements));
    }

    @Then("On the page verbal description is displayed")
    public void onThePageVerbalDescriptionIsDisplayed() {
       Assert.assertTrue(cartOfCarPage.verbalDescription());
       }
    }

