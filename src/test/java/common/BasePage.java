package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//通过继承的特性，把公用的方法写到这里
public class BasePage {

    public static WebElement waitElementVisible(RemoteWebDriver driver, long timeout, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webElement;
    }


    public static WebElement waitElementClickable(RemoteWebDriver driver, long timeout, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(by));
        return webElement;
    }


}
