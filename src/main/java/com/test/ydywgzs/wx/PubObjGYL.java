package com.test.ydywgzs.wx;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.test.common.Datee;
import com.test.common.Numm;
import com.test.common.WaitElementsUtils;
import com.test.common.apiActions;
import com.test.ydywgzs.comm.Pagee;

public class PubObjGYL {

	//选择分类；1.String... s意思为输入多个参数；2.增强for循环，遍历出循环的内容并赋值到定位元素中
		public static void wxclassify(String... s) {
			// 先点击输入框，然后选择分类，可以只选择一级，也可以选择多级
			// 输入分类名称
			// 先点击输入框，然后选择分类，可以只选择一级，也可以选择多级
			apiActions.click(By.className("cascade-text"));
			for (String st : s) {
				apiActions.click(By.xpath("//*[text()='" + st + "']"));
			}
			// 点击确定
			apiActions.click(By.className("cascade-footer-confirm"));

		}
		
	/*
	 *  isencode  发布方式密封  0 密封 1非密封
	 */
		public static void priceWay(int isencode) {
			if (isencode==0 ) {
				//点击密封  
				apiActions.click(By.xpath("//*[text()='密封比价']"));
			} else if(isencode==1){
				//点击非密性 非密性不点击，密性点击
				apiActions.click(By.xpath("//*[text()='非密封比价']"));
			}
		}
		/*
		 *  isrespectprice 期望报价选择是  0是  1否
		 */
		public static void respectPrice(int isrespectprice) {
			if (isrespectprice==0) {
				//是展示期望报价给用户
				apiActions.click(By.xpath("//*[@id='scModule2']//*[text()='是']"));
			} else if (isrespectprice==1){
				//不展示期望报价
				apiActions.click(By.xpath("//*[@id='scModule2']//*[text()='否']"));
			}
		}
		/*
		 *  freightcg 运费承担方选择采购方    0采购 1供应
		 */
		public static void freightForwarder(int freightcg) {
			if (freightcg==0) {
				//运费承担方采购方
				apiActions.click(By.xpath("//*[@id='scModule3']//*[@class='form-group']//*[text()='采购方']"));
			} else if (freightcg==1){
				//运费承担方供应方
				apiActions.click(By.xpath("//*[@id='scModule3']//*[@class='form-group']//*[text()='供应方']"));
			}
		}
		
		/*
		 * //封装全网或是定向报价 全网0，定向1 ，2
		 * //调用方法 
		 * 全网 pubWx.puWay(0, null,0); 
		 * 定向pubWx.puWay(1, "4510311",0);
		 */
		public static void puWay(int pubway,String qiyeID,int num) throws InterruptedException {
			if (pubway == 0) {
				//全网
				apiActions.click(By.id("noProviderBtn"));
			} else if(pubway == 1){
				//指定企业定向
				apiActions.click(By.id("importProviderBtn"));
				apiActions.click(By.xpath("//*[@id='wxwg-nav']/li[3]/span"));
				apiActions.sendKeys(By.xpath("//*[@id='tenantIdSup']"), qiyeID);
				apiActions.click(By.xpath("//*[@id='inviteSearchBtn']"));
				apiActions.click(By.xpath("//*[text()='" + qiyeID + "']/parent::tr/td//i"));
				apiActions.click(By.xpath("//*[text()='完成邀请']"));
			}else if(pubway == 2){
				//翻页多选定向
				apiActions.click(By.id("importProviderBtn"));
				apiActions.click(By.xpath("//*[@id='wxwg-nav']/li[3]/span"));
				String j=String.valueOf(num);
				Pagee.pageNum(1, j,null);
				for (int i = 1; i <= num; i++) {
					apiActions.click(By.xpath("//*[@id='inviteProvider']//tbody/tr["+i+"]//span"));
				}
				apiActions.click(By.xpath("//*[text()='完成邀请']"));
			}
		}
		
		/*
		 * 封装添加询价对象，obbway 自动添加0，导入默认1
		 * num添加的商品个数 
		 */
		public static void inquiryObject(int obbway,int num,String page) throws InterruptedException {
			if (obbway == 0) {
				for (int i = 1; i <= num; i++) {
					//点击添加
					apiActions.click(By.id("add-info"));
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[2]//input") , "产品"+i);
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[3]//input"),"00"+i);
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[4]//input"),"1");
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[5]//input"),"件");
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[6]//input"),"testtest"+i);
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[7]//input"),"0.0"+i);
				}	
			} else if(obbway == 1){
				//点击导入
				apiActions.click(By.id("importObjList"));
				//翻页
				Pagee.pageNum(1, page,null);
				for (int i = 1; i <= num; i++) {
	                //勾选复选框
					apiActions.click(By.xpath("//*[@id='wxImportModal']//tbody/tr[" + i + "]//label/span"));
				}
				apiActions.click(By.id("mChooseBtn"));
				for (int i = 1; i <= num; i++) {
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[4]//input"),"1");
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[6]//input"),"testtest"+i);
					apiActions.sendKeys(By.xpath("//*[@id='objListContent']/tr["+i+"]/td[7]//input"),Numm.getNumAndDec(i, 2));
				}
			}
		}
		
		
		/*
		 *  非重复文案都可以选择 
		 */
		public static void commerceClause(String... com) {
			for (String st : com) {
				apiActions.click(By.xpath("//*[text()='" + st + "']"));
			}
		}
		
		public static void commerceClauseRe(String loc, String com) {
	        //有重复文案的点击
			apiActions.click(By.xpath(loc + "//*[text()='" + com + "']"));

		}

		/*
		 *  日期
		 *  报价截至日期
		 *  要求到货日期
		 */
		public static void dayTime(int endday,int delitime) {
			// 报价截至日期
			apiActions.clearAftersendKeys(By.id("end_time"), Datee.yMdTime(0, 0, endday, Datee.Date2));
			// 报价截至日期
			apiActions.clearAftersendKeys(By.id("deli_time"), Datee.yMdTime(0, 0, delitime, Datee.Date2));
		}
		
		/*
		 *  地址输入
		 * 省
		 *  市
		 *  县
		 */
		public static void address(String province,String city,String county,String add) {
			//选择省  也可以直接用点击方法
            new Select(WaitElementsUtils.findElement(By.xpath("//*[@name='province']"))).selectByVisibleText(province);
            //选择市  也可以直接用点击方法
            new Select(WaitElementsUtils.findElement(By.xpath("//*[@name='city']"))).selectByVisibleText(city);
            //选择县  也可以直接用点击方法
            new Select(WaitElementsUtils.findElement(By.xpath("//*[@name='county']"))).selectByVisibleText(county);
          //输入详细地址
            apiActions.sendKeys(By.xpath("//*[@name='detailAddress']"), add);
		}
		/*
		 *  地址随机点击  index从0开始
		 * 省
		 *  市
		 *  县
		 */
		public static void addressNum(int i,int j,int k,String add) {
			//选择省  也可以直接用点击方法
            new Select(WaitElementsUtils.findElement(By.xpath("//*[@name='province']"))).selectByIndex(i);;
            //选择市  也可以直接用点击方法
            new Select(WaitElementsUtils.findElement(By.xpath("//*[@name='city']"))).selectByIndex(j);
            //选择县  也可以直接用点击方法
            new Select(WaitElementsUtils.findElement(By.xpath("//*[@name='county']"))).selectByIndex(k);
            //输入详细地址
            apiActions.sendKeys(By.xpath("//*[@name='detailAddress']"), add);
		}
}
