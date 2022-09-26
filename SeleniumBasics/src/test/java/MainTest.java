import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {

    public WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    public String getBASE_URL() {
        return BASE_URL;
    }

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
