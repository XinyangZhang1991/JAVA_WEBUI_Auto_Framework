package pages;


import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TrolleyPage extends BasePage {

    private RemoteWebDriver driver;
    private By trolleyPageProductName = By.xpath("//a[@class='name']");
    private By trolleypage_product_unit_price = By.xpath("//div[@class='tab-price']//div[@class='unit-price']");
    private By trolleypage_product_number = By.xpath("//input[@class='number']");
//    private By trolleyPageSelectAll = By.xpath("input[@class='checkbox default']");
    private By trolleyPageSelectAll = By.xpath( "//span[text()='全选']/preceding-sibling::input" );

    private By delete_selected_goods=By.xpath("//a[text()='删除选中商品']");
    private By confirm_delete=By.xpath("//a[@class='btn-r']");


    public TrolleyPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String get_product_name() {
        return waitElementVisible(driver, 8,trolleyPageProductName).getText();
    }

    public String get_product_price() {
        String trolley_unit_price_text = waitElementVisible(driver, 8, trolleypage_product_unit_price).getText();
        String tirmed_unit_price_text = trolley_unit_price_text.replaceAll("￥","").replaceAll(".00","").trim();
        return tirmed_unit_price_text;
    }

    public String get_product_number() {
        String product_number= waitElementVisible(driver, 8, trolleypage_product_number).getAttribute("value");
        System.out.println("product number required is "+product_number);
        return product_number;
    }

    public void  delete_all() {
        waitElementClickable(driver, 8, trolleyPageSelectAll).click();
        waitElementClickable(driver, 8, delete_selected_goods).click();
        waitElementClickable(driver, 8, confirm_delete).click();
    }

    public static void main(String[] args) {
        String String1 = "￥799.00" ;
        String String2 = String1.replaceAll("￥","").replaceAll(".00","").trim();
        System.out.println(String2);
    }
}