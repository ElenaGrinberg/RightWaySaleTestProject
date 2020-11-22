import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilits.WebDriverSetup;

@CucumberOptions(
        features = { /*"src/test/resources/CartOfCar.feature","src/test/resources/SortOptions.feature", */"src/test/resources/RightWaySale.feature", /*"src/test/resources/InventoryPage.feature"*/
        },
        plugin= {"pretty", "html:target/cucumber-reports/"}
        //glue = {"steps"}
)


@RunWith(Cucumber.class)


public class TestRunner {
    @BeforeClass
    public static void setup() {
        WebDriverSetup.startWebDriver(WebDriverSetup.Browser.CHROME);
    }

    @AfterClass
    public static void tearDown() {
        WebDriverSetup.closeDriver();
    }
}



