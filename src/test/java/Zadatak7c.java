import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak7c {
    static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-20")));
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Login Page")));
        WebElement testLoginPageLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageLink.click();

        String invalidUserName = "student";
        String invalidPassword = "Password1234";

        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/practice-test-login/"));
        WebElement userNameBox = driver.findElement(By.id("username"));
        userNameBox.sendKeys(invalidUserName);

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.clear();
        passwordBox.sendKeys(invalidPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        WebElement errorDiv = driver.findElement(By.id("error"));
        wait.until(ExpectedConditions.visibilityOf(errorDiv));

        String actualError = errorDiv.getText();
        String expectedError = "Your password is invalid!";
        Assert.assertEquals(actualError,expectedError);


    }
}
