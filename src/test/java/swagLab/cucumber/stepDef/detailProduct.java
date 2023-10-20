package swagLab.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class detailProduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("User on product page")
    public void user_on_product_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPage = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPage, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @When("User click product")
    public void userClickProduct() {
        driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).click();
    }

    @Then("User can redirect to detail product")
    public void userCanRedirectToDetailProduct() {
        String detailItem = driver.findElement(By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(detailItem, "Sauce Labs Backpack");
    }
}
