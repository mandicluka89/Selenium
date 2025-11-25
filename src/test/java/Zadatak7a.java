import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak7a {
    static void main(String[] args) throws InterruptedException {

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
        //userNameBox.sendKeys("student");
        userNameBox.clear();
        userNameBox.sendKeys(validUserName);


        WebElement passwordBox = driver.findElement(By.id("password"));
        //passwordBox.sendKeys("Password123");
        passwordBox.clear();
        passwordBox.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/logged-in-successfully/"));
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals( driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(driver.getTitle(),expectedTitle);

        WebElement pageHeader = driver.findElement(By.tagName("h1"));
        String actualPageHeader = pageHeader.getText();
        Assert.assertEquals(pageHeader.getText(), actualPageHeader);




    }
}
