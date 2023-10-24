import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    @Test
    public void openBrowser(){
        WebDriver driver;
        String URL = "https://www.saucedemo.com";
        WebDriverManager.safaridriver().setup();

        //apply safari driver
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        String title = driver.getTitle();
        System.out.println(title);
    }
}
