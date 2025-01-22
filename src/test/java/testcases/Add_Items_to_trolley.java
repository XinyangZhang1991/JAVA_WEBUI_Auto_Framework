package testcases;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.TrolleyPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Items_to_trolley {

@Test
    public void add_one_item() throws InterruptedException{
        RemoteWebDriver driver = openBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("http://shop.lemonban.com:3344/");
        //step 1 : login first
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lemonxinyang","Ginny_1212");
            Thread.sleep(3000);
        //step 2: select product
        String product_name ="真皮圆筒包";
        homePage.click_selected_product(product_name);
        //step 3:adding into the trolley in the product detail page
        ProductDetailPage productdetailpage = new ProductDetailPage(driver);
        String expectedPrice = productdetailpage.get_product_prices();
        productdetailpage.adding_into_trolley();
        //step 4: go back to the homepage click the trolley
        homePage.click_trolley_icon();

        //start doing assertion:
        //Assertion 1 :
        TrolleyPage trolleyPage = new TrolleyPage(driver);
        String actualproductname= trolleyPage.get_product_name();
        Assert.assertEquals(actualproductname,product_name);
        //Assertion 2 :
        String actualproductprice= trolleyPage.get_product_price();
        Assert.assertEquals(actualproductprice,expectedPrice);
        //Assertion 3:
        String actualproductnumber= trolleyPage.get_product_number();
        Assert.assertEquals(actualproductnumber,1);

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

}
