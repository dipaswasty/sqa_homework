import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    @Test //tag untuk running script di bawah ini:
    public void openBrowser(){
        WebDriver driver;
        String baseURL = "http://kasirdemo.belajarqa.com/";
        WebDriverManager.chromedriver().setup();
        //ChromeOptions opt = new ChromeOptions();

        //apply chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

        //Get Form
        

       // driver.close();
    }
    @Test
    public void getTitleSafari(){
        WebDriver driver;
        String baseURL = "http://kasirdemo.belajarqa.com/";
        WebDriverManager.safaridriver().setup();
        //ChromeOptions opt = new ChromeOptions();

        //apply Safari driver
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

       // driver.close();
    }
}
