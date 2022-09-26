import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabulkaTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        for (int i = 1; i < rows+1; i++) {
            Assert.assertFalse("neobsahuje příjmení", driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText().isEmpty());
//            System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText());
        }

    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
