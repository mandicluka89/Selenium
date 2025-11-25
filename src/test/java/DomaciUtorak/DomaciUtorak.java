package DomaciUtorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class DomaciUtorak {

    static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]")).sendKeys("youtube music");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/div[2]/h2/a")).click();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center\"]/yt-searchbox/div[1]/form/input")).sendKeys("mockingbird eminem");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center\"]/yt-searchbox/button/span/span/div")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();

        Thread.sleep(31000);
        driver.findElement(By.xpath("//*[@id=\"skip-button:2\"]")).click(); //gasi reklamu :)

    }

}
