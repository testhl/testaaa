package test.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.common.MyAssert;
import com.test.common.apiActions;
import com.test.common.webDriver;

public class TestF {


	@Test
	public static void test() {
	
		webDriver.getWebdriver("chrome");
		webDriver.getUrl("https://www.baidu.com/");
		apiActions.click(By.xpath("//*[text()='hao123123']"));
		MyAssert.assertTrue(false);
		MyAssert.assertEquals("123", "adf");
	}

	@Test
	public static void testWin() {
	
		webDriver.getWebdriver("chrome");
		webDriver.getUrl("https://www.baidu.com/");
		apiActions.click(By.xpath("//*[text()='hao123']"));
		//切换到hao123的页签上
		
	}
	
}
