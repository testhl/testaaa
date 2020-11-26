package com.test.wxtest.gyl;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.common.Datee;
import com.test.common.WaitElementsUtils;
import com.test.common.apiActions;
import com.test.common.webDriver;
import com.test.ydywgzs.comm.login;
import com.test.ydywgzs.wx.PubObjGYL;
import com.test.ydywgzs.wx.pubWx;

public class wx {
	
	private String url = "http://test.etpss.casicloud.com/home/gyl/inquiry/wx/publish.html";
	WebDriver driver;
	//构建框架1：需要用po模式
	//2.需要把参数提炼出来
	//3.用cookie登陆
	//4.将等待和assert封装到框架中
	//5.暂未定
	
	@Test
	public void publishWx() throws InterruptedException  {
		webDriver.getWebdriver("chrome");
		webDriver.getUrl(url);
		// 登录
        new login().loginIn(driver,"600633_system", "yw123456");
        WaitElementsUtils.sleep(10);
		// 暂时不会获取cookie需要手动操作一下
		// 登录成功
		//调用二次封装的方法
        //选择分类
        PubObjGYL.wxclassify("设计","总体设计");	
		apiActions.sendKeys(By.name("theme"), "发布外协需求测试"+Datee.timeCurr(Datee.Date9));
		apiActions.clearAftersendKeys(By.id("end_time"), Datee.yMdTime(0, 0, 7, Datee.Date2));
		apiActions.clearAftersendKeys(By.id("deli_time"), Datee.yMdTime(0, 0, 14, Datee.Date2));
		// 
		PubObjGYL.puWay(1, "4510311",0);
		PubObjGYL.inquiryObject(1, 2,"2");
		// 是否展示供应商
		// 附件
		// 图片
		// 需求描述
		apiActions.sendKeys(By.id("editor"),"哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
		// 关键词
		apiActions.sendKeys(By.xpath("//*[@id=\"ht-wx-keyword\"]/div[1]/input"),"关键词");
		// 交易方式
		// 付款方式
		// 发票类型
		// 运费承担方
		// 使用地址 data-code='120000'
		apiActions.click(By.cssSelector("[data-code='120000']"));
		apiActions.click(By.cssSelector("[data-code='120100']"));
		apiActions.click(By.cssSelector("[data-code='120110']"));
		// 详细地址
		// 联系人
		// 不允许云网推荐供应商 //*[@id="scModule5"]/div[2]/div/div[2]/div/div[2]/label/span[2]
		// 联系电话
		// 固定电话
		// 传真
		// 邮箱
		apiActions.sendKeys(By.name("email"),"123@163.com");
		// 勾选阅读方式
		apiActions.click(By.xpath("//*[@id='inq-agree-btn']/following::span"));
		// 点击发布需求
		apiActions.click(By.id("inq-publish"));
		apiActions.click(By.xpath("//*[@class='btn btn-primary sureBtn']"));
		//校验列表和详情页中数据是否正确
	}

}
