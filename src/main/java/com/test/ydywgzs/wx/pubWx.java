package com.test.ydywgzs.wx;


import org.openqa.selenium.By;

import com.test.common.Datee;
import com.test.common.apiActions;

public class pubWx {
	//添加需求名称
	public static void themeName(String name) {
		//添加询价主题
				apiActions.sendKeys(By.name("theme"), name + Datee.timeCurr(Datee.Date9));
	}
	
	// 需求描述、关键字
	public static void reMarks(String rem) {
		// 需求描述
		apiActions.sendKeys(By.id("editor"), rem + rem + rem + rem + rem + rem + rem + rem + rem);
		// 关键词
		apiActions.sendKeys(By.xpath("//*[@id=\"ht-wx-keyword\"]/div[1]/input"), rem);
	}

	

	//商务条款其他  1交易方式其他   1付款方式其他
	public static void other(int is) {
		if(is==1) {
			apiActions.click(By.xpath("//*[@id='deal_method_box']//*[text()='其他']"));
		}else if(is==2){
			apiActions.click(By.xpath("//*[@id='pay_method_box']//*[text()='其他']"));
		}
	}

	// 联系方式
	public static void contactWay(String con,String mo,String tel,String fax,String em) {
		// 联系人
		apiActions.clearAftersendKeys(By.xpath("//*[@name='contact']"), con);
		// 联电话
		apiActions.clearAftersendKeys(By.xpath("//*[@name='mobile']"), mo);
		// 固定电话
		apiActions.clearAftersendKeys(By.xpath("//*[@id='scModule5']//*[@name='telephone']"), tel);
		// 传真
		apiActions.clearAftersendKeys(By.xpath("//*[@name='fax']"), fax);
		// 邮箱
		apiActions.clearAftersendKeys(By.xpath("//*[@name='email']"), em);
	}
}
