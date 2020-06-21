import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testowanie1 {


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

        /* System.setProperty("webdriver.chrome.driver", "E:\\mvnrepository.com\\chromeDriver_Wersja_83\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.google.pl/";
        driver.navigate().to(url); */
        String wynikTestu = driver.getTitle();
        Assert.assertEquals(wynikTestu, "Kon");

    }

    @Test
    public void testujemyPozytywnie() {

        String wynikTestu = driver.getTitle();
        Assert.assertEquals(wynikTestu, "Google");


    }

    @After
    public void tearDown() {

        // driver.wait(5000);
        driver.close();

    }


}