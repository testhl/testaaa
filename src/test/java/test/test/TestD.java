package test.test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.common.ExcRead;
import com.test.common.WaitElementsUtils;
import com.test.common.webDriver;
import com.test.ydywgzs.comm.login;
import com.test.ydywgzs.wx.PubObjGYL;
import com.test.ydywgzs.wx.pubWx;

public class TestD {

	@DataProvider
	public Object[][] dataT(){
		ExcRead ex=new ExcRead();
		return ex.testDate("C:\\Users\\k\\Desktop\\aaaaaaaaa\\a.xls","user");
	}
	
	WebDriver driver;
	//构建框架1：需要用po模式
	//2.需要把参数提炼出来
	//3.用cookie登陆
	//4.将等待和assert封装到框架中
	//5.暂未定
	
	@Test(dataProvider="dataT")
	public void publishWx(HashMap<String,String> data) throws InterruptedException  {
		webDriver.getWebdriver(data.get("浏览器"));
		webDriver.getUrl(data.get("地址"));
		new login().loginIn(driver, data.get("用户名"), data.get("密码"));
		WaitElementsUtils.sleep(10);
		// 暂时不会获取cookie需要手动操作一下
		// 登录成功
		PubObjGYL.wxclassify("设计", "总体设计");
		pubWx.themeName("外协需求测试");
		PubObjGYL.dayTime(8, 15);
		// 
		PubObjGYL.priceWay(0);
		PubObjGYL.puWay(1, "4510311", 0);
		//导入询价对象
		PubObjGYL.inquiryObject(1, 2,"2");
		PubObjGYL.respectPrice(0);
		pubWx.reMarks("关键字");
		PubObjGYL.commerceClause("预付款","支票","本票","普通发票");
		pubWx.other(1);
		PubObjGYL.freightForwarder(0);
		//选择省市县
		PubObjGYL.addressNum(3, 4, 2,"哈哈哈哈");
		pubWx.contactWay("测试1", "15911591001", "", "", "123@163.com");

	}
	
	
	
}
