package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuite {
	static Logger logger = LogManager.getLogger();
	
	@BeforeSuite
	public static void beforeS() {
		logger.info("运行套件BeforeSuite");
	}
	@AfterSuite
	public static void afterS() {
		logger.info("运行套件AfterSuite");
	}

}
