package swagLab.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class shoppingCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("User di halaman product page")
    public void user_di_halaman_product_page() {
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

    @When("User add items to the cart")
    public void user_add_items_to_the_cart() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("User navigate to the cart")
    public void user_navigate_to_the_cart() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @Then("User should see the added items in the cart")
    public void user_should_see_the_added_items_in_the_cart() {
        String cartItem = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).getText();
        Assert.assertEquals(cartItem, "Sauce Labs Backpack");
    }
}
