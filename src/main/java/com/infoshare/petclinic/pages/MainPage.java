package com.infoshare.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@title='find owners']")
    private WebElement menuFindOwners;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void clickFindOwners(){
        menuFindOwners.click();
    }

}
