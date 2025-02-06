package testcases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.TrolleyPage;
import common.BaseTest;
import listener.TestResultListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(TestResultListener.class)
public class Add_Items_to_trolley extends BaseTest {


    //public RemoteWebDriver driver;
@Test
//@Parameters("browserName"): Declares that this method expects a parameter named browserName.
//@Optional("chrome"): Provides a default value ("chrome") to be used if the parameter is not supplied.
@Parameters({"browserName"})
    public void add_one_item(@Optional("firefox")String browserName) throws InterruptedException {


    driver = openBrowser(browserName);
    MaxBrowser(driver);
    openUrL(driver, "http://shop.lemonban.com:3344/");

    //step 1 : login first
    HomePage homePage = new HomePage(driver);
    homePage.clickLogin();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("lemonxinyang", "Ginny_1212");
    Thread.sleep(3000);
    //step 2: select product
    String product_name = "真皮圆筒包";
    //homePage.input_into_searchbar(product_name);

    homePage.click_selected_product(product_name);
    //step 3:adding into the trolley in the product detail page
    ProductDetailPage productdetailpage = new ProductDetailPage(driver);
    Thread.sleep(10000);
    String expectedPrice = productdetailpage.get_product_prices();
    productdetailpage.adding_into_trolley();
    //step 4: go back to the homepage click the trolley
    homePage.click_trolley_icon();
    //start doing assertion:
    //Assertion 1 :

    SoftAssert softAssert = new SoftAssert();
    try {
        TrolleyPage trolleyPage = new TrolleyPage(driver);
        String actualproductname = trolleyPage.get_product_name();
        softAssert.assertEquals(actualproductname, product_name);
        //Assertion 2 :
        String actualproductprice = trolleyPage.get_product_price();
        softAssert.assertEquals(actualproductprice, expectedPrice);
        //Assertion 3:
        String actualproductnumber = trolleyPage.get_product_number();
        softAssert.assertEquals(actualproductnumber.trim(), "1");
        System.out.println(expectedPrice.getClass());
        System.out.println(actualproductprice.getClass());
        softAssert.assertAll();
        Thread.sleep(10000);
    } finally {
        //Since delete_all is an instance method of the TrolleyPage class
        // you should invoke it on the trolleyPage object:
        TrolleyPage trolleyPage = new TrolleyPage(driver);
        trolleyPage.delete_all();
        Thread.sleep(10000);
        //Modify your finally block to only quit the driver after confirming that all listener actions (e.g., screenshot capture) are complete.
       if (driver != null) {
           driver.quit();
           Logger logger = null;
           logger.info("the browser is quited");
       }

    }

}

}
