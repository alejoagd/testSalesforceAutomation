package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setUp (){
        //Configuration del Driver
        System.setProperty("webdriver.chrome.driver", "C:\\Maven_project\\chromedriver-win64 121\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        //Close the browser each execution
        if(driver !=null){
            driver.quit();
        }
    }


}
