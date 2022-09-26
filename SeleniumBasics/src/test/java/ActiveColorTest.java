import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActiveColorTest {

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
        String expectedYellow = "rgba(191, 111, 7, 1)";

        Actions actions = new Actions(driver);
        actions.clickAndHold(trafficLight).build().perform();
        String actualYellow = trafficLight.getCssValue("background-color");

        Assert.assertEquals(expectedYellow, actualYellow);



    }
    @After
    public void tearDown(){
         driver.close();
         driver.quit();

    }
}
