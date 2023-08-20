package second_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorCarTest {
    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro-1578153671498.web.app/registration?url=%2Fsearch");
        driver.manage().window().maximize();
    }

    @Test
    public void searchStrategyTest(){
        WebElement name = driver.findElement(By.id("name"));
        System.out.println(name);
        WebElement name_css = driver.findElement(By.cssSelector("#name"));
        System.out.println(name_css);
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        System.out.println(loginBtn);
        List<WebElement> elements = driver.findElements(By.cssSelector("[formcontrolname='firstName']"));
        System.out.println(elements);
        WebElement nameXpath = driver.findElement(By.xpath("//input[@id='name']"));
        System.out.println(nameXpath);
        WebElement thirdNavlink = driver.findElement(By.xpath("(//a[@class='navigation-link'])[3]"));
        String termOfUse = thirdNavlink.getText();
        String expectedTermOfUse = "Terms of use";
        System.out.println(termOfUse);
        Assert.assertEquals(termOfUse, expectedTermOfUse);

        String partOfTerms = "Terms";
        WebElement containTextXpath = driver.findElement(By.xpath("//a[contains(., " + partOfTerms + ")]"));
        System.out.println(containTextXpath.getText());
        Assert.assertTrue(partOfTerms.contains(containTextXpath.getText()));
    }

    @Test
    public void computerDatabaseTableTest(){
        driver.get("https://computer-database.gatling.io/computers");
        WebElement sq7 = driver.findElement(By.xpath("//tbody/tr[3]/td[2]"));
        WebElement sq7Css = driver.findElement(By.cssSelector("tbody tr:nth-child(3) td:nth-child(2)"));
        Assert.assertEquals(sq7.getText(),sq7Css.getText());
    }

    @Test
    public void w3school(){
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.findElements(By.xpath("(//td[normalize-space()='Island Trading']/../td)[last()]"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
