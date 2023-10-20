package swagLab.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("Halaman login swag lab")
    public void halaman_login_swag_lab() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPage = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPage, "Swag Labs");
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on product page")
    public void userInOnProductPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        String ProductPage = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(ProductPage, "Products");
    }

    @And("Input invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]"));
        String ProductPage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]")).getText();
        Assert.assertEquals(ProductPage, "Epic sadface: Username and password do not match any user in this service");
    }
}
