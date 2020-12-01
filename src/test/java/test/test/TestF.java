package test.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.common.MyAssert;
import com.test.common.apiActions;
import com.test.common.webDriver;

import io.qameta.allure.Description;

public class TestF {

	@Description("Description注解：对百度进行截图")
	@Test
	public static void test() {
	
		webDriver.getWebdriver("chrome");
		webDriver.getUrl("https://www.baidu.com/");
		apiActions.click(By.xpath("//*[text()='hao123']"));
		MyAssert.assertTrue(false);
		MyAssert.assertEquals("123", "adf");
	}
	
	
}
