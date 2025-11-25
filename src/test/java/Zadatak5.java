import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        Thread.sleep(2000);
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        Thread.sleep(2000);
        WebElement testLoginPageLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageLink.click();

        String validUserName = "student";
        String validPassword = "Password123";


        Thread.sleep(2000);
        WebElement userNameBox = driver.findElement(By.id("username"));
        //userNameBox.sendKeys("student");
        userNameBox.clear();
        userNameBox.sendKeys(validUserName);

        Thread.sleep(2000);
        WebElement passwordBox = driver.findElement(By.id("password"));
        //passwordBox.sendKeys("Password123");
        passwordBox.clear();
        passwordBox.sendKeys(validPassword);

        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(2000);
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals( driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Logged In Successfully | Practice Test Automation";
        Assert.assertEquals(driver.getTitle(),expectedTitle);

        WebElement pageHeader = driver.findElement(By.tagName("h1"));
        String actualPageHeader = pageHeader.getText();
        Assert.assertEquals(pageHeader.getText(), actualPageHeader);

    }
}
