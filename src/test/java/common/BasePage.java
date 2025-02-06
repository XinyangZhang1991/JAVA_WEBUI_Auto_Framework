package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//通过继承的特性，把公用的方法写到这里
public class BasePage {
    private static Logger logger = Logger.getLogger(BasePage.class);

    public static WebElement waitElementVisible(RemoteWebDriver driver, long timeout, By by) {
        // JDK 18 or above： WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webElement;
    }


    public static WebElement waitElementClickable(RemoteWebDriver driver, long timeout, By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(by));
        return webElement;
    }

    public void click (RemoteWebDriver driver, By by) {

        WebElement element = driver.findElement(by);
       waitElementClickable(driver,8,by);
       highlightElement(driver, element);
       element.click();
       logger.info("the element has been clicked is " +by);
    }

    public void input (RemoteWebDriver driver, By by , String inputdata) {
        WebElement element = driver.findElement(by);
        waitElementVisible(driver,20,by);
        highlightElement(driver, element);
        element.sendKeys(inputdata);
        logger.info(inputdata +"is being input into the element:"+by);
    }

    public String getElementText(RemoteWebDriver driver, By by){
        WebElement element = driver.findElement(by);
        String text= waitElementVisible(driver,8,by).getText();
        logger.info("element acquired is"+by+"and the text in this element is"+text);
        return text;
    }

    public WebElement getElement (RemoteWebDriver driver, By by){
         WebElement element =waitElementVisible(driver,8,by);
        logger.info("element located is"+by);
        return element;
    }

    private void highlightElement(RemoteWebDriver driver, WebElement element) {
        // Use JavaScript to change the element's border temporarily
        String originalStyle = element.getAttribute("style");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Add a red border to the element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);

        // Optionally, wait a short time so the highlight is visible (e.g., 300ms)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
