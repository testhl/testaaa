package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMethods {
	static Logger logger = LogManager.getLogger();
	@AfterMethod
	public static void afterMethod() {
		logger.info("运行AfterMethod");
	}
	@Test
	public static void testtes1() {
		logger.info("运行testMethodstes1");
	}
	@Test
	public static void testtes2() {
		logger.info("运行testMethodstes2");
	}
	@BeforeMethod
	public static void beforeMethod() {
		logger.info("运行BeforeMethod");
	}
}
