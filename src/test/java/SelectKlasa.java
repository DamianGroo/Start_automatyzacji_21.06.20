import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectKlasa {

    private WebDriver driver;

    public void isVisibleOrNot()
    {
        ;
    }

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "E:\\mvnrepository.com\\chromeDriver_Wersja_83\\chromedriver.exe");

        driver = new ChromeDriver();
        String url = "https://www.mediaexpert.pl/";
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }



    @Test
    public void testujemySelect()
    {

    }


    @After
    public void poWszystkim()
    {

    }



}
