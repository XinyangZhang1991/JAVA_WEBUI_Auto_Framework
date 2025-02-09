package pages;


import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends BasePage {
    //
    private By login_link = By.linkText("登录");
    private By welcome_tips = By.xpath("//span[text()='欢迎来到柠檬班']");
    private By user_name=  By.xpath ("//a[@class='link-name']");
    private RemoteWebDriver driver;
    private By product_list =By.linkText("商品列表");
    private By trolley_icon = By.xpath("//span[@data-route='cart']");
    private By homePageSearchBar = By.xpath("//div[@class=\"search-input-box\"]/input");
    //这个不能用，用上面的private By homePageSearchBar = By.xpath("//div[@class='right']//div[@class='search']//input[@placeholder='请输入商品名称']");
    //private By homePageclicksearchicon = By.xpath("//div[@class='right']//div[@class='search']//input[@type='submit']");
    private By homePageclicksearchicon = By.xpath("//div[@class=\"search-input-box\"]/following-sibling::input");
    //通过有参构造把初始化的参数传递过来
    public HomePage (RemoteWebDriver driver){
        this.driver =driver;
        ;
    }
    //action on the page - method
    public void clickLogin (){
//        waitElementClickable(driver, 4, login_link).click();
        click(driver,login_link);
    }

    public WebElement findwelcometips (){

//        return waitElementVisible(driver, 4, welcome_tips);
          return getElement(driver,welcome_tips);
    }

    public String getUsername(){
//        WebElement webElement = driver.findElement(user_name);
//        return webElement.getText();
//          return waitElementVisible(driver, 4, user_name).getText();
        return getElementText(driver,user_name);
    }

    public void click_selected_product(String product_name){
        //step1: click the product list icon
//        waitElementClickable(driver, 4, product_list).click();
       //这个先去掉了， 因为这个是点击产品列表，现在Testcase换成了search, click(driver,product_list);

        //step 2 : click a product you choose
        //商品名字不能写死，需要通过变量传递过来
        //"//div[text()='" and +"']" are fixed parts of the string
        By selected_goods = By.xpath("//div[text()='"+product_name+"']");

//        waitElementClickable(driver, 4, selected_goods).click();
        click(driver,selected_goods);
    }
    //By selected_goods = By.xpath("//div[text()='真皮圆筒包']");

    public void click_trolley_icon (){
        //waitElementClickable(driver, 4, trolley_icon).click();
        click(driver,trolley_icon);
    }


    public void input_into_searchbar (String inputtext){
        input(driver,homePageSearchBar,inputtext);
        click(driver,homePageclicksearchicon);
    }
}


