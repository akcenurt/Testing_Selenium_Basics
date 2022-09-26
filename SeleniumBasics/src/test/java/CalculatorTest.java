
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorTest extends MainTest {

    @Before
    public void openBaseURL(){
        driver.get(getBASE_URL()+"kalkulacka.php");
    }


    @Test
    public void testSum(){


        checkSum(driver, "0", "3", "3");
        checkSum(driver, "-6", "-3", "-9");
        checkSum(driver, "999999", "1", "1000000");
        checkSum(driver, "15", "-3", "12");


    }


    @Test
    public void testDeduct(){
        checkDeduct(driver, "5", "2", "deduct", "3");
        checkDeduct(driver, "-5", "-2", "deduct", "-3");

    }

    @Test
    public void testReset(){
        enterInputs(driver,"5","2");
        driver.findElement(By.id("deduct")).click();
        driver.findElement(By.id("reset")).click();
        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed());


    }

    @Test
    public void testInvalidInputs(){
        enterInputs(driver,"a","b");
        checkBothInvalid();
        
        enterInputs(driver,"a","3");
        checkFirstInvalid();
        
        enterInputs(driver, "4","");
        checkSecondInvalid();

        // ALTER:
//        String expectedBorderColor = "rgb(169, 68, 66)";
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Assert.assertEquals(expectedBorderColor,driver.findElement(By.id("firstInput")).getCssValue("border-color"));
//        Assert.assertEquals(expectedBorderColor,driver.findElement(By.id("secondInput")).getCssValue("border-color"));


    }

    private void checkSum(WebDriver driver, String firstInput, String secondInput, String expected) {
        enterInputs(driver, firstInput, secondInput);
        driver.findElement(By.id("count")).click();
        Assert.assertEquals(expected, driver.findElement(By.id("result")).getText());
    }

    private void checkDeduct(WebDriver driver, String firstInput, String secondInput, String id, String expected) {
        enterInputs(driver, firstInput, secondInput);
        driver.findElement(By.id(id)).click();
        Assert.assertEquals(expected, driver.findElement(By.id("result")).getText());
    }

    private static void enterInputs(WebDriver driver, String firstInput, String secondInput) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).sendKeys(secondInput);
    }

    private void checkBothInvalid() {
        driver.findElement(By.id("count")).click();
        Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
                .getAttribute("class").contains("has-error"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
                .getAttribute("class").contains("has-error"));
    }

    private void checkFirstInvalid() {
        driver.findElement(By.id("count")).click();
        Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
                .getAttribute("class").contains("has-error"));
    }

    private void checkSecondInvalid() {
        driver.findElement(By.id("count")).click();
        Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
                .getAttribute("class").contains("has-error"));
    }
    
    
}
