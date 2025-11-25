import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium7{

    static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie( "wordpress_logged_in", "mandicmarko020%7C1858364643%7C8XWgaIVw6IaTdsEAE2JSuukjiPLuqgQ9WCUPQCl1KQd%7Cd4f2a21d091ce0a4eee2582103a1679c641e975f8645e910b2b765ade95e03ff");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        //-----------

        driver.manage().deleteAllCookies();
        driver.quit();


    }

}
