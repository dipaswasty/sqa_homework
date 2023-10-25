package saucedemo.cucumber.stepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";

    @Given("Halaman Login saucedemo")
    public void halamanLoginSaucedemo(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.get(baseURL);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        
    }
    @When("input username")
    public void inputUsername(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @And("input password")
    public void inputPassword(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("input invalid password")
    public void inputInvalidPassword(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce123");
    }


    @And("click login button")
    public void clickLoginButton(){
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }


    @Then("success login")
    public void successLogin(){
        String success = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(success, "");
    }
    
}
