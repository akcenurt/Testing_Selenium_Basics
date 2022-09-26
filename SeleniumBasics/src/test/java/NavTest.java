import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class NavTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        String expectedClass = "active";
        List<String> pages = new ArrayList<>();
        pages.add("vybersi.php");
        pages.add("tabulka.php");
        pages.add("redalert.php");
        for (String page : pages) {
            driver.get(BASE_URL + page);
//        System.out.println(driver.findElement(By.xpath("//li[a/@href='vybersi.php']"))
//                        .getAttribute("class"));
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='"+ page + "']"))
                    .getAttribute("class").contains(expectedClass));
        }

        //PŮVODNĚ PŘED ITERACÍ:
//        driver.get(BASE_URL + "vybersi.php");
////        System.out.println(driver.findElement(By.xpath("//li[a/@href='vybersi.php']"))
////                        .getAttribute("class"));
//        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='vybersi.php']"))
//                .getAttribute("class").contains(expectedClass));
//
//        driver.get(BASE_URL + "tabulka.php");
//        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='tabulka.php']"))
//                .getAttribute("class").contains(expectedClass));
//
//        driver.get(BASE_URL + "redalert.php");
//        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='redalert.php']"))
//                .getAttribute("class").contains(expectedClass));

    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
