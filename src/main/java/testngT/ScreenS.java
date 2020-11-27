package testngT;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import com.test.common.Datee;
import com.test.common.Filee;
import com.test.common.webDriver;

import io.qameta.allure.Allure;
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
	 
	 /** 截图添加到附件 */
		public static void getScreenshot(String filename) {
			byte[] screenshotAs = null;
			try {
				screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			} catch (TimeoutException e) {
				System.out.println("时间超时" + filename + "失败");
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle screenRectangle = new Rectangle(screenSize);
		        Robot robot;
				try {
					robot = new Robot();
					BufferedImage image = robot.createScreenCapture(screenRectangle);
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					ImageIO.write(image, "jpg", out);
					screenshotAs = out.toByteArray();
					out.close();
				} catch (AWTException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		      
			}

			InputStream is = null;
			if (screenshotAs != null) {
				try {
					is = new ByteArrayInputStream(screenshotAs);
					Allure.addAttachment(filename, is);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				Allure.addAttachment(filename, "时间超时");
			}
		}
		/** 截图添加到附件 */
		public static void getScreenshotF() {
			String filename=Datee.formate(Datee.Date9);
			byte[] screenshotAs = null;
			try {
				screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			} catch (TimeoutException e) {
				System.out.println("时间超时" + filename + "失败");
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle screenRectangle = new Rectangle(screenSize);
		        Robot robot;
				try {
					robot = new Robot();
					BufferedImage image = robot.createScreenCapture(screenRectangle);
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					ImageIO.write(image, "jpg", out);
					screenshotAs = out.toByteArray();
					out.close();
				} catch (AWTException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		      
			}

			InputStream is = null;
			if (screenshotAs != null) {
				try {
					is = new ByteArrayInputStream(screenshotAs);
					Allure.addAttachment(filename, is);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				Allure.addAttachment(filename, "时间超时");
			}
		}
}
