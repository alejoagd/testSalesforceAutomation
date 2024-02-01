package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ToolsManager;

import java.time.Duration;


public class TrialPage extends HomePage{
    public TrialPage(){

    }
    private WebDriver driver;

    //Selectors page test salesforce
    private By Cookies = By.id("onetrust-accept-btn-handler");
    private By Name =By.name("UserFirstName");
    private By Lastname =By.name("UserLastName");
    private By Title =By.name("UserTitle");
    private By Next=By.cssSelector(".btn-container:nth-child(2) > .btn");
    private By Next2=By.cssSelector(".btn-primary > span");
    private By select_employees =By.name("CompanyEmployees");
    private By company_name =By.name("CompanyName");
    private By country =By.name("CompanyCountry");
    private By cellphone =By.name("UserPhone");
    private By Email =By.name("UserEmail");
    private By terms_conditions =By.cssSelector(".msaCheckbox .checkbox-ui");
    private By Notifications =By.cssSelector(".show > .field > .checkbox-ui");
    private By submit =By.cssSelector(".submit");
    private By Onboarding1 =By.xpath("//div[@id='modal-content-5']/slot/runtime_learning_essentials_welcome-onboarding-question/fieldset/div/div/div[4]/label/span/span/lightning-formatted-text");
    private By Onboarding_next1 =By.xpath("//button[contains(.,'Siguiente')]");
    private By Onboarding2 =By.xpath("//div[@id='modal-content-5']/slot/runtime_learning_essentials_welcome-onboarding-question/fieldset/div/div/div[5]/label/span");
    private By Onboarding_next2 =By.xpath("//button[contains(.,'Enviar')]");
    private By Button_final_onb =By.xpath("//button[contains(.,'Llévenme a Salesforce')]");
    private By user= By.id("username");
    private By password= By.id("password");

    public TrialPage (WebDriver driver){
        this.driver =driver;
    }

    //Method for fill registration org
    public void fillRegistrationOrg(String name ,String lastname,String title,String Company,String phone, String email){

        driver.findElement(Cookies).click();
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Lastname).sendKeys(lastname);
        driver.findElement(Title).sendKeys(title);
        driver.findElement(Next).click();

        //Dropdown list employes
        WebElement list_employees = driver.findElement(select_employees);
        Select select_employees = new Select(list_employees);
        select_employees.selectByValue("10");

        driver.findElement(company_name).sendKeys(Company);

        //Dropdown list country
        WebElement list_country = driver.findElement(country);
        Select select_country = new Select(list_country);
        select_country.selectByValue("CO");

        driver.findElement(Next2).click();
        driver.findElement(cellphone).sendKeys(phone);
        driver.findElement(Email).sendKeys(email);
        ToolsManager.sleep("1000");
        driver.findElement(terms_conditions).click();
        driver.findElement(Notifications).click();

    }

    //Method for submit form
    public void submitForm(){

        driver.findElement(submit).click();
        ToolsManager.sleep("40000");

        //Onboarding
        ToolsManager.scrollDown(driver,"300");

        int timeMaxWait = 10;

        try {
            // Wait until element is active on the DOM within max time set
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeMaxWait));
            WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(Onboarding1));

            if (elemento.isDisplayed()) {
                driver.findElement(Onboarding1).click();
                driver.findElement(Onboarding_next1).click();
                ToolsManager.scrollDown(driver,"300");
                driver.findElement(Onboarding2).click();
                driver.findElement(Onboarding_next2).click();
                driver.findElement(Button_final_onb).click();
            } else {

            }
        } catch (TimeoutException e) {
            // Control exception if element no upload
            System.out.println("The element dont upload on the max time set .");
        } finally {
            System.out.println("Validation Final");
        }


    }

    //Method for activate account in gmail , this function not used because Gmail have restrictions to Controller ChromeDriver
    /*public void ReadEmailGmail(){
        ToolsManager.sleep("5000");

        // Open Gmail in new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://mail.google.com");

        // Login in Gmail
        WebElement emailInput = driver.findElement(user);
        emailInput.sendKeys("alejoagd@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        // Read first email in Inbox
        WebElement primerCorreo = driver.findElement(By.xpath("//div[@class='y6']"));
        System.out.println("Asunto del primer correo: " + primerCorreo.getText());
    }*/

}
