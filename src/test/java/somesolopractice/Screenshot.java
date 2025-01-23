package somesolopractice;

import org.apache.commons.io.FileUtils;
import common.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

public class Screenshot extends BaseTest {

    @Test
    public void test() throws InterruptedException, IOException {
        RemoteWebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        //通过代码截图
        //OutputType.FILE --> 截图输出类型为文件对象
        File file1 = driver.getScreenshotAs(OutputType.FILE);
        //把file对象保存到本地文件中
        //需要用到FileUtils工具类--需要导入Apache Commons IO这个依赖
        //把原始的file对象拷贝到目标file对象中
        File file2 = new File("A:\\JAVACode2025\\WebUIFrameWork\\screenshots\\baiduhomepage");
        FileUtils.copyFile(file1,file2);
    }
}
