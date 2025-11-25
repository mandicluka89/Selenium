import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Zadatak9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.className("card-body"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @BeforeMethod void navigateToElements(){
        List<WebElement> listOfButtons = driver.findElements(By.className("card-body"));
        for (int i=0; i<listOfButtons.size(); i++){
            if (listOfButtons.get(i).getText().equals("Elements")) {
                listOfButtons.get(i).click();
                break;
            }
        }
        WebElement webTablesButton = driver.findElement(By.id("item-3"));
        webTablesButton.click();

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement userForm = driver.findElement(By.id("userForm"));
        wait.until(ExpectedConditions.visibilityOf(userForm));
        Assert.assertTrue(userForm.isDisplayed());


    }

    @Test
    public void userCanAddOnePerson(){


        WebElement firstNameBox = driver.findElement(By.id("firstName"));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameBox));
        firstNameBox.click();
        firstNameBox.clear();
        firstNameBox.sendKeys("Luka");

        WebElement lastNameBox = driver.findElement(By.id("lastName"));
        lastNameBox.clear();
        lastNameBox.sendKeys("Mandic");

        WebElement userEmailBox = driver.findElement(By.id("userEmail"));
        userEmailBox.clear();
        userEmailBox.sendKeys("luka@gmail.com");

        WebElement userAge = driver.findElement(By.id("age"));
        userAge.clear();
        userAge.sendKeys("36");

        WebElement userSalary = driver.findElement(By.id("salary"));
        userSalary.clear();
        userSalary.sendKeys("200000");

        WebElement userDepartment = driver.findElement(By.id("department"));
        userDepartment.clear();
        userDepartment.sendKeys("Sales");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }

    @Test
    public void userCanAddSecondPerson(){


        WebElement firstNameBox = driver.findElement(By.id("firstName"));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameBox));
        firstNameBox.click();
        firstNameBox.clear();
        firstNameBox.sendKeys("Jovana");

        WebElement lastNameBox = driver.findElement(By.id("lastName"));
        lastNameBox.clear();
        lastNameBox.sendKeys("Mandic");

        WebElement userEmailBox = driver.findElement(By.id("userEmail"));
        userEmailBox.clear();
        userEmailBox.sendKeys("jovana@gmail.com");

        WebElement userAge = driver.findElement(By.id("age"));
        userAge.clear();
        userAge.sendKeys("37");

        WebElement userSalary = driver.findElement(By.id("salary"));
        userSalary.clear();
        userSalary.sendKeys("150000");

        WebElement userDepartment = driver.findElement(By.id("department"));
        userDepartment.clear();
        userDepartment.sendKeys("Maintance");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }

    @Test
    public void userCanAddThirdPerson(){


        WebElement firstNameBox = driver.findElement(By.id("firstName"));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameBox));
        firstNameBox.click();
        firstNameBox.clear();
        firstNameBox.sendKeys("Dejan");

        WebElement lastNameBox = driver.findElement(By.id("lastName"));
        lastNameBox.clear();
        lastNameBox.sendKeys("Petrovic");

        WebElement userEmailBox = driver.findElement(By.id("userEmail"));
        userEmailBox.clear();
        userEmailBox.sendKeys("dejan@gmail.com");

        WebElement userAge = driver.findElement(By.id("age"));
        userAge.clear();
        userAge.sendKeys("24");

        WebElement userSalary = driver.findElement(By.id("salary"));
        userSalary.clear();
        userSalary.sendKeys("100000");

        WebElement userDepartment = driver.findElement(By.id("department"));
        userDepartment.clear();
        userDepartment.sendKeys("IT");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }




}
