import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import zmienne.KlasaZmienna;


import java.util.List;
import java.util.Set;

public class google extends KlasaZmienna {

    public WebDriver driver = new ChromeDriver();



@Before
    public void setUp()
{
    String url = "https://www.google.com";
    driver.navigate().to(url);

}

@Test
    public void sprawdzain(){

    driver.findElement(By.className(KlasaZmienna.ID)).click();


  //  driver.findElement(By.className("gLFyf")).click();

    //driver.findElement(By.xpath("//*[@id="tsf"]/div[2]/div[1]/div[1]/div/div[1]/input")).click();
    driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input")).sendKeys("Damian");
    driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/button[2]/div/span/svg")).click();



}

@After
    public void koniec(){
    driver.close();
}

}
