package com.test.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//继承webDriver类，获取到driver
public class WaitElementsUtils extends webDriver {
	
	static Logger logger = LogManager.getLogger();
	//用于执行测试用例是强制等待.暂停程序强制等待
	public static void sleep(long millsecond) throws InterruptedException {
	    long second=millsecond*1000;
		Thread.sleep(second);
		System.out.println("强制等待"+millsecond+"s");
		logger.info("强制等待"+millsecond+"s");
	}
	
   //将等待方法封装的findElement中
	public static WebElement findElement(final By by) {
		// 封装等待方法
		// 等待
		// 先实例化WebDriverWait类，然后根据元素定位在进行定位等待

		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("元素"+by+"查找超时");
			logger.error("元素"+by+"查找超时");
			e.printStackTrace();
		}
		return driver.findElement(by);
	}
	
	//封装的findElements加入等待时间
	public static List<WebElement> findElements(final By by) {
		// 封装等待方法
		// 等待
		// 先实例化WebDriverWait类，然后根据元素定位在进行定位等待

		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("元素"+by+"查找超时");
			logger.error("元素"+by+"查找超时");
			e.printStackTrace();
		}
		return driver.findElements(by);
	}
}
