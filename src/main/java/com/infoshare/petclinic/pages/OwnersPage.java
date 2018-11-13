package com.infoshare.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OwnersPage extends BasePage{

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;

    public OwnersPage(WebDriver driver){
        super(driver);
    }

    public void enterOwnersName(String ownersName){
//        wait.until(ExpectedConditions.visibilityOf(inputLastName));
        inputLastName.sendKeys(ownersName);
    }

}
