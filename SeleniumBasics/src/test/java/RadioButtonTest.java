import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zenaalebomuz.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class='description text-center']")).getText());
        Assert.assertTrue("ověřuji výběr prvního tlačítka",
                driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse("ověřuji výběr druhého tlačítka",
                driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());

    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
