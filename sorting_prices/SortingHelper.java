package fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

public class SortingHelper extends BaseHelper{
    public SortingHelper(WebDriver driver) {
        super(driver);
    }

    public void changeSortingAndCompare(List<String> itemZAName, List<String> itemAZName) {
        Comparator<String> reverseComparator = Comparator.reverseOrder();
        itemZAName.sort(reverseComparator); //AZ -> ZA
        Assert.assertEquals(itemZAName, itemAZName);
    }

    public void changeSortingZA() {
        clickOnElement(".product_sort_container");
        clickOnElement("option[value='za']");
    }


    public void extractTextFromWebElementsAndPopulateList(List<String> itemZAName, List<WebElement> itemsZA) {
        for (WebElement item : itemsZA) {
            if (item != null) {
                itemZAName.add(item.getText());
            }
        }
    }

    public void extractTextFromWebElementsAndPopulateListOfPrice(List<String> firstList, List<WebElement> secondList) {
        for (WebElement price : secondList) {
            if (price != null) {
                firstList.add(price.getText());
            }
        }
    }
    public static boolean compareAndSortLists(List<String> list1, List<String> list2) {
        List<String> sortedList = new ArrayList<>(list1);

        Collections.sort(sortedList, Comparator.comparing(s -> Double.parseDouble(s.substring(1))));

        return sortedList.equals(list2);
    }
}

