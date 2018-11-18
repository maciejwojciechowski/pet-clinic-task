package com.infoshare.petclinic.ui;

import com.infoshare.petclinic.pages.AddOwnerPage;
import com.infoshare.petclinic.pages.MainPage;
import com.infoshare.petclinic.pages.FindOwnersPage;
import com.infoshare.petclinic.pages.OwnerInfoPage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class OwnerTest extends BaseTest {

    private MainPage mainPage;
    private FindOwnersPage findOwnersPage;
    private AddOwnerPage addOwnerPage;
    private OwnerInfoPage ownerInfoPage;

    @Before
    public void openOwnerPage(){
        mainPage = new MainPage(driver);
        findOwnersPage = new FindOwnersPage(driver);
        addOwnerPage = new AddOwnerPage(driver);
        ownerInfoPage = new OwnerInfoPage(driver);
        mainPage.clickFindOwners();
    }

    @Test
    @UseDataProvider("ownerList")
    public void addNewOwnerTest(String firstName, String lastName, String address, String city, String phoneNumber) {
        findOwnersPage.clickAddOwner();
        addOwnerPage.addNewOwnerFullDetails(firstName, lastName, address, city, phoneNumber);

        assertThat(ownerInfoPage.verifyOwnerInfoIsDisplayed());
    }

    @Test
    @UseDataProvider("ownerList")
    public void searchExistingOwner(String firstName, String lastName, String address, String city, String phoneNumber){
        findOwnersPage.searchOwnerByName(lastName);

        assertThat(ownerInfoPage.verifyOwnerInfoIsDisplayed());
    }

    @Test
    public void searchNonExistingOwner(){
        findOwnersPage.searchOwnerByName("nonExistingName");
        assertThat(findOwnersPage.verifyNotFoundText());
    }

    @DataProvider
    public static Object[][] ownerList() {
        return new String[][]{
                new String[]{"Jan", "Nowak", "ul. Grunwaldzka 452", "Gdansk", "877456123"},
                new String[]{"John", "Snow", "ul. Pomorska 222", "Gdansk", "667456789"},
                new String[]{"Michal", "Wozniak", "ul. Piastowska 3","Gdansk", "669456123"}};
    }
}
