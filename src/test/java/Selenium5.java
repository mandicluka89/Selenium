import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium5 {

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
        WebElement searchButtonByCustomCss = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButtonByCustomCss.click();

        Thread.sleep(1000);
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Nikola Tesla - Wikipedia";
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        String expectedPageHeader = "Nikola Tesla";
        WebElement pageHeader = driver.findElement(By.id("firstHeading"));
        String actualPageHeader = pageHeader.getText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImage.isDisplayed());
    }

}
