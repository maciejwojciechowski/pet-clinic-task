package com.infoshare.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sun.security.util.PropertyExpander;

public class OwnerInfoPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Owner Information']")
    private WebElement someText;

    public OwnerInfoPage(WebDriver driver){
        super(driver);
    }

    public boolean verifyTextIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(someText));
        return someText.isDisplayed();
    }
}
