import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AATestFromScratch {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/kalkulacka.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);


    }
    @Test
    public void test(){



    }
    @After
    public void tearDown(){
        // driver.close();
        // driver.quit();

    }
}
