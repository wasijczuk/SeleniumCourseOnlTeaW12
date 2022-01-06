package pl.coderslab.seleniumcourse.cucumber;

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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QwantSearchSteps {
    private WebDriver driver;

    @Given("^Web page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^Search phrase \"(.*)\" entered in search input box$")
    public void enterSearchPhrase(String searchPhrase) {
        WebElement inputBox = driver.findElement(By.name("q"));
        inputBox.clear();
        inputBox.sendKeys(searchPhrase);
    }

    @And("^key enter pressed$")
    public void pressEnter() {
        WebElement inputBox = driver.findElement(By.name("q"));
        inputBox.sendKeys(Keys.ENTER);
    }

    @Then("^First (.*) search results titles contain phrase \"(.*)\"$")
    public void checkSearchResults(int count, String searchPhrase) {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.WebResult-module__container___18c35 a"));
        for (int i = 0; i < count; i++) {
            assertTrue(searchResults.get(i).getText().contains(searchPhrase));
        }
    }
}
