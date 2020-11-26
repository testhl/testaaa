package com.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WindowHandle extends webDriver{
	
	static Logger logger = LogManager.getLogger();
	
	//切换某一个页签,该方法不适用于火狐浏览器会报错，原因时版本与driver不匹配，需要降到58版本之下才行
	public static void chooseOneWindowHandle(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list=new ArrayList(windowHandles);
		driver.switchTo().window(list.get(i));
		String titlecurr=driver.getTitle();
		logger.info(titlecurr);
		
	}

	
	//两个页签时切换页签
	public static void chooseNextWindowHandleClose() {
		// 获取全部句柄
				String winHandleBefore = driver.getWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					if (winHandle.equals(winHandleBefore)) {
						driver.close();
						continue;
					}
					// 切换浏览器页签
					driver.switchTo().window(winHandle);
					break;
				}

				String titlecurr=driver.getTitle();
				logger.info(titlecurr);
			}


	//两个页签时切换页签
		public static void chooseNextWindowHandle() {
			// 获取全部句柄
					String winHandleBefore = driver.getWindowHandle();
					for (String winHandle : driver.getWindowHandles()) {
						if (winHandle.equals(winHandleBefore)) {
							continue;
						}
						// 切换浏览器页签
						driver.switchTo().window(winHandle);
						break;
					}
					String titlecurr=driver.getTitle();
					logger.info(titlecurr);
				}

			// 切换页签
			public static void switchToWindow(String titlestr){
				for (int a = 0; a < 9; a++) {
					Set<String> windowHandles = driver.getWindowHandles();
					for (String handler : windowHandles) {
						driver.switchTo().window(handler);
						String title = driver.getTitle();
						if (titlestr.equals(title)) {
							a = 10;
							break;
						}
					}
				}
			}

			public static int getStatusCode(String url) throws Exception {
				int statusCode = 0;
				CloseableHttpClient client = HttpClients.createDefault();
				HttpGet request = new HttpGet(url);
				try {
					CloseableHttpResponse response = client.execute(request);
					statusCode = response.getStatusLine().getStatusCode();

				} catch (ClientProtocolException e) {
					System.out.println("获取" + url + "报错");

				}

				return statusCode;
			}
	}

