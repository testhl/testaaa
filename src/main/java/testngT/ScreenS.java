package testngT;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import com.test.common.Datee;
import com.test.common.Filee;
import com.test.common.webDriver;

import io.qameta.allure.Attachment;

public class ScreenS extends webDriver{
	static String path=System.getProperties().getProperty("user.dir")+"/error/";
	 static Logger logger = LogManager.getLogger();
	
	/*public void dd() {
		driver=this.driver;
	}*/
	/**
	 * 截图
	 * 
	 * @param 
	 * @return
	 */
	 @Attachment(value = "失败截图如下：",type = "image/png")
	public static  void screenShot() {
		
		WebDriver augmentdriver =new Augmenter().augment(driver);
		File file =((TakesScreenshot)augmentdriver).getScreenshotAs(OutputType.FILE);
		Filee myfile=new Filee();
		try {
			myfile.createFile(path+Datee.formate(Datee.Date9));
			FileUtils.copyFile(file, new File(path+Datee.formate(Datee.Date9)+"/"+Datee.formate(Datee.Date9)+".jpg"));
		} catch (IOException e) {
			logger.error("截图失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 传入固定名字进行截图
	 * 
	 * @param 
	 * @return
	 */
	 @Attachment
	public static void screenShot(String name) {
		WebDriver augmentdriver =new Augmenter().augment(driver);
		File file =((TakesScreenshot)augmentdriver).getScreenshotAs(OutputType.FILE);
		Filee myfile=new Filee();
		try {
			myfile.createFile(path+Datee.formate(Datee.Date9));
			FileUtils.copyFile(file, new File(path+Datee.formate(Datee.Date9)+name+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
