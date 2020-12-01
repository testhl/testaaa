package testngT;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.common.webDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;


public class FailScreenAllure extends webDriver{

	    protected void failed(Throwable e, Description description) {
	    	ScreenshotOnFailure();
	    }


	    @Attachment(value = "失败截图如下：",type = "image/jpg")
	    public static byte[] ScreenshotOnFailure() {
	    	ScreenS.screenShot();
	        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    }
}
