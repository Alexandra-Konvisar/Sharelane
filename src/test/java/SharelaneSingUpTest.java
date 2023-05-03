import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
1234
public class SharelaneSingUpTest{

        WebDriver driver;

        public class SharelaneSingUpTest extends BaseTest {

        @Test
        public void fiveDigitsZipCodeTest() {
            driver.get("https://www.sharelane.com/cgi-bin/register.py");
            driver.findElement(By.name("zip_code")).sendKeys("12345");
            driver.findElement(By.cssSelector("[value='Continue']")).click();
        }

        @Test
        public void PositiveSingUpTest () {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
            driver.findElement(By.name("first_name")).sendKeys("Alexandra");
            driver.findElement(By.name("last_name")).sendKeys("Konvisar");
            driver.findElement(By.name("email")).sendKeys("test@sharelane.com");
            driver.findElement(By.name("password1")).sendKeys("1234567");
            driver.findElement(By.name("password2")).sendKeys("1234567");
            WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
            Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
        }

        @Test
        public void NumbersInNameFieldTest () {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
            driver.findElement(By.name("first_name")).sendKeys("12345");
            driver.findElement(By.name("last_name")).sendKeys("12345");
            driver.findElement(By.name("email")).sendKeys("test@sharelane.com");
            driver.findElement(By.name("password1")).sendKeys("1234567");
            driver.findElement(By.name("password2")).sendKeys("1234567");
            WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
            Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
        }

        @Test
        public void SpacesInNameFieldTest () {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
            driver.findElement(By.name("first_name")).sendKeys("   ");
            driver.findElement(By.name("last_name")).sendKeys("   ");
            driver.findElement(By.name("email")).sendKeys("test@sharelane.com");
            driver.findElement(By.name("password1")).sendKeys("1234567");
            driver.findElement(By.name("password2")).sendKeys("1234567");
            WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
            Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
        }

        @Test
        public void InvalidEmailTest () {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
            driver.findElement(By.name("first_name")).sendKeys("Alexandra");
            driver.findElement(By.name("last_name")).sendKeys("Konvisar");
            driver.findElement(By.name("email")).sendKeys("test_sharelane.com");
            driver.findElement(By.name("password1")).sendKeys("1234567");
            driver.findElement(By.name("password2")).sendKeys("1234567");
            WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
            Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
        }

        @Test
        public void NonMatchingPasswords () {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
            driver.findElement(By.name("first_name")).sendKeys("Alexandra");
            driver.findElement(By.name("last_name")).sendKeys("Konvisar");
            driver.findElement(By.name("email")).sendKeys("test@sharelane.com");
            driver.findElement(By.name("password1")).sendKeys("1234567");
            driver.findElement(By.name("password2")).sendKeys("12345678");
            WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
            Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
        }

        @Test
        public void EmptyPasswordFieldTest () {
            driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=&last_name=&email=&password1=&password2=");
            driver.findElement(By.name("first_name")).sendKeys("Alexandra");
            driver.findElement(By.name("last_name")).sendKeys("Konvisar");
            driver.findElement(By.name("email")).sendKeys("test@sharelane.com");
            driver.findElement(By.name("password1")).sendKeys("");
            driver.findElement(By.name("password2")).sendKeys("12345678");
            WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
            Assert.assertTrue("Register button is displayed", registerButton.isDisplayed());
        }
    }
}
