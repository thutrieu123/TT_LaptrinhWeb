package model;

import org.apache.log4j.Logger;

public class Log4jTest {

	public static void main(String[] args) {

		final Logger logger = Logger.getLogger(Log4jTest.class);

		logger.debug("Chào 1");
		logger.info("Chao 2");
		logger.warn("Chao 3");
		logger.error("Chao 4");

	}
}
