package Pages;


import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TrolleyPage extends BasePage {


    private RemoteWebDriver driver;
    private By trolleypage_product_name = By.xpath("//a[@class='name']");
    private By trolleypage_product_unit_price = By.xpath("//div[@class='tab-price']//div[@class='unit-price']");
    private By trolleypage_product_number = By.xpath("//input[@class='number']");


    public TrolleyPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String get_product_name() {
        return waitElementVisible(driver, 8, trolleypage_product_name).getText();
    }

    public String get_product_price() {
        String trolley_unit_price_text = waitElementVisible(driver, 8, trolleypage_product_unit_price).getText();
        return trolley_unit_price_text;
    }

    public String get_product_number() {
        return waitElementVisible(driver, 8, trolleypage_product_number).getAttribute("value");
    }

}