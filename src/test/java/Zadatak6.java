import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        WebElement logInButton = driver.findElement(By.linkText("Log in"));
        logInButton.click();

        String validUsername = "dragoljubqa";
        String validPassword = "Swordfish!@#123";
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(3000);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        continueButton.click();

        Thread.sleep(5000);

        String expectedURL = "https://wordpress.com/home/dragoljubqa.wordpress.com";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        WebElement welcomeMessage = driver.findElement(By.className("masterbar__item-howdy-howdy"));
        Assert.assertTrue(welcomeMessage.isDisplayed());

        Assert.assertTrue(welcomeMessage.getText().contains(validUsername));

    }
}
