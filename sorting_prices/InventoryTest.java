package com.saucedemo.automation;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class InventoryTest extends Base{
    @BeforeMethod
    public void setup() {
        app.getLoginHelper().logoutUserIfLogged();
    }

    @Test
    public void inventoryItemsOnPage() {
        app.getLoginHelper().loginWithStandardUser();
        assertTrue(app.getBaseHelper().isElementDisplayed(".inventory_item"));
        assertTrue(app.getInventoryHelper().countElementsOnPage(".inventory_item", 6));
    }

    @Test
    public void sortingItemsAlphabetic() {
        app.getLoginHelper().loginWithStandardUser();
        List<String> itemAZName = new ArrayList<>();
        List<String> itemZAName = new ArrayList<>();

        List<WebElement> itemsAZ = app.getInventoryHelper().getInventoryItems();
        app.getSortingHelper().extractTextFromWebElementsAndPopulateList(itemAZName, itemsAZ);
        app.getSortingHelper().changeSortingZA();
        List<WebElement> itemsZA = app.getInventoryHelper().getInventoryItems();
        app.getSortingHelper().extractTextFromWebElementsAndPopulateList(itemZAName, itemsZA);
        app.getSortingHelper().changeSortingAndCompare(itemZAName, itemAZName);
    }

    @Test
    public void sortingByPrice() {
        app.getLoginHelper().loginWithStandardUser();
        app.getBaseHelper().clickOnElement("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container > select.product_sort_container");
        app.getBaseHelper().clickOnElement("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container select.product_sort_container > option:nth-child(3)");
        List<String> lowToHighPriceValue = new ArrayList<>();
        List<String> highToLowPriceValue = new ArrayList<>();
        List<WebElement> priceLowToHigh = app.getBaseHelper().getElementsFromPage(".inventory_item_price");
        app.getSortingHelper().extractTextFromWebElementsAndPopulateListOfPrice(lowToHighPriceValue, priceLowToHigh);
        app.getBaseHelper().clickOnElement("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container > select.product_sort_container");
        app.getBaseHelper().clickOnElement("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container select.product_sort_container > option:nth-child(4)");
        List<WebElement> priceHighToLow = app.getBaseHelper().getElementsFromPage(".inventory_item_price");
        app.getSortingHelper().extractTextFromWebElementsAndPopulateListOfPrice(highToLowPriceValue,priceHighToLow);
        app.getSortingHelper().compareAndSortLists(highToLowPriceValue,lowToHighPriceValue);


    }

    @Test
    public void addToCart() {
        app.getLoginHelper().loginWithStandardUser();
        int countAddToCartBtns = app.getInventoryHelper().getCountAddInventoryBtns();
        app.getBaseHelper().clickOnElement(".btn.btn_primary.btn_small.btn_inventory");
        app.getBaseHelper().pause(100);
        assertEquals(app.getInventoryHelper().getCountAddInventoryBtns(),
                countAddToCartBtns - 1);
        assertEquals(app.getCardHelper().getShoppingCartBadgeCount(), 1);
        app.getCardHelper().openCart();
        assertEquals(app.getBaseHelper().getSizeElementsOnPage(".cart_item"), 1);

        // cleanup
        app.getBaseHelper().clickOnElement("#continue-shopping");
        app.getBaseHelper().clickOnElement(".btn.btn_primary.btn_small.btn_inventory");
    }

}
