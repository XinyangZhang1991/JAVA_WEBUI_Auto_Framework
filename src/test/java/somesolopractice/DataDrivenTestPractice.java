package somesolopractice;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestPractice {

    @Test(dataProvider = "getLoginDatas")
    public void login(String username,String password){
        System.out.println("账号:"+username);
        System.out.println("密码:"+password);
    }

    @DataProvider
    public Object[][] getLoginDatas(){
        //通过数组来保存我们的测试数据
        Object[][] datas={{"lemon","123456"},
                {"lemon",""},
                {"","123456"},
                {"lemon","123"}
        };
        //文件，类似的思路，需要读取文件中的数据
        return datas;
    }
}
