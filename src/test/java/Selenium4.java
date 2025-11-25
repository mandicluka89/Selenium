import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.duckduckgo.com/");


        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(Keys.ENTER);

        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // WebElement primerKakoNapravitiCssLokator = driver.findElement(By.cssSelector("tag[atribut=verdnostAtributa]'"));
        // WebElement primerKakoNapravitiCSSodKlase = driver.findElement(By.className("imeklase"));
        searchBox.click();
        WebElement wikiButton = driver.findElement(By.cssSelector("a[data-testid='result-title-a']"));
    }


    //--------------------------

    // ID - jedinstven i stabilan

    // Name - posle ID-a najstabilnije

    // Class

    // CSS selector

    // Link Text - retko se pojavljuje i mora da na elementu postoji text u href tagu

    // Tag - Koristi se kod pretrage webelementa unutar drugog webelementa

    // Relative xpath skracena verzija absolute patha dajemo input sa kojom putanjom se zavrsava xpath

    // Absolute xpath je najnestabilniji jer vrsi pretragu jer vrsi pretragu od pocetka i svaka promena u html u moze da poremeti pretragu

}
