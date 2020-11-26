package test.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.common.WindowHandle;
import com.test.common.apiActions;
import com.test.common.webDriver;

public class TestWH extends webDriver{
	
	@Test(enabled = false)
	public static void A() {
		webDriver.getWebdriver("chrome");
		webDriver.getUrl("https://www.baidu.com/");
		apiActions.click(By.xpath("//*[text()='hao123']"));
		WindowHandle.chooseNextWindowHandleClose();
	}
	@Test(enabled = false)
	public static void B() {
		webDriver.getWebdriver("chrome");
		webDriver.getUrl("https://www.baidu.com/");
		apiActions.click(By.xpath("//*[text()='hao123']"));
		WindowHandle.chooseNextWindowHandle();
	}
	@Test
	public static void C() {
		webDriver.getWebdriver("firefox");
		webDriver.getUrl("https://www.baidu.com/");
		apiActions.click(By.xpath("//*[text()='hao123']"));
		apiActions.click(By.xpath("//*[@id='s-top-left']//*[text()='贴吧']"));
		
		for (String winHandle : driver.getWindowHandles()) {
			String winHandleBefore = driver.getWindowHandle();
			if (winHandle.equals(winHandleBefore)) {
				driver.close();
				continue;
			}
			// 切换浏览器页签
			driver.switchTo().window(winHandle);
			break;
		}
		String titlecurr=driver.getTitle();
		System.out.println(titlecurr);
	}

}
