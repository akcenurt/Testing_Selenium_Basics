import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/redalert.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.id("alert1")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        Assert.assertEquals("ověřuji Kirov Reporting",
                "Kirov Reporting", driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert2")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        Assert.assertEquals("ověřuji Negative",
                "Negative", driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        driver.findElement(By.id("alert3")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Yuri");
        System.out.println(alert3.getText());
        alert3.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        Assert.assertTrue("contains right input",
                driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Yuri"));





    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
