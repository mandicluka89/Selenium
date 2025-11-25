import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");

        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys("Wikipedia");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/h2/a")).click();

        Thread.sleep(2000);
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div/form/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("<input type=\"search\" tabindex=\"0\" title=\"Search Wikipedia\" name=\"search\" value=\"\" autofocus=\"autofocus\" autocapitalize=\"sentences\" id=\"ooui-php-1\" class=\"oo-ui-inputWidget-input\" maxlength=\"300\" autocomplete=\"off\" aria-expanded=\"false\" role=\"combobox\" aria-owns=\"ooui-31\" aria-autocomplete=\"list\">")).sendKeys("Nikola Tesla");
        Thread.sleep(2000);

    }
}
