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

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ZadWarsztatowe2Steps {
    private WebDriver driver;

    @Given("^Web page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        WebElement selectSweaterBtn = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img"));
        selectSweaterBtn.click();
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
        WebElement addToCardBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]"));
        addToCardBtn.click();
    }

    @And("^button 'proceed to checkout'$")
    public void checkout() {
        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
        checkoutBtn.click();

        WebElement finalCheckoutBtn = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
        finalCheckoutBtn.click();
    }

    @And("^confirmed address pressed$")
    public void addressCorfirmed() {
        WebElement addressInput = driver.findElement(By.xpath("//span[@class=\"custom-radio\"]"));
        addressInput.click();
        WebElement continueBtn = driver.findElement(By.name("confirm-addresses"));
        continueBtn.click();
    }

    @And("^selected 'shipping method'$")
    public void shippingMethod() {
        WebElement shippingMethodInput = driver.findElement(By.xpath("//span[@class=\"custom-radio float-xs-left\"]"));
        shippingMethodInput.click();
        WebElement shippingMethodBtn = driver.findElement(By.xpath("//button[@name=\"confirmDeliveryOption\"]"));
        shippingMethodBtn.click();
    }

    @And("^selected 'payment'$")
    public void payment() {
        WebElement paymentInput = driver.findElement(By.xpath("//input[@id=\"payment-option-1\"]"));
        paymentInput.click();
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        checkboxInput.click();
    }

    @Then("^button 'order with an obligation to pay' pressed$")
    public void orderBtn() {
        WebElement orderBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary center-block\"]"));
        orderBtn.click();
    }

    @And("^taken screenshot with order confirmation and payment amount$")
    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "order-confirmation-and-payment" + currentDateTime + ".png"));
    }

    @And("^opened 'order history and details'$")
    public void orderHistoryStatus() {
        WebElement yourAccountBtn = driver.findElement(By.xpath("//span[@class=\"hidden-sm-down\"]"));
        yourAccountBtn.click();
        WebElement orderHistoryAndDetails = driver.findElement(By.xpath("//a[@id=\"history-link\"]"));
        orderHistoryAndDetails.click();
    }

    @And("^confirmed order with 'Awaiting check payment'$")
    public void confirmedOrder() {
        WebElement confirmedOrder = driver.findElement(By.xpath("//tr[1]/td[4]/span"));
        String confirmedOrderText = confirmedOrder.getText();
        assertEquals("Awaiting check payment", confirmedOrderText);
    }

    @And("^confirmed price$")
    public void confirmedPrice() {
        WebElement confirmedPrice = driver.findElement(By.xpath("//tr[1]/td[2]"));
        String confirmedOrderText = confirmedPrice.getText();
        assertEquals("€143.60", confirmedOrderText);
    }
}