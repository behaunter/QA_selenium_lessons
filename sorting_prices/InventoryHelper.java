package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class InventoryHelper extends BaseHelper {
    public InventoryHelper(WebDriver driver) {
        super(driver);
    }

    public void inventoryPageDisplayed() {
        assertTrue(isElementDisplayed("#inventory_container"));
    }

    public List<WebElement> getInventoryItems() {
        return driver.findElements(By.cssSelector(".inventory_item_name"));
    }

    public int getCountAddInventoryBtns() {
        return getSizeElementsOnPage(".btn.btn_primary.btn_small.btn_inventory");
    }
}
