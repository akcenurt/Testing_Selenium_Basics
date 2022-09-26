import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/semafor.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        WebElement trafficLight = driver.findElement(By.xpath("//div[@class='light']"));

        String expectedRed = "rgba(205, 58, 63, 1)";
        String actualRed = trafficLight.getCssValue("background-color");

        Assert.assertEquals(expectedRed, actualRed);

        String expectedGreen = "rgba(10, 129, 0, 1)";

        Actions actions = new Actions(driver);
        actions.moveToElement(trafficLight).build().perform();
        String actualGreen = trafficLight.getCssValue("background-color");

//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='light']")));
        Assert.assertEquals(expectedGreen, actualGreen);



    }
    @After
    public void tearDown(){
        // driver.close();
        // driver.quit();


    }
}
