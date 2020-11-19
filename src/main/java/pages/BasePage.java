package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilits.WebDriverSetup;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver = WebDriverSetup.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 50);

    public void goToPage(String URL) {
        driver.get(URL);
    }

    public boolean isElementDisplayed(String xpath) {
        List<WebElement> webElementList = driver.findElements(By.xpath(xpath));
        return webElementList.size() > 0;
    }


    public void clickElementByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getCurrentUrlPage() {
        return driver.getCurrentUrl();
    }

    public String getTextFromTitle(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

}
