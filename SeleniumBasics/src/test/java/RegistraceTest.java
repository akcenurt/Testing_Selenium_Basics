import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistraceTest extends MainTest {

    private String validEmail = "truneckaj@gmail.com";
    private String validName = "Jan";
    private String validSurname = "Tru";


    @Before
    public void openBaseURL(){
        driver.get(getBASE_URL()+"registracia.php");
    }

    @Test
    public void testJustCheckbox(){
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Registruj sa']"));

        checkbox.click();
        button.click();

        WebElement error = driver.findElement(By.xpath("//strong[text()='Registracia neuspesna!']"));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test
    public void testMissingPassword() {

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Registruj sa']"));

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        checkbox.click();
        button.click();

        WebElement error = driver.findElement(By.xpath("//strong[text()='Registracia neuspesna!']"));
        Assert.assertTrue(error.isDisplayed());

    }

    @Test
    public void testDifferentPasswords() {

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Registruj sa']"));

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("password")).sendKeys("heslo1");
        driver.findElement(By.name("password-repeat")).sendKeys("heslo2");

        checkbox.click();
        button.click();

        WebElement error = driver.findElement(By.xpath("//strong[text()='Registracia neuspesna!']"));
        Assert.assertTrue(error.isDisplayed());

    }

    @Test
    public void testMissingCheckbox() {

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Registruj sa']"));

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("password")).sendKeys("heslo1");
        driver.findElement(By.name("password-repeat")).sendKeys("heslo1");

        button.click();

        WebElement error = driver.findElement(By.xpath("//strong[text()='Registracia neuspesna!']"));
        Assert.assertTrue(error.isDisplayed());

    }

    @Test
    public void testRegistrationSuccessfull() {

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Registruj sa']"));

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("password")).sendKeys("heslo1");
        driver.findElement(By.name("password-repeat")).sendKeys("heslo1");

        checkbox.click();
        button.click();

        WebElement error = driver.findElement(By.xpath("//strong[text()='Registracia uspesna!']"));
        Assert.assertTrue(error.isDisplayed());

    }

    @Test
    public void testInputErrorBorder() {
        WebElement button = driver.findElement(By.xpath("//button[text()='Registruj sa']"));
        String expectedBorderColor = "rgb(169, 68, 66)";

        button.click();

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        for (WebElement input : inputs) {

            Assert.assertEquals(expectedBorderColor, input.getCssValue("border-color"));
        }

        Assert.assertTrue(driver.findElement(By.xpath("//div[label[input[@id='checkbox']]]"))
                .getAttribute("class").contains("has-error"));

    }

}
