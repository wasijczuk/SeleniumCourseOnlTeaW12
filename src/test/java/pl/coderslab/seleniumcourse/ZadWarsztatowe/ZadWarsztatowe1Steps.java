package pl.coderslab.seleniumcourse.ZadWarsztatowe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZadWarsztatowe1Steps {
    private WebDriver driver;
    private AddressPage AddressPage;


    @Given("^Web page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(url);
    }


    @When("^button 'Sign in' pressed$")
    public void singInBtn() {
        WebElement inputBtn = driver.findElement(By.id("_desktop_user_info"));
        inputBtn.click();
    }

    @And("^logged in to account$")
    public void logIn() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("ania123@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwerty123");

        WebElement logIn = driver.findElement(By.id("submit-login"));
        logIn.click();
    }

    @And("^link 'addresses' pressed$")
    public void pressAddresses() {
        WebElement adresses = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span/i"));
        adresses.click();
    }


    @And("^link 'Create new address' pressed$")
    public void pressCreateNewAddress() {
        WebElement createNewAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        createNewAddress.click();
    }

    @Then("^Form filled with data: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void filledFormAddress(String alias, String address, String city, String postCode, String country, String phone) {
        UserData userData = new UserData()
                .setAlias(alias)
                .setAddress(address)
                .setCity(city)
                .setPostCode(postCode)
                .setCountry(country)
                .setPhone(phone);

        AddressPage addressPage = new AddressPage(driver);
        assertEquals(alias, userData.getAlias());
        assertEquals(address, userData.getAddress());
        assertEquals(city, userData.getCity());
        assertEquals(postCode, userData.getPostCode());
        assertEquals(country, userData.getCountry());
        assertEquals(phone, userData.getPhone());
        addressPage.filledFormAddress(userData);
    }

    @And("^button 'save' clicked$")
    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveBtn.click();
    }

    @And("^confirmed new address$")
    public void confirmedNewAddress() {
        WebElement successMessage = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/aside/div/article/ul/li"));
        String successMessageText = successMessage.getText();
        assertEquals("Address successfully added!", successMessageText);
    }

    @And("^deleted new address$")
    public void deletedNewAddress() {
        WebElement deletedNewAddressBtn = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span"));
        deletedNewAddressBtn.click();
    }

    @And("^confirmed address deleted$")
    public void confirmedAddressDeleted() {
        WebElement successMessage2 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/aside/div/article/ul/li"));
        String successMessageText = successMessage2.getText();
        assertEquals("Address successfully deleted!", successMessageText);
    }
}
