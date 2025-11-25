package DomaciCetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciCetvrtak2 {

    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        Thread.sleep(2000);
        WebElement userNameBox  = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        String invalidUserName = "error_user";
        String validPassword = "secret_sauce";

        userNameBox.clear();
        userNameBox.sendKeys(invalidUserName);
        Thread.sleep(2000);

        passwordBox.sendKeys(validPassword);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        String expectedTitle = "Swag Labs";
        Assert.assertEquals(driver.getTitle(),expectedTitle);


    }
}