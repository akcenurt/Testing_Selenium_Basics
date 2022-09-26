import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("clickMe")).click();
        }
        driver.navigate().refresh();
        Assert.assertEquals("0", driver.findElement(By.id("clicks")).getText());



    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
