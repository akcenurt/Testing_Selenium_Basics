import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingTest {

    private WebDriver driver;

    private final String BASE_URL = "http://localhost/zjavenie.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.id("showHim")).click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='brano']")));
//        System.out.println(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());

    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
