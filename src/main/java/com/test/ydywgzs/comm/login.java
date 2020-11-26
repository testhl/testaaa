package com.test.ydywgzs.comm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.common.WaitElementsUtils;


public class login {
	
	/*
	 * 
	 * // 登陆里面用到的元素 
	 * // 定位用户名称 
	 * public static By name = By.id("shortAccount"); 
	 * // 定位密码
	 * public static By psw = By.id("password"); 
	 * // 定位点击登陆按钮 
	 * public static By click= By.xpath("//*[@id=\"loginForm\"]/div[6]/input");
	 *
	 *
	 */

	public void loginIn(WebDriver driver,String phone, String password) throws InterruptedException {
		// 获取手机号元素,输入手机号
		WaitElementsUtils.findElement(By.id("shortAccount")).sendKeys(phone);
		// 输入密码
		WaitElementsUtils.findElement(By.id("password")).sendKeys(password);
		// 点击提交
		WaitElementsUtils.findElement(By.xpath("//*[@id=\"loginForm\"]/div[6]/input")).click();
		// 再输入验证码
		// 在提交
	}
}
