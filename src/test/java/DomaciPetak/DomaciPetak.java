package DomaciPetak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciPetak {
    static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.urlToBe("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2"));
            WebElement continueShopping = driver.findElement(By.cssSelector("button[type='submit']"));
            continueShopping.click();
        }catch (Exception e){

        }

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();


        String expectedCartCounter = "1";
        WebElement cartCounter = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCounter.getText(),expectedCartCounter);


        Cookie cookie = new Cookie( "session-token", "aqF/VtrtUgwHCEdgEO5adcxs0o3P9YflJFv49VAeR7yKtxenuYhgWWY7t03OZe8E1ybgzkFNjy7CuaIf6qYdDMcmZLcReFdvpBq7l9qVoreLCMcT/WcOXSKcgkhrB8NfGagsrKH1tT0is3qaIhdTLK/ouev1pYxOsDI9e+UA04XpOJzjh2ddC5Tv1frj6im2vyWq0h1GhWmiQ/Xj9ytdsPcYpZ1YWDG1aLVinaURduiD/xMptK+NchqfZO++OAfR5s0oJz8za3HKONOVYT9XU5JrxOiR3jq+/h8CzriIzLohmPi6+ypK2s1FBoLbyF26KMXAU5cNc3Q1hOdqou8UJe+t0j4l+qxh");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        String expectedCartCounterEmpty = "0";
        WebElement cartCounterEmpty = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCounterEmpty.getText(),expectedCartCounterEmpty);



    }


}
