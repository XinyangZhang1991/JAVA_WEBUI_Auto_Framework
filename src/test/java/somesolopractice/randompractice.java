package somesolopractice;


import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.TrolleyPage;
import common.BaseTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class randompractice extends BaseTest {

    //public RemoteWebDriver driver;
    @Test
//@Parameters("browserName"): Declares that this method expects a parameter named browserName.
//@Optional("chrome"): Provides a default value ("chrome") to be used if the parameter is not supplied.
    @Parameters({"browserName"})
    public void add_one_item(@Optional("chrome")String browserName) throws InterruptedException{


        driver = openBrowser(browserName);
        MaxBrowser(driver);
        openUrL(driver, "http://shop.lemonban.com:3344/");

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
        Thread.sleep(10000);
        String expectedPrice = productdetailpage.get_product_prices();
        productdetailpage.adding_into_trolley();
        //step 4: go back to the homepage click the trolley
        homePage.click_trolley_icon();

       /* //start doing assertion:
        //Assertion 1 :

        String actualproductname= trolleyPage.get_product_name();
        Assert.assertEquals(actualproductname,product_name);
        //Assertion 2 :
        String actualproductprice= trolleyPage.get_product_price();
        Assert.assertEquals(actualproductprice,expectedPrice);
        //Assertion 3:
        String actualproductnumber= trolleyPage.get_product_number();
        Assert.assertEquals(actualproductnumber,1);
        //Since delete_all is an instance method of the TrolleyPage class
        // you should invoke it on the trolleyPage object:*/
        System.out.println(expectedPrice);
        TrolleyPage trolleyPage = new TrolleyPage(driver);

        trolleyPage.delete_all();
        Thread.sleep(2000);
        driver.quit();


    }

}
