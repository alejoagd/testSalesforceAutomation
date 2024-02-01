package pages;


import org.openqa.selenium.WebDriver;
import utils.ToolsManager;

public class HomePage extends BasePage{
    public HomePage(){

    }

    public HomePage (WebDriver driver){
    super(driver);
}

    //Navigation Methods

    public TrialPage registrationOrg (){
        ToolsManager.sleep("1000");
        driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=cta-li-promo-147&_gl=1*hb4m1w*_ga*MjA4MDQ4NDE2MC4xNzA2NjMzNTEy*_ga_S6WMKB0ZK3*MTcwNjcxMDUwMS42LjEuMTcwNjcxMjg1MC4wLjAuMA..");
        return new TrialPage(driver);
    };


    public AccountsPage loginOrg(){
        driver.get("https://business-velocity-6267.my.salesforce.com/");
        return new AccountsPage(driver);
    };

}
