import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SimpleLoginTest {
    WebDriver driver;
    String correctUsername = "Sandro";
    String correctPassword = "Giorgishvili123!";
    String incorrectPassword = "Giorgishvili";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginFailed() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        driver.get("https://demoqa.com/login");

        driver.findElement(By.id("userName")).sendKeys(correctUsername);
        driver.findElement(By.id("password")).sendKeys(incorrectPassword);
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

        Assert.assertEquals(driver.findElement(By.id("name")).getText(), "Invalid username or password!");
    }

    @Test
    public void successfulLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        driver.get("https://demoqa.com/login");

        driver.findElement(By.id("userName")).sendKeys(correctUsername);
        driver.findElement(By.id("password")).sendKeys(correctPassword);
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName-value")));

        Assert.assertTrue(driver.findElement(By.id("userName-label")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("userName-value")).getText(), correctUsername);
    }

    @AfterClass
    public void TearDown() {
        driver.close();
    }
}
