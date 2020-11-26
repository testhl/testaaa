package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestTTTT {
	static Logger logger = LogManager.getLogger();
	
	@Test(groups = "A")
	public static void testA() {
		logger.info("运行TestA");
	}
	@Test(groups="B")
	public static void testB() {
		logger.info("运行TestB");
	}
}
