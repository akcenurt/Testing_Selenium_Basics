import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropAndDragTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/moveme.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald, tree).build().perform();
        WebElement actualText = driver.findElement(By.xpath("//div[contains (@class, 'succes')]/h2"));
        Assert.assertTrue(actualText.isDisplayed());





    }
    @After
    public void tearDown(){
        // driver.close();
        // driver.quit();

    }
}
