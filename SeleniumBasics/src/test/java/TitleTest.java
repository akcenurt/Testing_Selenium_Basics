import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TitleTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);

        List<WebElement> pages = driver.findElements(By.xpath("//ul/li/a"));
        List<String> pageURLs = new ArrayList<>();

        for (WebElement page : pages) {
//            System.out.println(page.getAttribute("href"));
            pageURLs.add(page.getAttribute("href"));
        }

        for (String pageURL : pageURLs) {
            driver.get(pageURL);
            String expectedTitle = pageURL.substring(pageURL.lastIndexOf("/")+1,pageURL.lastIndexOf(".php"));
//            System.out.println(expectedTitle);

            Assert.assertTrue(driver.getTitle()
                    .contains(expectedTitle.substring(0,1).toUpperCase() + expectedTitle.substring(1)));
//            System.out.println(expectedTitle.substring(0,1).toUpperCase() + expectedTitle.substring(1));
        }





    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
