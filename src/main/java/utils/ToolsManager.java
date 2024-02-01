package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class ToolsManager {
    private WebDriver driver;


    public static void scrollDown(WebDriver driver,String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+value+")");
    }


    public static void zoomOut(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
    }

    // Método para aumentar el zoom (aumentar el tamaño de la página)
    public static void zoomIn(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='120%'");
    }

    public static void sleep(String mili) {
        try {
            Thread.sleep(Long.parseLong(mili));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
