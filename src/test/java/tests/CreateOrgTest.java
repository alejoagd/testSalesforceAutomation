package tests;

import base.BaseTest;
import net.bytebuddy.matcher.InheritedAnnotationMatcher;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TrialPage;

public class CreateOrgTest extends BaseTest {

    @Test
    public void registrationOrgTest (){

        HomePage homePage = new HomePage(driver);
        TrialPage trialPage = homePage.registrationOrg();

        //fill the personal data
        trialPage.fillRegistrationOrg("Alejandro","Gaviria","QA Automation Engineer","Betagd2",
                "3105293225","alejoagd@gmail.com");

        //Submit the form
        trialPage.submitForm();

    }
}
