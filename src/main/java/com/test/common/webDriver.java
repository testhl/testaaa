package com.test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class webDriver {
	
	public static WebDriver driver;
	//启动浏览器
	public static WebDriver getWebdriver(String browserName) {
		if ("chrome".equals(browserName)) {
			// 打开浏览器
			System.setProperty("webdriver.chrome.driver", "E:/webdri/chromedriver.exe");
			driver = new ChromeDriver();

		} else if ("firefox".equals(browserName)) {
			//System.setProperty("webdriver.gecko.driver", "E:/webdri/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if ("ie".equals(browserName)) {
			System.setProperty("webdriver.ie.driver", "E:/webdri/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("只支持ie32，ie64，firefox和chrome浏览器");
		}
		driver.manage().window().maximize();
		return driver;
	}
	//关闭浏览器
	public static void closeAll() {
		if (driver == null) {
			driver.quit();
		}
	}
	public static void closed() {
		if (driver == null) {
			driver.close();
		}
	}
	public static WebDriver getWebdriver() {
		return driver;
	}
	/*
	 * 封装打开网址方法，不需要返回值 传入一个String类型的url
	 * 打开网址
	 */
	public static void getUrl(String url) {
		
		driver.get(url);
	}
}
