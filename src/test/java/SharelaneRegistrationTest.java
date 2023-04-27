import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharelaneRegistrationTest {
    WebDriver driver;

    @Test
    public void fiveDigitsZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver =  new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
    }
}
