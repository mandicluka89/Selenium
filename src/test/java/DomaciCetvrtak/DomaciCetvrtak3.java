package DomaciCetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DomaciCetvrtak3 {

    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        Thread.sleep(2000);
        WebElement userNameBox  = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        String validUserName = "standard_user";
        String invalidPassword = "secret_sauce1";

        userNameBox.clear();
        userNameBox.sendKeys(validUserName);
        Thread.sleep(2000);

        passwordBox.sendKeys(invalidPassword);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorMessage.isDisplayed());


    }

}
