package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestTest {
	static Logger logger = LogManager.getLogger();
	
	@BeforeTest
	public static void beforeT() {
		logger.info("运行BeforeTest");
	}
	@AfterTest
	public static void afterT() {
		logger.info("运行AfterTest");
	}

}
