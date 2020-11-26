package test.test;

import java.text.ParseException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.common.*;
import com.test.ydywgzs.wx.pubWx;

public class testC {
	WebDriver driver;
	String url="https://www.baidu.com/";
	@Test(enabled = false)
	public void testA()   {
		webDriver.getWebdriver("chrome");
		webDriver.getUrl(url);
		String a1=apiActions.getText(By.xpath("//*[@id='s-top-left']/a[1]"));
		System.out.println(a1);
		ArrayList a2=apiActions.getTextAll(By.xpath("//*[@id='s-top-left']/a"));
		System.out.println(a2);
		ArrayList a3=apiActions.getTextI(By.xpath("//*[@id='s-top-left']/a"), 2);
		System.out.println(a3);
		
	}
	@Test(enabled = false)
	public void testB()   {
		
		webDriver.getWebdriver("chrome");
		webDriver.getUrl(url);
		//将控制权切换到frame内
		apiActions.frameIn(driver, "su");
		//点击
		apiActions.click(By.id("aa"));
		//将控制权从frame中转交出去
		apiActions.frameOut(driver);
	}
	@Test(enabled = false)
	public void testD()   {
		
		webDriver.getWebdriver("chrome");
		webDriver.getUrl(url);
		//将控制权切换到frame内
		apiActions.frameClick(driver, "su", By.id("aa"));
	}
	
	@Test(enabled = false)
	public void numTest() {
		long a=Numm.getNum(4);
		System.out.println(a);
	}
	@Test(enabled = false)
	public void numTestR() {
		long a=Numm.getNumRandom(2, 6);
		System.out.println(a);
	}
	@Test(enabled = false)
	public void numTestA() {
		String a=Numm.getStringRandom(4);
		System.out.println(a);
	}
	@Test(enabled = false)
	public void date1() {
		String a=Datee.formate(Datee.Date7);
		System.out.println(a);
	}
	
	@Test(enabled = false)
	public void date2() {
		String a=Datee.timeCurr(Datee.Date1);
		System.out.println(a);
	}
	@Test(enabled = false)
	public void numt() {
		long a=Numm.getNum(2);
		System.out.println(a);
	}
}
