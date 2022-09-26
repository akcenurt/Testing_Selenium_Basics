import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/nemenne.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
//        System.out.println(driver.findElement(By.id("inputEmail3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("inputEmail3")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());

        System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).getText());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());

        System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).getText());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());

        System.out.println(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).getText());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

        Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Mna nestlacis']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//button[text()='Mna nestlacis']")).isEnabled());

        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]")).isEnabled());



    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
