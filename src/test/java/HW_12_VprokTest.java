import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ranges.Range;

import java.util.List;
import java.util.concurrent.TimeUnit;


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

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        Thread.sleep(2000);

        List<WebElement> popUp = driver.findElements(By.className("fo-cookies-policy"));
        Assert.assertTrue(popUp.isEmpty());
    }

    @Test
    public void changeRegionTest() throws InterruptedException {

        driver.get("https://www.vprok.ru/");

        String region = "Свердловская обл.";

        WebElement changeRegionLink = driver.findElement(By.className("js-address-data"));
        changeRegionLink.click();

        Thread.sleep(1500);

        WebElement regionToSelect = driver.findElement(By.xpath("//div[@id='form_popup-polygons']//a[contains(text(), '" + region + "')]"));
        regionToSelect.click();

        Thread.sleep(1500);

        Assert.assertEquals(driver.findElement(By.className("js-address-data")).getText().trim(), region);
    }

}
