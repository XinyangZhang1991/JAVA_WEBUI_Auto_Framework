package common;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import testcases.LoginTest_PO;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private static Logger logger = Logger.getLogger(BaseTest.class);
    public RemoteWebDriver driver;


    public static RemoteWebDriver openBrowser(String browserName) {

        if ("chrome".equalsIgnoreCase(browserName)) {
            //open chrome
            System.setProperty("webdriver.chrome.driver", "src/test/Resources/chromedriver131.exe");
            logger.info("Opened the Chrome Browser");
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            // open firefox
            System.setProperty("webdriver.gecko.driver", "src/test/Resources/geckodriverwin64.exe");
            logger.info("Opened the firefox Browser");
            return new FirefoxDriver();
        } else {
            logger.error("check the browser your input ");
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }


    }

    public void MaxBrowser (RemoteWebDriver driver ){
        driver.manage().window().maximize();
        logger.info("Browser is maximized");

    }


    public void openUrL (RemoteWebDriver driver, String url) {

        driver.get(url);
        logger.info("website URL is http://shop.lemonban.com:3344/ ");
    }

    public void takeScreenshot(String path) {
        File file1 = driver.getScreenshotAs(OutputType.FILE);
        File file2 = new File(path);
        try {
            FileUtils.copyFile(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
