import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWPraktyce {

    private WebDriver driver;

    public void isVisibleOrNot()
    {
        ;
    }

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "E:\\mvnrepository.com\\chromeDriver_Wersja_83\\chromedriver.exe");

        driver = new ChromeDriver();
        String url = "https://www.mediaexpert.pl/";
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }


    @Test
    public void testtt()
    {
        WebDriverWait wait = new WebDriverWait(driver, 9);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Telewizory i RTV")));
        driver.findElement(By.linkText("Telewizory i RTV")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div[7]/div[2]/div[1]/div/div/ul/li[1]/a")));
        driver.findElement(By.linkText("Telewizory")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("297132751")));
    }


    @After
    public void koniec()
    {
        driver.close();
    }




}
