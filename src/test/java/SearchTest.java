import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    public static WebDriver driver;

    @BeforeClass
    public static void init(){
        driver = new FirefoxDriver();

    }

    @Before
    public void getURL(){
        driver.get("https://www.google.com");
    }

    @Test
    public void search(){
        driver.findElement(By.id("lst-ib")).sendKeys("yandex");
        driver.findElement(By.name("btnG")).click();
        WebElement element = (new WebDriverWait(driver,3)).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        assertTrue(element!=null);

    }

    @Test
    public void searchDoudles(){
        String expected = "https://www.google.com/doodles";
        driver.findElement(By.name("btnI")).click();
        WebElement element = (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(By.id("archive-link")));
        String actual = driver.getCurrentUrl();
        System.out.println(actual);
        assertEquals(expected,actual);
    }

}
