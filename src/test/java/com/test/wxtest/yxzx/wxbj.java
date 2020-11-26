package com.test.wxtest.yxzx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class wxbj {
	WebDriver driver;
	//根据发布的需求获取询价id
	String id="40000030833479";
	String url="http://etpss.casicloud.com/home/yxzx/quote/wx/add/"+id+".html";
	
	@Test
	public void wxbjTopublishWx() throws InterruptedException {
		// 打开浏览器
				System.setProperty("webdriver.chrome.driver", "E:/webdri/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				// 进入发布需求页面
				driver.get(url);
				driver.manage().window().maximize();
				// 登录

				driver.findElement(By.id("shortAccount")).sendKeys("15910000002");
				driver.findElement(By.id("password")).sendKeys("yunl123456@");
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[6]/input")).click();
				// 暂时不会获取cookie需要手动操作一下
				Thread.sleep(12000);
				// 登录成功
				//多个商品进行报价
				//单个商品报价
				driver.findElement(By.xpath("//*[@class='quote-row']//a")).click();
				Thread.sleep(2000);
				//报价弹出框中输入单价
                driver.findElement(By.id("modal-price")).sendKeys(".01");
                Thread.sleep(2000);
				//点击弹出框中的确定按钮
				driver.findElement(By.xpath("//*[@class='modal-footer']/button[1]")).click();
				Thread.sleep(2000);
				//填写报价说明
				driver.findElement(By.id("explainTextarea")).sendKeys("12345123451234512345");
				Thread.sleep(2000);
				//选择报价有效期
				driver.findElement(By.id("endtime")).sendKeys("2020-11-03");
				Thread.sleep(2000);
				//点击确认报价
				driver.findElement(By.id("btnConfirm")).click();;
	}
	
}
