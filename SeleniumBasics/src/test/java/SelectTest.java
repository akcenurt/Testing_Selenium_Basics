import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/vybersi.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
//        new Select(driver.findElement(By.className("form-control"))).selectByIndex(1);
//        new Select(driver.findElement(By.className("form-control"))).selectByValue("02");
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Pikachu"));
        Assert.assertFalse("v textu se nachází slovo choose", driver.findElement(By.xpath("//h3")).getText().contains("choose"));


    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
