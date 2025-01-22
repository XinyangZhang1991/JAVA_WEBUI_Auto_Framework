package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
       waitElementClickable(driver,8,by).click();
       logger.info("the element has been clicked is " +by);
    }

    public void input (RemoteWebDriver driver, By by , String inputdata) {
        waitElementVisible(driver,8,by).sendKeys(inputdata);
        logger.info(inputdata +"is being input into the element:"+by);
    }

    public String getElementText(RemoteWebDriver driver, By by){
        String text= waitElementVisible(driver,8,by).getText();
        logger.info("element acquried is"+by+"and the text in this element is"+text);
        return text;
    }

    public WebElement getElement (RemoteWebDriver driver, By by){
         WebElement element =waitElementVisible(driver,8,by);
        logger.info("element located is"+by);
        return element;
    }



}
