package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;

public class EditAccountTest extends BaseTest {


    @Test
    public void editAccountTest(){
        HomePage homePage = new HomePage(driver);
        AccountsPage accountsPage = homePage.loginOrg();

        //login ORG
        accountsPage.loginCredentials("alejoagd-aap0@force.com","**Redroja12");
        //Search and edit Account
        accountsPage.editAccounts("Alejandro Gavi");

        //Save Edition and Capture Successful message
        accountsPage.saveAccount();

    }

}
