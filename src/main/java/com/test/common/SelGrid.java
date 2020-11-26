package com.test.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SelGrid extends webDriver{
	
	 static Logger logger = LogManager.getLogger();
	public static void gridBrowerDriver(String url,String brower)  {
		DesiredCapabilities dc=null;
		if(brower.equals("chrome")) {
			dc=DesiredCapabilities.chrome();
		}else if(brower.equals("firefox")) {
            dc=DesiredCapabilities.firefox();
            //如果浏览器找不到位置，调用该方法找到浏览器位置
            dc.setCapability("firefox_binary","F:\\MozillaFirefox\\firefox.exe");
		}else if(brower.equals("IE")) {
			dc=DesiredCapabilities.internetExplorer();
		}else if(brower.equals("safari")) {
			dc=DesiredCapabilities.safari();
		}else {
			logger.error("不支持该类型的浏览器");
		}
		String urll=url+"/wd/hub";
		try {
			driver=new RemoteWebDriver(new URL(urll),dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DataProvider(name="GridBrower")
	public Object[][] obGridBrower(){
		return new Object[][] {
			{"http://192.168.85.1:5557","firefox"},
			{"http://192.168.85.1:5557","chrome"}
		};
		
	}
	
	@Test(dataProvider = "GridBrower")
	public static void testAAA(String url,String brower) {
		gridBrowerDriver(url,brower);
		driver.get("https://www.baidu.com/");
		
	}
}
