import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testowanie1 {


    public static boolean ifElementPresent (WebDriver driver, By by)
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


    private WebDriver driver;

    @Before
    public void setUp()
    {

        System.setProperty("webdriver.chrome.driver", "E:\\mvnrepository.com\\chromeDriver_Wersja_83\\chromedriver.exe");

        driver = new ChromeDriver();
        String url = "https://www.google.pl/";
        driver.navigate().to(url);

    }


    @Test
    public void testujemyNegatywnie() {

        String wynikTestu = driver.getTitle();
        Assert.assertEquals(wynikTestu, "Kon");

    }

    @Test
    public void testujemyPozytywnie() {

        String wynikTestu = driver.getTitle();
        Assert.assertEquals(wynikTestu, "Google");
    }

    @Test
    public void pozytywnaObecnoscElementu() {

        String wynikTestu = driver.getTitle();
        Assert.assertEquals(wynikTestu, "Google");
        driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a"));

        ifElementPresent(driver, By.xpath("//*[@id=\"gbwa\"]/div/a"));
        Assert.assertTrue(ifElementPresent(driver, By.xpath("//*[@id=\"gbwa\"]/div/a")));
    }

    @Test
    public void negatywnaObecnoscElementu() {

        String wynikTestu = driver.getTitle();
        Assert.assertEquals(wynikTestu, "Google");
        ifElementPresent(driver, By.xpath("ccccccccc"));
        Assert.assertTrue(ifElementPresent(driver, By.xpath("ccccccccc")));
    }

    @After
    public void tearDown() {

        // driver.wait(5000);
        driver.close();

    }


}