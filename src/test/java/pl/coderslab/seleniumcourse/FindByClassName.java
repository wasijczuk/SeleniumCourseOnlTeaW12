package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class FindByClassName {
    WebDriver driver;

    @Test
    public void shouldFindByClassName() {
        driver.get("https://hotel-testlab.coderslab.pl//en/");
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emailInput.clear();
        emailInput.sendKeys(randomEmail);
        WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
        createAccountBtn.click();

        WebElement radioMr = driver.findElement(By.cssSelector("input#id_gender1"));
        radioMr.click();
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        if (!firstNameInput.isDisplayed() || !firstNameInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        firstNameInput.sendKeys("zofia");

        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        if (!lastNameInput.isDisplayed() || !lastNameInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        lastNameInput.sendKeys("kowalska");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        if (!passwordInput.isDisplayed() || !passwordInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        passwordInput.sendKeys("password");

        WebElement submit = driver.findElement(By.id("submitAccount"));
        submit.click();

//        WebElement personalInformationBtn = driver.findElement(By.cssSelector("btn.My personal information"));



    }


    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

//    @AfterEach
//    public void afterEach() {
//        this.driver.quit();
//    }

}