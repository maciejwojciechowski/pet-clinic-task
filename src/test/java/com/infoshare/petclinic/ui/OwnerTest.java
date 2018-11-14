package com.infoshare.petclinic.ui;

import com.infoshare.petclinic.pages.AddOwnerPage;
import com.infoshare.petclinic.pages.MainPage;
import com.infoshare.petclinic.pages.FindOwnersPage;
import com.infoshare.petclinic.pages.OwnerInfoPage;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "src/test/resources/ownerslist.xml" }, loaderType = LoaderType.XML, writeData = false)
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
    public void addNewOwnerTest(@Param(name = "firstName") String firstName,
                                    @Param(name = "lastName") String lastName,
                                    @Param(name = "address") String address,
                                    @Param(name = "city") String city,
                                    @Param(name = "phoneNumber") String phoneNumber) {
        findOwnersPage.clickAddOwner();
        addOwnerPage.addNewOwnerFullDetails(firstName, lastName, address, city, phoneNumber);

        assertThat(ownerInfoPage.verifyTextIsDisplayed())
                .isTrue();
    }


        @Test
    public void verifyIfOwnerExistsTest(@Param(name = "firstName") String firstName,
                                    @Param(name = "lastName") String lastName,
                                    @Param(name = "address") String address,
                                    @Param(name = "city") String city,
                                    @Param(name = "phoneNumber") String phoneNumber) {

        findOwnersPage.searchOwnerByName(lastName);

    }
}
