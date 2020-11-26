package com.test.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerCon {

	//实例化log4j的log
	 Logger logger = LogManager.getLogger();
	@Test
	public void quitDriver() {
		logger.info("erro");
		logger.error("erro");
		logger.info("erro");
		logger.info("erro");
		logger.info("erro");
	}
	
}
