import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DimensionTestPlusTearDown {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/moveme.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
//        driver.manage().window().setSize(new Dimension(300, 2500));
//        driver.get(BASE_URL);

//        driver.manage().window().maximize();
//        driver.get(BASE_URL);
//        Assert.assertTrue(driver.findElement(By.id("donald")).isDisplayed());

        driver.manage().window().setPosition(new Point(10,100));
        driver.get(BASE_URL);


    }
    @After
    public void tearDown(){
        // driver.quit();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils nejde
        driver.getPageSource();

    }
}
