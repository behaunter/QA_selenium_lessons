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

public class Homework_selenium {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void usingByMethod() {
        WebElement city = wd.findElement(By.id("city"));
        System.out.print(city.getText());

        WebElement logo = wd.findElement(By.className("logo"));
        System.out.println(logo.getText());

        WebElement button = wd.findElement(By.tagName("button"));
        System.out.println(button);

        WebElement description = wd.findElement(By.className("description"));
        System.out.println(description.getText());

        WebElement header = wd.findElement(By.xpath("/html/body/app-root/app-navigator[1]"));
        System.out.println(header);

        WebElement span = wd.findElement(By.cssSelector("span.feedback-text"));
        System.out.println(span.getText());

        WebElement letTheCarWork = wd.findElement(By.linkText("Let the car work"));
        System.out.println(letTheCarWork.getText());

        WebElement guaranteedCars = wd.findElement(By.xpath("//span[contains(text(),'Guaranteed cars')]"));
        System.out.println(guaranteedCars.getText());

        WebElement element = wd.findElement(By.cssSelector("app-search:nth-child(5) app-special-offers:nth-child(2) div.special-offers-container div.title-container > span.title"));
        System.out.println(element.getText());


    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
