package listener;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import testcases.Add_Items_to_trolley;

import java.io.File;
import java.io.IOException;

public class TestResultListener implements IHookable {
    // If a test class implements this interface, its run() method will be invoked instead of each @Test
    // * method found.
    //如果一个测试类实现了该接口，那么该接口的run方法将会代替每一个被@Test注解标注的测试方法（Login、AddCartTest）
    public void run(IHookCallBack callBack, ITestResult testResult){
        System.out.println("这里是IHookable的run方法执行");
        //得要让测试用例先正常执行
        callBack.runTestMethod(testResult);
        //得要测试用例执行状态（监听到是否失败）testResult
        if(testResult.getThrowable() != null){
            System.out.println("测试用例异常");
            //testResult还会保存有当前测试类的实例(instance)-》对象
            Add_Items_to_trolley instance = (Add_Items_to_trolley)testResult.getInstance();
            takeScreenshot(instance.driver,"A:\\JAVACode2025\\WebUIFrameWork\\screenshots\\failureimage.png");

        }

    }
    public void takeScreenshot(RemoteWebDriver driver, String path) {
        File file1 = driver.getScreenshotAs(OutputType.FILE);
        File file2 = new File(path);
        try {
            FileUtils.copyFile(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
