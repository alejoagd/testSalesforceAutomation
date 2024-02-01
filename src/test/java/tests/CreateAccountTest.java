package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;
import pages.TrialPage;

public class CreateAccountTest extends BaseTest {

    @Test
    public void registrationAccountTest (){

        HomePage homePage = new HomePage(driver);
        AccountsPage accountsPage = homePage.loginOrg();

        //login ORG
        accountsPage.loginCredentials("alejoagd-aap0@force.com","**Redroja12");

        //fill data account
        accountsPage.createNewAccount("Alejandro Gavi","Betagd","Cuenta importante");

        //Submit the form and capture successful message
        accountsPage.saveAccount();

    }



}
