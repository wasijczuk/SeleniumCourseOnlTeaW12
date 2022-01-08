package pl.coderslab.seleniumcourse.ZadWarsztatowe2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZadWarsztatowe2Steps {
    private WebDriver driver;

    @Given("^Web page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(url);
    }

    @And("^log in to account$")
    public void logInBtn() {
        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("ania123@gmail.com");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("qwerty123");

        WebElement logInBtn = driver.findElement(By.id("submit-login"));
        logInBtn.click();
    }

    @When("^search the Hummingbird Printed Sweater and select product$")
    public void searchSweater() {
        WebElement searchClothes = driver.findElement(By.id("category-3"));
        searchClothes.click();
        WebElement sweaterBtn = driver.findElement(By.xpath("//h2[@class='h3 product-title']"));
        sweaterBtn.click();
    }

    @And("^select size: (.*)$")
    public void selectSize(String size) {
        WebElement selectSize = driver.findElement(By.id("group_1"));
        selectSize.click();
        selectSize.sendKeys(size);
    }

    @And("^selected quantity: (.*)$")
    public void selectQuantity(String quantity) {
        WebElement selectQuantity = driver.findElement(By.id("quantity_wanted"));
        selectQuantity.clear();
        selectQuantity.sendKeys(quantity);
    }

    @And("^add to Cart$")
    public void addToCart() {
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"));
        addToCartBtn.click();
    }
//
//    And button 'proceed to checkout' and confirmed address pressed
//    And selected 'shipping method'
//    And selected 'payment'
//    Then button 'order with an obligation to pay' pressed
//    And taken screenshot with order confirmation and payment amount
}
