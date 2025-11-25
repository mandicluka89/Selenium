import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // U ovoj komandi postavljam driver

        WebDriver driver = new ChromeDriver();
        // U ovoj komandi kreiram objekat sa kojim cu da radim i kome cu da dajem instrukcije
        driver.manage().window().maximize();
        // Ova komanda ce da poveca prozor browsera
        driver.navigate().to("https://www.google.com");
        // Komanda navigate().to() nam otvara odredjen URL koji prosledimo i ceka odgovor od browsera da li je validna stranica, pa tek onda otvara stranicu
        // Slicno tome radi i komanda get(), samo ona ne ceka odgovor vec direktno ide na stranicu iako nije validna
        // URL koji se prosledjuje mora biti u URL formi
        // Sto znaci da string "www.google.com" nece da otvori tu stranicu
        // Ne preporucuje se da rucno kucate URL, najbolja praksa je da kopirate link sa stranice

        driver.get("https://www.google.com");

        System.out.println("TRENUTNI URL");
        System.out.println(driver.getCurrentUrl());
        // Ovom komandom mozemo da dohvatimo trenutni URL
        // Komanda nam sluzi kasnije za asertovanje stranice

        driver.navigate().to("https://www.youtube.com");

        System.out.println("TRENUTNI URL");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        // Komanda koja vraca browser korak nazad

        System.out.println("TRENUTNI URL");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        // Komanda koja ide korak napred

        driver.navigate().refresh();
        // Komanda da se browser refreshuje

        driver.quit();
        // Ovom komandom zatvaramo browser
        // Slicno tome imamo i driver.close() koji ce da zatvori trenutni tab


    }

}