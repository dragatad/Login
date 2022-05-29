
/*Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Acer\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //fullscreen
        driver.manage().window().maximize();

        //1. otici na sajt
        driver.get("https://www.stealmylogin.com/demo.html");

        //2. pronaci polje za unos korisnickog imena i ukucati korisnicko ime
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("blabla");

        //3. pronaci polje za unos sifre i ukucati sifru
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123");

        //4. pronaci i kliknuti na login
        WebElement login = driver.findElement(By.xpath("/html/body/form/input[3]"));
        login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5. da li je url promjenjen ili ne
        String currentURL = driver.getCurrentUrl();

        if(!currentURL.equals("https://www.stealmylogin.com/demo.html")){
            System.out.println("Nice!");
        }else{
            System.out.println("Not nice!");
        }

        //6.zatvoriti pretrazivac
        driver.close();






    }
}
