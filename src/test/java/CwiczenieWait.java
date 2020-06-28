import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CwiczenieWait {

    private WebDriver driver;


    public static boolean czyElementObecny (WebDriver driver, By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Nie znaleziono elementu");
            return false;
        }
    }

    @Before
    public void setUp()
    {

        System.setProperty("webdriver.chrome.driver", "E:\\mvnrepository.com\\chromeDriver_Wersja_83\\chromedriver.exe");

        driver = new ChromeDriver();
        String url = "https://www.mediaexpert.pl/";
        driver.navigate().to(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("c-search"))));  // PRZYKŁAD EXPLICITY WAITA

    }


    @Test
    public void wrzucenieSlowa(){

        String slowo = "Komputer";
        driver.findElement(By.className("c-search")).sendKeys(slowo);
        driver.findElement(By.className("c-search_submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        Assert.assertTrue(czyElementObecny(driver, By.xpath("//*[@id=\"292591255\"]/div[1]/div[2]/h2/a")));

    }

    @After
    public void poWszystkim(){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        driver.close();
    }


}
