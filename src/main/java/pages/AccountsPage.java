package pages;

import org.openqa.selenium.*;
import utils.ToolsManager;



public class AccountsPage extends HomePage{
    private WebDriver driver;



    private By account_new = By.cssSelector(".slds-button:nth-child(1) > .forceActionLink > div");
    private By Name_acc =By.xpath("//records-record-layout-base-input/lightning-input/lightning-primitive-input-simple/div/div/input");
    private By Website =By.xpath("//slot/lightning-input/lightning-primitive-input-simple/div/div/input");
    private By Type =By.xpath("//button[contains(.,'--Ninguno--')]");
    private By Description=By.xpath("//textarea");
    private By SubmitAccount = By.xpath("//button[@name='SaveEdit']");
    private By User = By.name("username");
    private By Pass = By.name("pw");
    private By login = By.name("Login");
    private By SearchAccount = By.xpath("//lightning-primitive-input-simple/div/div/input");
    private By Edit = By.xpath("//button[@name='Edit']");


    public AccountsPage(WebDriver driver){
        this.driver =driver;

    }


    public void loginCredentials(String username ,String password){
        driver.findElement(User).sendKeys(username);
        driver.findElement(Pass).sendKeys(password);
        driver.findElement(login).click();
    }

    public void createNewAccount(String name_acc , String website, String descripcion1) {
        ToolsManager.sleep("6000");
        driver.get("https://business-velocity-6267.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        ToolsManager.sleep("5000");
        driver.findElement(account_new).click();
        ToolsManager.sleep("3000");
        driver.findElement(Name_acc).sendKeys(name_acc);
        driver.findElement(Website).sendKeys(website);
        driver.findElement(Type).click();
        driver.findElement(Description).sendKeys(descripcion1);

    }
    public void saveAccount(){
        driver.findElement(SubmitAccount).click();
        ToolsManager.sleep("4000");

        String roleBuscado = "alertdialog";
        By locator =By.cssSelector("[role='"+ roleBuscado + "']");

        try {
            WebElement mensajeExito = driver.findElement(locator);
            System.out.println("Success Message: " + mensajeExito.getText());
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            System.out.println("The succes element is not attach on the DOM ");
        }
    }

    public  void editAccounts(String nameAccount){
        ToolsManager.sleep("3000");
        driver.get("https://business-velocity-6267.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        ToolsManager.sleep("5000");

        driver.findElement(SearchAccount).sendKeys(nameAccount);
        ToolsManager.sleep("2000");
        driver.findElement(SearchAccount).sendKeys(Keys.ENTER);
        ToolsManager.sleep("3000");

        String linkTextBuscado = ""+nameAccount+"";
        System.out.println("Search Link"+ linkTextBuscado);
        By locator =By.linkText(linkTextBuscado);

        try {
            WebElement accountFound = driver.findElement(locator);
            accountFound.click();
            System.out.println("Account Found");
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            System.out.println("Account not Found");
        }

        ToolsManager.sleep("10000");
        driver.findElement(Edit).click();
        ToolsManager.sleep("3000");
        driver.findElement(Name_acc).sendKeys("Edited account");

    }



}
