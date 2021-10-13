import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "F:/Work/Projects/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void setDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void webTest1() {

        driver.get("http://www.99-bottles-of-beer.net/");

        String expectedResult = "http://www.99-bottles-of-beer.net/";
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void webTest2() {

        driver.get("http://www.99-bottles-of-beer.net/");

        String expectedResult = "Welcome to 99 Bottles of Beer";

        WebElement header = driver.findElement(By.xpath("//div[@id='main']/h2"));
        String headerText = header.getText();

        Assert.assertEquals(headerText, expectedResult);
    }
}
