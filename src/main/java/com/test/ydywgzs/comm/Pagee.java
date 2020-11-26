package com.test.ydywgzs.comm;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.common.WaitElementsUtils;
import com.test.common.apiActions;

public class Pagee {

	/*
	 * 分页封装
	 * nump页数
	 * type  分页类型  0：直接点击某一页；1：输入页数后点击确定；2：上翻页；3：下翻页
	 * loc   分页模块xpath的定位方式，不用写到具体的定位上，整个模块的定位方式
	 */
	public static void pageNum(int type,String nump,String loc) throws InterruptedException {
		//loc="//*[@id='wxImportModal']//*[@class='inqObjPage ht-page']";
		////*[@id='inviteProvider']//*[@class='inqObjPage ht-page']
		if(type==0) {
			//点击某一页，只能输入显示出来的页数
		    List<WebElement> list=
		    		WaitElementsUtils.findElements(By.xpath(loc+"//a"));
		    for (int i=0;i<list.size();i++) {
		    	String text=list.get(i).getText();
                if(text==nump) {
                	//跳出循环
                	break;
                }
		    }
		    apiActions.click(By.xpath(loc+"//*[text()='"+nump+"']"));
		}else if(type==1) {
			//输入某一页数
			apiActions.sendKeys(By.id("pageInput"), nump);
			//点击确定
			apiActions.click(By.id("pagebtn"));
		}else if(type==2) {
			//点击上翻页  异常状况未做判断只做了正常判断  上翻页数小于点击页数时会报错
			apiActions.click(By.className("previous"));
		}else if(type==3) {
			//点击下翻页 异常状况未做判断只做了正常判断  同上翻页
			int j=Integer.valueOf(nump);
			for (int i = 0; i <j ; i++) {
				apiActions.click(By.xpath(loc+"//*[@class='next']"));
				WaitElementsUtils.sleep(3);
			}
		}
		
	}
}
