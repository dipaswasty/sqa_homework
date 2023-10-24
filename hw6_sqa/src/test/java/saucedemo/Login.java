package saucedemo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    @Test
    public void successLoginCase(){
        WebDriver driver;
        String URL = "https://www.saucedemo.com/";
        WebDriverManager.safaridriver().setup();

        //apply safari driver
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        String title = driver.getTitle();
        System.out.println(title);

        //membuka halaman login: 
        //input username:
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password:
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();;
    }
}
