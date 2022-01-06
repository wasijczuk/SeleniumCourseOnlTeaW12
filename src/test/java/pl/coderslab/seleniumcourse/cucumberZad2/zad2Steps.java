package pl.coderslab.seleniumcourse.cucumberZad2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class zad2Steps {
    private WebDriver driver;

    @Given("^Web page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^button 'Sign in' pressed$")
    public void singInBtn() {
        WebElement inputBtn = driver.findElement(By.cssSelector("hide_xs"));
        inputBtn.click();
    }

    @And("^unregistered email typed$")
    public void emaitTyped() {
        WebElement emaitTyped = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emaitTyped.clear();
        emaitTyped.sendKeys(randomEmail);
    }
    @And("^button 'Create an account' pressed$")
    public void createAnAccount(){
        WebElement createAnAccountBtn = driver.findElement(By.className("icon-user left"));
        createAnAccountBtn.click();
    }
//    And personal information typed
//    And button 'Register' pressed
//    Then 'Your account has been created' on page https://hotel-testlab.coderslab.pl/en/my-account opened
}