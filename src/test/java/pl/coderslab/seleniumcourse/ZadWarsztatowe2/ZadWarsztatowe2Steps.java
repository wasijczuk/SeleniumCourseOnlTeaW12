package pl.coderslab.seleniumcourse.ZadWarsztatowe2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

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

    @And("^add to 'Cart'$")
    public void addToCart() {
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"));
        addToCartBtn.click();
    }

    @And("^button 'proceed to checkout'$")
    public void checkoutAndAdress() {
        WebElement checkoutBtn = driver.findElement(By.className("btn btn-primary"));
        checkoutBtn.click();
        WebElement finalCheckoutBtn = driver.findElement(By.className("btn btn-primary"));
        finalCheckoutBtn.click();
    }

    @And("^confirmed address pressed$")
    public void addressCorfirmed() {
        WebElement addressCorfirmedInput = driver.findElement(By.name("id_address_delivery"));
        addressCorfirmedInput.click();
        WebElement continueBtn = driver.findElement(By.name("confirm-addresses"));
        continueBtn.click();
    }

    @And("^selected 'shipping method'$")
    public void shippingMethod() {
        WebElement shippingMethodInput = driver.findElement(By.name("delivery_option[19478]"));
        shippingMethodInput.click();
        WebElement shippingMethodBtn = driver.findElement(By.name("confirmDeliveryOption"));
        shippingMethodBtn.click();
    }

    @And("^selected 'payment'$")
    public void payment() {
        WebElement paymentInput = driver.findElement(By.id("payment-option-1"));
        paymentInput.click();
        WebElement checkboxInput = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        checkboxInput.click();

    }

    @Then("^button 'order with an obligation to pay' pressed$")
    public void orderBtn() {
        WebElement orderBtn = driver.findElement(By.className("btn btn-primary center-block"));
        orderBtn.click();
    }

    @And("^taken screenshot with order confirmation and payment amount$")
    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "order-confirmation-and-payment" + currentDateTime + ".png"));
    }

}