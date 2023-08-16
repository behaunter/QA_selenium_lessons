package first_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver; //wd , d
    // before - setUP()

    @BeforeMethod
    public void setUP(){
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
    }
    //test -test ()
    @Test
    public void ebayOpenTest(){
        System.out.println("Test passed");
    }


    // after - tearDown()
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
