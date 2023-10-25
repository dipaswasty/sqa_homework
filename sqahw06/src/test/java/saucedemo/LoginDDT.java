package saucedemo;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.opencsv.CSVReader;

//import dev.failsafe.internal.util.Assert;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDDT {
    @Test
    //login menggunakan data driven test
    public void loginDdt(){
        WebDriver driver;
        String baseURL = "https://www.saucedemo.com/";
        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();
        
        String csvDir = System.getProperty("user.dir")+"src/test/data/test-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))){
            String[] nextLine;
            while(nextLine=reader.readNext() != null) {
                String username = nextLine[0];
                String password = nextLine[1];
                String status = nextLine[2];

                driver = new ChromeDriver(opt);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                //interaksi elemen: 
                driver.findElement(By.id("user-name")).sendKeys(username);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

                //Assertion
                if (status.equals("success")) {
                    driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
                    String welcome = driver.findElement(By.xpath("status")).getText();
                    Assert.assertEquals(welcome, "Swag Labs");
                }
                else{
                    String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
                    Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
                }

            }
        } catch (IOException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }
}
