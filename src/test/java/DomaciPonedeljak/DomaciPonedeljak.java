package DomaciPonedeljak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DomaciPonedeljak {

    WebDriver driver;
    WebDriverWait wait;
    Cookie cookie;
    Cookie cookie1;
    Cookie cookie2;
    Cookie cookie3;


    @BeforeClass
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/login");


    }

    @BeforeMethod
    public void SettingCookies(){

        cookie = new Cookie( "token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ikx1TWFuIiwicGFzc3dvcmQiOiJTaWZyYTEyMyEiLCJpYXQiOjE3NjQwMjA0NDV9.qxMUrjNYOy8M9hvsMmxP-oSfTqI3-pEH6KKUUuRLk3g");
        driver.manage().addCookie(cookie);
        cookie1 = new Cookie("userID","6b11326a-1a6c-4c35-beeb-313ef026f278");
        driver.manage().addCookie(cookie1);
        cookie2 = new Cookie("userName","LuMan");
        driver.manage().addCookie(cookie2);
        cookie3 = new Cookie("expires","2025-12-01T21%3A47%3A30.124Z");
        driver.manage().addCookie(cookie3);
        driver.navigate().refresh();

    }

    @Test
    public void userIsLoggedIn(){
        WebElement logOutButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Test
    public void userCanLogOut(){

        WebElement logOutButton = driver.findElement(By.id("submit"));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
    }

    @Test
    public void deletingCookies(){
        driver.manage().deleteCookie(cookie);
        driver.manage().deleteCookie(cookie1);
        driver.manage().deleteCookie(cookie2);
        driver.manage().deleteCookie(cookie3);
        driver.navigate().refresh();


        WebElement notLoginLabel = driver.findElement(By.className("form-label"));
        wait.until(ExpectedConditions.visibilityOf(notLoginLabel));
        Assert.assertTrue(notLoginLabel.isDisplayed());

    }

    @AfterClass
    public void quit(){
        driver.quit();
    }



}
