package com.test.common;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//存放对webdriverapi的封装
public class apiActions {
	
	
	/*
	 * 封装点击方法，不需要返回值 By by定位放置，传入一个by的类型
	 * 点击
	 */
	public static void click(By by) {
		// 查找传入的元素，进行点击，二次封装后点击的时候会有只能等待
		WaitElementsUtils.findElement(by).click();
	}

	/*
	 * 封装传入文本方法，不需要返回值 By by定位放置，传入一个by的类型 
	 * 直接传入文本
	 */
	public static void sendKeys(By by, String text) {
		
		WaitElementsUtils.findElement(by).sendKeys(text);
	}
	
	/*
	 * 封装传入文本方法，不需要返回值 By by定位放置，传入一个by的类型
	 * 先清空值然后在传入文本
	 */
	public static void clearAftersendKeys(By by, String text) {
		
		WebElement el=WaitElementsUtils.findElement(by);
		el.clear();
		el.sendKeys(text);
	}
	
	/*
	 * 封装获取文本方法，不需要返回值 By by定位放置，传入一个by的类型
	 * 获取文本值的方封装
	 */
	public static String getText(By by) {
		
		String text=WaitElementsUtils.findElement(by).getText();
		return text;
	}
	/*
	 * 封装获取文本方法，不需要返回值 By by定位放置，传入一个by的类型
	 * 获取多个文本值的二次封装
	 */
	public static ArrayList getTextAll(By by) {
		
		ArrayList at=new ArrayList();
	    List<WebElement> list=WaitElementsUtils.findElements(by);
	    for (int i=0;i<list.size();i++) {
	    	String text=list.get(i).getText();
	    	at.add(text);
	    }
		return at;
	}
	
	/*
	 * 封装获取文本方法，不需要返回值 By by定位放置，传入一个by的类型
	 * 获取多个文本值中的某一个文本值
	 * 注i从0开始，2是列表中的第三个值
	 */
	public static ArrayList getTextI(By by,int i) {
		
		ArrayList at=new ArrayList();
	    List<WebElement> list=WaitElementsUtils.findElements(by);
	    String text=list.get(i).getText();
	    at.add(text);
		return at;
	}
	/*
	 * 封装双击方法
	 * 
	 * 
	 */
	public static void doubleclick(WebDriver driver,By by) {
		Actions act= new Actions(driver);
		WebElement ele=WaitElementsUtils.findElement(by);
		act.doubleClick(ele).perform();
	}
	
	/*
	 * 封装iframe
	 * 将控制权转到fram框架内
	 * frame的封装未经过测试暂时不确定是否正确
	 */
	public static void frameIn(WebDriver driver,String f) {
		
		driver.switchTo().frame(f);
	}
	/*
	 * 封装iframe
	 * 将控制权转到fram框架外
	 * frame的封装未经过测试暂时不确定是否正确
	 */
	public static void frameOut(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/*
	 * 封装iframe
	 * 将控制权转到fram框架外
	 * frame的封装未经过测试暂时不确定是否正确
	 */
	public static void frameClick(WebDriver driver,String f,By by) {
		//获取frame的位置，将控制权转交的frame内
		driver.switchTo().frame(f);
		//frame内点击
		WaitElementsUtils.findElement(by).click();
		//点击某一按钮后将控制权转交到frame外
		driver.switchTo().defaultContent();
	}
	
	//页签切换
	
}
