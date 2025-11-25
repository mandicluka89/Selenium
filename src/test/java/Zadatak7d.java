import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak7d {

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

        String validUserName = "student";
        String validPassword = "Password123";


        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/practice-test-login/"));
        WebElement userNameBox = driver.findElement(By.id("username"));
        userNameBox.clear();
        userNameBox.sendKeys(validUserName);


        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.clear();
        passwordBox.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/logged-in-successfully/"));
        WebElement LogOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(LogOutButton.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(LogOutButton));
        LogOutButton.click();
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        boolean isPresent = false;

        try{
            isPresent = driver.findElement(By.linkText("Log Out")).isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertFalse(isPresent);


    }
}
