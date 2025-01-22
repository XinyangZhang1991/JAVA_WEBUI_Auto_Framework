package Pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BasePage {

    private By username_input = By.xpath("//input[@placeholder='请输入手机号/用户名']");
    private By password_input = By.xpath("//input[@placeholder='请输入密码']");
    private By login_button =By.xpath("//a[@class='login-button']");
    private RemoteWebDriver driver;
    //登陆输入框错误提示
    private By login_error_input_tips=By.xpath("//div[@class='error' and @style='']");
    //登陆账号/密码错误的提示
    private By login_error_tips = By.xpath("//p[@class='el-message__content']");

    //通过有参构造把初始化的参数传递过来
    public LoginPage (RemoteWebDriver driver){
        this.driver =driver;
        ;
    }

    public void login( String username, String password){
//        waitElementVisible(driver, 8,username_input).sendKeys(username);
//        waitElementVisible(driver,8,password_input).sendKeys (password);
//        waitElementVisible(driver,8,login_button).click();
        input(driver,username_input,username);
        input(driver,password_input,password);
        click(driver,login_button);

    }
    //登陆输入框错误提示
    public String Login_error_input_tips(){

//        return waitElementVisible(driver,8,login_error_input_tips).getText();
        return getElementText(driver,login_error_input_tips);
    }

    //登陆账号/密码错误的提示
    public String Login_error_tips(){
//        String errormessage = waitElementVisible(driver,8,login_error_tips).getText();
//        return errormessage;
        return getElementText(driver,login_error_tips);
    }



}
