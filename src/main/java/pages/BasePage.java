package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    //Constructor that receives the driver
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.driver.get("https://test.salesforce.com/");
        this.driver.manage().window().maximize();
    }
    public BasePage(){

    }
}
