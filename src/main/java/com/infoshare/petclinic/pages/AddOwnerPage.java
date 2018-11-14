package com.infoshare.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOwnerPage extends BasePage {

    @FindBy(id = "firstName")
    WebElement inputFirstName;

    @FindBy(id = "lastName")
    WebElement inputLastName;

    @FindBy(id = "address")
    WebElement inputAddress;

    @FindBy(id = "city")
    WebElement inputCity;

    @FindBy(id = "telephone")
    WebElement inputTelephone;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement buttonAddOwner;

    public AddOwnerPage(WebDriver driver){
        super(driver);
    }

    public void addNewOwnerFullDetails(String firstName, String lastName, String address, String city, String phone){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
        inputTelephone.sendKeys(phone);
        buttonAddOwner.click();
    }
}
