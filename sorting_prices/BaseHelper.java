package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseHelper {
    WebDriver driver;
    public BaseHelper(WebDriver driver){
        this.driver = driver;
    }

    final String STANDARD_USER = "standard_user";
    final String LOCKED_OUT_USER = "locked_out_user";
    final String PROBLEM_USER = "problem_user";
    final String PERF_USER = "performance_glitch_user";

    String PASSWORD = "secret_sauce";

    public void fillField(String text, String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
        driver.findElement(By.cssSelector(cssSelector)).clear();
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public boolean isElementDisplayed(String cssLocator) {
        pause(50);
        return getSizeElementsOnPage(cssLocator) > 0;
    }

    public void  pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementNotDisplayed(String cssLocator) {
        return getSizeElementsOnPage(cssLocator) == 0;
    }

    public boolean countElementsOnPage(String cssSelector, int expectedCount) {
        return getSizeElementsOnPage(cssSelector) == expectedCount;
    }

    public int getSizeElementsOnPage(String cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector)).size();
    }

    public String getTextFromElement(String xpathExpression) {
        return driver.findElement(By.xpath(xpathExpression)).getText();
    }

    public void clickOnElementByXpath(String xpathExpression) {
        driver.findElement(By.xpath(xpathExpression)).click();
    }
    public void clickOnElement(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
    public List<WebElement> getElementsFromPage(String csslocator){
        return driver.findElements(By.cssSelector(csslocator));

    }
}



