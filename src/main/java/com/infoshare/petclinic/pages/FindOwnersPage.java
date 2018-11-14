package com.infoshare.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindOwnersPage extends BasePage{

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//a[contains(text(),'Add')]")
    private WebElement buttonAddOwner;

    @FindBy(xpath = "//button[contains(text(),'Find')]")
    private WebElement buttonFindOwner;

    public FindOwnersPage(WebDriver driver){
        super(driver);
    }

    public void searchOwnerByName(String ownersName){
//        wait.until(ExpectedConditions.visibilityOf(inputLastName));
        inputLastName.sendKeys(ownersName);
        buttonFindOwner.click();
    }

    public void clickAddOwner(){
        buttonAddOwner.click();
    }

}
