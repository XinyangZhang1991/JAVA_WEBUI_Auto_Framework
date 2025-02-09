package testcases;


import pages.HomePage;
import pages.LoginPage;
import common.BaseTest;
import listener.TestResultListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.time.Duration.ofSeconds;
@Listeners(TestResultListener.class)
public class LoginTest_PO extends BaseTest {


    private static Logger logger = Logger.getLogger(LoginTest_PO.class);
   @Test
   @Parameters({"browserName"})
    public void login_success(@Optional("chrome")String browserName) throws InterruptedException {
       RemoteWebDriver driver = openBrowser("chrome");
       MaxBrowser(driver);
       openUrL(driver, "http://shop.lemonban.com:3344/");

       HomePage homePage = new HomePage(driver);
       homePage.clickLogin();

       //在创建的时候就要把参数传递过来了
       LoginPage loginPage = new LoginPage(driver);
       loginPage.login("lemonxinyang","Ginny_1212");

       WebElement webElement_welcomemessage = homePage.findwelcometips();
       Assert.assertNotNull(webElement_welcomemessage);

       Assert.assertEquals(homePage.getUsername(),"lemonxinyang");

       Thread.sleep(3000);
       driver.quit();
    }

    @Test(dataProvider="getLoginFailDatas")
    @Parameters({"browserName"})
    public void login_failed (String username,String password,String expected){
        RemoteWebDriver driver = openBrowser("chrome");
        MaxBrowser(driver);
        openUrL(driver, "http://shop.lemonban.com:3344/");

        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        //断言
        Assert.assertEquals(loginPage.Login_error_input_tips(),expected);
    }

    @DataProvider
    //Dataprovider 规定的必须使用 object[][] 类型的数据
    public Object[][] getLoginFailDatas(){
        Object[][] datas={{"java_auto","","请输入密码"},
                {"","123456","账号为4~16位字母、数字或下划线"},
                {"","","账号为4~16位字母、数字或下划线"}
        };
        return datas;
    }

    @Parameters({"browserName"})
    public void login_fail_error_password(@Optional("chrome")String browserName){
        RemoteWebDriver driver = openBrowser("chrome");
        MaxBrowser(driver);
        openUrL(driver,"http://shop.lemonban.com:3344/");

        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("java_auto","123");
        //断言
        Assert.assertEquals(loginPage.Login_error_tips(),"账号或密码不正确");
    }



}