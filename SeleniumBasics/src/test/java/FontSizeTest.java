import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class FontSizeTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/stroopeffect.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void test(){
        driver.get(BASE_URL);
//        System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'colours')]/h1[1]"))
//                .getCssValue("color"));

//        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class, 'colours')]/h1"));
//        for (WebElement title : titles) {
//            System.out.println(title.getText());
//            System.out.println(title.getCssValue("color"));
//            String hexColor = Color.fromString(title.getCssValue("color")).asHex();
//            System.out.println(hexColor);
//
//        }

        System.out.println(driver.findElement(By.xpath("//h1[text()='Stroop effect']"))
                .getCssValue("font-size"));
        String fontSizeWithPx = "60px";
        String fontSizeWithOUTPx = fontSizeWithPx.replace("px", "");
        System.out.println(fontSizeWithOUTPx);
        Integer fontSizeINT = Integer.parseInt(fontSizeWithOUTPx);
        System.out.println(fontSizeINT);

//        String rgba = driver.findElement(By.xpath("//div[contains(@class, 'colours')]/h1[1]"))
//                .getCssValue("color");
//        String hexColor = Color.fromString(rgba).asHex();

//         ANOTHER SOLUTION:
//
//        String hexColor = Color.fromString(driver.findElement(By.xpath("//div[contains(@class, 'colours')]/h1[1]"))
//                .getCssValue("color")).asHex();

//        Assert.assertEquals("#ff0e0e", hexColor);



    }
    @After
    public void tearDown(){
        // driver.quit();

    }
}
