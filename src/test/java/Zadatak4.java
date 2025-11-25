import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.duckduckgo.com/");

        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("Wikipedia");
        Thread.sleep(2000);
        searchBox.sendKeys(Keys.ENTER);

        WebElement wikiLink = driver.findElement(By.className("OQ_6vPwNhCeusNiEDcGp"));
        wikiLink.click();
        Thread.sleep(2000);

        WebElement wikiSearchBox = driver.findElement(By.id("searchInput"));
        wikiSearchBox.sendKeys("Nikola Tesla");
        Thread.sleep(2000);

        /* PRVI NACIN PRETRAGE PREKO KLASE
        WebElement searchButtonByClass = driver.findElement(By.cssSelector(".sprite.svg-search-icon"));
        searchButtonByClass.click();
        */
        //DRUGI NACIN
        WebElement searchButtonByCustomCss = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButtonByCustomCss.click();


    }
}
