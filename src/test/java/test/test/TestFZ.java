package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestFZ {
	static Logger logger = LogManager.getLogger();
	
	@Test(invocationCount = 8)
	public static void testfz() {
		logger.info("负载测试");
	}
}
