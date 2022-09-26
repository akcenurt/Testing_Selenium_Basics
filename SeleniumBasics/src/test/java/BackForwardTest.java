import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BackForwardTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        String email = "truneckaj@gmail.com";
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        Assert.assertEquals(email, driver.findElement(By.xpath("//input[@type='email']")).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath("//input[@type='email']")).getAttribute("value"));
        driver.navigate().forward();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());



    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
