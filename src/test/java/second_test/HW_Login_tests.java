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

public class HW_Login_tests {
    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro-1578153671498.web.app/login?url=%2Fterms-of-use");
        driver.manage().window().maximize();
    }

    @Test
    public void PhoneNumber_is_right(){
        WebElement phoneNumber = driver.findElement(By.linkText("866-720-5721"));
        String realNumber = "866-720-5721";
        Assert.assertEquals(phoneNumber.getText(),realNumber);
    }

    @Test
    public void JohnBayramov_text_is_right(){
        WebElement johnBayramovText = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-navigator[1]/app-login-registration[1]/app-special-offers[1]/div[1]/div[4]/div[1]/div[3]/span[1]"));
        String johnBayramovRealText = "Our car was modern and extremely well equipped. The facilities are great. Interior trim is of excellent quality. It made us happy after a previous experience in another place.";
        Assert.assertEquals(johnBayramovText.getText(),johnBayramovRealText);
    }

    @Test
    public void Logo_Present_On_Site(){
        WebElement logo = driver.findElement(By.xpath("//body/app-root[1]/app-navigator[1]/div[1]/a[1]/img[1]"));
        Boolean logoPresent = logo.isDisplayed();
        Assert.assertTrue(logoPresent, "Logo Present");
    }

    @Test
    public void title_is_not_null(){
        WebElement verifyTitle = driver.findElement(By.tagName("h1"));
        Assert.assertNotNull(verifyTitle);
    }

    @Test
    public void password_not_equals_other_text(){
        WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-navigator[1]/app-login-registration[1]/div[1]/div[1]/div[1]/app-login[1]/form[1]/div[2]/label[1]"));
        System.out.println(password.getText());
        Assert.assertNotEquals(password.getText(),"passwor");
        Assert.assertNotEquals(password.getText(),"passwords");
        Assert.assertNotEquals(password.getText(),"Passwords");
        Assert.assertNotEquals(password.getText(),"password");
        Assert.assertNotEquals(password.getText(),"passwort");
        Assert.assertNotEquals(password.getText(),"pass");
        Assert.assertNotEquals(password.getText(),"Password");
        Assert.assertNotEquals(password.getText(),"Password ");
        Assert.assertNotEquals(password.getText(),"Password **");
        Assert.assertNotEquals(password.getText()," ");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
