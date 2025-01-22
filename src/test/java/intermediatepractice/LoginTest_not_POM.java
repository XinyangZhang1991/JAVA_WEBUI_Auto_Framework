package intermediatepractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class LoginTest_not_POM {

   @Test
    public void login_success() throws InterruptedException {
        RemoteWebDriver driver = openBrowser("chrome");
        driver.get("http://shop.lemonban.com:3344/");
        waitElementClickable(driver, 8, By.linkText("登录")).click();
        waitElementVisible(driver, 6, xpath("//input[@placeholder='请输入手机号/用户名']")).sendKeys("lemonxinyang");
        waitElementVisible(driver, 7, xpath("//input[@placeholder='请输入密码']")).sendKeys("Ginny_1212");
        waitElementClickable(driver, 8, xpath("//a[@class='login-button']")).click();

        WebElement webElement_welcomemessage = waitElementVisible(driver, 8, xpath("//span[text()='欢迎来到柠檬班']"));
        Assert.assertNotNull(webElement_welcomemessage);

       WebElement webElement_username = waitElementVisible(driver, 8, xpath("//a[@class='link-name']"));
       Assert.assertEquals(webElement_username.getText(),"lemonxinyang");

       Thread.sleep(3000);
       driver.quit();
    }


    public static RemoteWebDriver openBrowser(String browserName) {

        if ("chrome".equalsIgnoreCase(browserName)) {
            //open chrome
            System.setProperty("webdriver.chrome.driver", "src/test/Resources/chromedriver131.exe");
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            // open firefox
            System.setProperty("webdriver.gecko.driver", "src/test/Resources/geckodriverwin64.exe");
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);

        }


    }

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