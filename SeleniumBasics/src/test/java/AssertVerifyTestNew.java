// Generated by Selenium IDE

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AssertVerifyTestNew {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private StringBuffer verificationErrors = new StringBuffer();
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  public void name() {
  }

  @Test
  public void assertVerify() throws Exception {
    driver.get("http://localhost/");
    driver.findElement(By.linkText("Tabulka")).click();

    Assert.assertEquals("1", driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());

    List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

    for (int i = 1; i < rows.size()+1; i++) {
      try {
        Assert.assertEquals(String.valueOf(i), driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    }


//    Assert.assertEquals("5", driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]")).getText());


  }

  @After
  public void tearDown() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();

    if (!"".equals(verificationErrorString)){
      fail(verificationErrorString);
    }
  }
}
