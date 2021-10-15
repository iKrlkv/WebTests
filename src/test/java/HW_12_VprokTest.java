import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ranges.Range;

import java.util.List;


public class HW_12_VprokTest extends TestUtils{

    @Test
    public void PopUpExistsTest() {

        driver.get("https://www.vprok.ru/");

        WebElement popUp = driver.findElement(By.className("fo-cookies-policy"));

        Assert.assertTrue(popUp.isDisplayed());
    }

    @Test
    public void closePopUpTest() throws InterruptedException {

        driver.get("https://www.vprok.ru/");

        WebElement closePopUpButton = driver.findElement(By.className("fo-cookies-policy__close-btn"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", closePopUpButton);

        Thread.sleep(15000);

        List <WebElement> popUp = driver.findElements(By.className("fo-cookies-policy"));
        Assert.assertTrue(popUp.isEmpty());
    }

}
