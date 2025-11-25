import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        System.out.println(listaTabova);


        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://youtube.com/");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.joberty.com/");

        driver.close();

        driver.switchTo().window(listaTabova.get(2));
        driver.close();

        driver.switchTo().window(listaTabova.get(1));
        driver.close();


    }
}
