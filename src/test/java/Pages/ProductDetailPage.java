package Pages;


import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ProductDetailPage extends BasePage {
    private RemoteWebDriver driver;
    //trolley button
    private By add_cart = By.xpath("//a[@class='add-cart']");

    private By product_unit_price = By.xpath("//div[@class='item goods-price']//div[@class='price']");


    public ProductDetailPage (RemoteWebDriver driver){
        this.driver =driver;
    }

    public String get_product_prices(){
        //get the produce price
//        String unit_price_text = waitElementVisible(driver,8,product_unit_price).getText();
        String unit_price_text =  getElementText(driver,product_unit_price);
        System.out.println("product prices is"+unit_price_text);
        //把换行符号\n换成空的， 并去掉空格
        //The replaceAll("\n", "") method finds all occurrences of newline characters (\n) in the unit_price_text and replaces them with an empty string (""), effectively removing them.
        //Trim Whitespace: The trim() method removes any leading or trailing spaces from the processed string
        return unit_price_text.replaceAll("\n","").trim();

    }
    public void  adding_into_trolley () {

//        waitElementClickable(driver,8,add_cart).click();
        click(driver,add_cart);


    }

}
