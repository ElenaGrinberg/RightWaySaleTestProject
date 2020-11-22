package pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilits.WebDriverSetup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    protected WebDriver driver = WebDriverSetup.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    public void goToPage(String URL) {
        driver.get(URL);
    }

    public boolean isElementDisplayed(String xpath) {
        List<WebElement> webElementList = new ArrayList<>();
        try {
            webElementList = driver.findElements(By.xpath(xpath));

        }catch (Error e) {
            logger.error("Error find elements" + e);
            takeScreenshot("isVisible");
        }
        return webElementList.size() > 0;


    }


    public void clickElementByXpath(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            driver.findElement(By.xpath(xpath)).click();
        }catch (Error e){
            logger.error("BasePage.Error.Click element by Xpath" + xpath);

        }
    }

    public String getCurrentUrlPage() {
        return driver.getCurrentUrl();
    }

    public String getTextFromTitle(String xpath) {
        String text = "";
        try {
            text = driver.findElement(By.xpath(xpath)).getText();
        }catch (Error e){
            logger.error("Error.Get text from title " + e +" "+ xpath);
            takeScreenshot("get_text_from_title");

            }
        return text;
    }

    public void takeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screensots/" + name + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("takeScreenshot." + e);
        }

    }
}
