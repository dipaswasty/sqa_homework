package saucedemo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//import dev.failsafe.internal.util.Assert;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    @Test
    public void successLoginCase(){
        WebDriver driver;
        String baseURL = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

        // String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        // Assert.assertEquals(loginPageAssert, actual: "");
        // String actualTitle = "";

        //membuka halaman login:
        //input username yang benar
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password yang benar
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        //alternatif lain xpath: 
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Test
    public void failedLoginCase(){
        WebDriver driver;
        String baseURL = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

        //membuka halaman login:
        //input username yang salah
        driver.findElement(By.id("user-name")).sendKeys("user_standard");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
        //click login menggunakan xpath: 
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

       // String errorLogin = driver.findElement(By.xpath("//div[@role=\"alert\"]")).getText();
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

}
