package pl.coderslab.seleniumcourse.ZadWarsztatowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    @FindBy(name = "alias")
    private WebElement aliasInput;
    @FindBy(name = "address1")
    private WebElement addressInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "postcode")
    private WebElement postCodeInput;
    @FindBy (name = "id_country")
    private WebElement countryInput;
    @FindBy(name = "phone")
    private WebElement phoneInput;


    public AddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void filledFormAddress(UserData userData) {
        aliasInput.sendKeys(userData.getAlias());
        addressInput.sendKeys(userData.getAddress());
        cityInput.sendKeys(userData.getCity());
        postCodeInput.sendKeys(userData.getPostCode());
        countryInput.click();
        phoneInput.sendKeys(String.valueOf(userData.getPhone()));
    }

}
