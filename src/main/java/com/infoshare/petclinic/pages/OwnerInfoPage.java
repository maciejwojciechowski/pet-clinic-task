package com.infoshare.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OwnerInfoPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Owner Information']")
    private WebElement textOwnerInfo;

    @FindBy(xpath = "//th[text()='Name']/following-sibling::td")
    List<WebElement> textOwnerName;


    public OwnerInfoPage(WebDriver driver){
        super(driver);
    }

    public boolean verifyOwnerInfoIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(textOwnerInfo));
        return textOwnerInfo.isDisplayed();
    }
}
