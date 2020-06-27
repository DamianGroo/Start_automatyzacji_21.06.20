import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class Testowanie1 {


    public void czekanie(int czas) {        // PRZYKŁAD SLEEPA, W POSTACI FUNKCJI
        try {
            Thread.sleep(czas);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




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
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS); // PRZYKLAD GLOBALNEGO IMPLICITY WAIT-A

    }


    @Test
    public void testujemyNegatywnie() {

        String wynikTestu = driver.getTitle();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ooooooooooooo"))));  // PRZYKŁAD EXPLICITY WAITA
        Assert.assertEquals(wynikTestu, "Kon");

    }

    @Test
    public void testujemyPozytywnie() {

        String wynikTestu = driver.getTitle();
        czekanie(1000);     // WYWOŁANIE FUNKCJI SLEEPA
        WebDriverWait wait = new WebDriverWait(driver, 5)
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


/*  rodzaje waitów:
                        - implicity wait - bezwgledne ustawienie czasu, globalny czas - czekasz dokladnie tyle, tyle driver ma czasu na znalezienie elementu
                            + robimy to tylko w jednym miejscu i nic wiecej nie obchodzi
                            - jak ustawimy za duzo a element zostanie znaleziony szybciej to strata czasu
                            - moze sie zdarzyc ze ustawimy za malo, wiec element wgl nie zostanie znaleziony
                        - explicit wait - w konkretnym miejscu ustawiamy a nie globalnie (impli i expli nie powinno sie łączyc ze soba)
                            + wieksza elastycznosc, mozna uzywac w wielu miejscach
                        - fluent wait - stosuje sie gdy element laduje sie niestandardowo - czasem 2 sek czasem 20 -
                                        mozemy zadeklarowac maksymalny czas i jak bedzie wiecej to element nie zostanie i nie zostal znaleziony
                                        i ustawiamy sprawdzanie, co iles sekund sprawdz czy juz jest
                            + elastycznosc
                        -- sleepy - tworzy sie je za pomoca funkcji Thread.sleep i try catche-a

 */