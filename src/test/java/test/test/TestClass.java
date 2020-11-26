package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "A")
public class TestClass {
	static Logger logger = LogManager.getLogger();
	
	@BeforeClass
	public static void beforeC() {
		logger.info("运行BeforeClass");
	}
	@Test
	public static void testClasstes1() {
		logger.info("运行testClasstes1");
	}
	@Test
	public static void testClasstes2() {
		logger.info("运行testClasstes2");
	}
	@AfterClass
	public static void afterC() {
		logger.info("运行AfterClass");
	}

}
