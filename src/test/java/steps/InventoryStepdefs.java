package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.inventoryPage.InventoryPage;
import pages.inventoryPage.SelectByBodyFunction;
import pages.inventoryPage.SelectByMakeFunction;
import pages.inventoryPage.SelectYearFunction;


public class InventoryStepdefs {
    InventoryPage inventoryPage;
    SelectYearFunction selectYearFunction;
    SelectByBodyFunction selectByBodyFunction;
    SelectByMakeFunction selectByMakeFunction;
    public static final Logger logger = LogManager.getLogger(InventoryStepdefs.class);


    public InventoryStepdefs() {
        inventoryPage = new InventoryPage();
        selectYearFunction = new SelectYearFunction();
        selectByBodyFunction = new SelectByBodyFunction();
        selectByMakeFunction = new SelectByMakeFunction();
    }

    @And("Verify Inventory Page is loaded")
    public void inventoryPageIsOpen() {
        logger.info("Count care on page");
        inventoryPage.countCarsOnPage();
        Assert.assertTrue(inventoryPage.inventoryTitleIsDisplayed());
        Assert.assertTrue(inventoryPage.countCarsOnPage()>0);
    }

    @Then("Verify refine your search label is Displayed")
    public void verifyRefineYourSearchLabelIsDisplayed() {
        Assert.assertTrue(inventoryPage.refineSearchLabelIsDisplayed());
    }

    @Then("User chooses year on left panel")
    public void userChoosesYearOnLeftPanel() {
        inventoryPage.clickLeftMenuByYears2013();
    }

    @When("Make sure the car is the same model year as the selected year")
    public void carIsSameYearAsSelected() {
        String actualStr = inventoryPage.getTextFromAutoTitle();
        String expectedText = "2013";
        Assert.assertEquals(actualStr, expectedText);
    }

    @When("User open menu year")
    public void userOpenMenuYear() {
         selectYearFunction.openMenuYearsByClickArrow();
    }

    @And("User chooses on {string} on left panel")
    public void carIsSameYearAsSelected(String years) {
        selectYearFunction.userChoosesOnYearOnLeftPanel(years);
    }

    @When("Make sure one car on the page is the same model {string} as the selected year")
    public void careIsSameYear(String year){
        String actualData = selectYearFunction.careIsSameYear();
        Assert.assertEquals(actualData, year);
    }

    @When("Title of body type is displayed")
    public void titleOfBodyTypeIsDisplayed() {
        Assert.assertTrue(inventoryPage.titleOfBodyTypeIsDisplayed());
    }

    @And("User chooses {string} of car")
    public void userChoosesTypeOfBodyCar(String type) {
       selectByBodyFunction.userChoosesTypeOfCar(type);
    }

    @Then("make sure that type of displayed care is {string}")
    public void makeSureThatTypeOfDisplayedCareIsSameType(String sameType) {
        String actualType = selectByBodyFunction.getTypeBodyFromText();
        Assert.assertTrue(actualType.equalsIgnoreCase(sameType));
    }

    @Then("User open full menu make")
    public void userOpenFullMenuMake() {
        selectByMakeFunction.openFullMenuMake();
    }

    @And("User chooses on {string} on left menu bar")
    public void choosesMakeInMenuBar(String make) {
        selectByMakeFunction.userChoosesMake(make);
    }

    @When("Make sure one car on the searched page is the same {string} make as the selected")
    public void verifyIsTheSameCompany(String company) {
        String actualMake = selectByMakeFunction.getInfoFromFirstAutoTitle();
        Assert.assertTrue(actualMake.equalsIgnoreCase(company));
    }


    @Then("User selects {string} on left menu bar")
    public void userSelectsEngineInMenuBar(String engine) {
        inventoryPage.selectEngineOnLeftMenuBar(engine);
    }

    @When("Make sure one found car has the same {string} as the selected")
    public void foundCarHasTheSameMotorAsSelected(String motor) {
        String actualMotors = inventoryPage.getInfoEngineFromAutoTitle();
        Assert.assertTrue(actualMotors.equalsIgnoreCase(motor));
    }
}

