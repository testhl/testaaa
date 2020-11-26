package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

public class TestGroups {
	static Logger logger = LogManager.getLogger();
	@BeforeGroups
	public static void beforeGroups() {
		logger.info("运行BeforeGroups");
	}
	@AfterGroups
	public static void afterGroups() {
		logger.info("运行AfterGroups");
	}
}
