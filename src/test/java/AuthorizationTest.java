import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class AuthorizationTest {
    public static WebDriver driver;

    @Before
    public void init(){
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.id("gb_70")).click();  //enter
    }

    @Test
    public void emptyPassword(){
        String exptected = "Введите адрес электронной почты.";
        driver.findElement(By.id("next")).click();   //next
        WebElement element = (new WebDriverWait(driver,15)).until(ExpectedConditions.visibilityOfElementLocated(By.id("errormsg_0_Email")));
        String actual = element.getAttribute("innerHTML").trim();
        assertEquals(exptected,actual);

    }

    @Test
    public void wrongPassword(){
        String exptected = "Не удалось распознать адрес электронной почты.";
        driver.findElement(By.id("Email")).sendKeys("dfdkfdfd");
        driver.findElement(By.id("next")).click();   //next
        WebElement element = (new WebDriverWait(driver,15)).until(ExpectedConditions.visibilityOfElementLocated(By.id("errormsg_0_Email")));
        String actual = element.getAttribute("innerHTML").trim();
        assertEquals(exptected,actual);
    }
}
