package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PhoneBookTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void usingByMethod() {
       WebElement h1 =  wd.findElement(By.tagName("h1"));
        System.out.println(h1.getText());
        WebElement container = wd.findElement(By.className("container"));
        System.out.println(container.getText());
        List<WebElement> div = wd.findElements(By.tagName("div"));
        System.out.println(div);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
