package com.infoshare.petclinic.ui;

import com.infoshare.petclinic.pages.MainPage;
import com.infoshare.petclinic.pages.OwnersPage;
import org.junit.Before;
import org.junit.Test;

public class OwnerTest extends BaseTest {

    private MainPage mainPage;
    private OwnersPage ownersPage;

    @Before
    public void openOwnerPage(){
        mainPage = new MainPage(driver);
        mainPage.clickFindOwners();
    }

    @Test
    public void verifyOwnersPage(){
        ownersPage = new OwnersPage(driver);
        ownersPage.enterOwnersName("Maciej");

    }
}
