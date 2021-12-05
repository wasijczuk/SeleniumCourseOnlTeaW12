package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByName {
    WebDriver driver;

    @Test
    public void shouldFindByName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElement searchNowBtn = driver.findElement(By.id("search_room_submit"));
        WebElement enterYourEmailInput = driver.findElement(By.id("newsletter-input"));
        hotelLocationInput.sendKeys("Warsaw");
        enterYourEmailInput.sendKeys("test@test.com");

    }


    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();

    }

//    @AfterEach
//    public void afterEach() {
//        this.driver.quit();
//    }

}
