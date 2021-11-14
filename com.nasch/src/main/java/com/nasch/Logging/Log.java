package com.nasch.Logging;

import org.apache.logging.log4j.*;

public class Log {
	private static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		logMethod();
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	// logging levels
	public static void logMethod() {
		logger.trace("TRACE LOG!");		// performing a transaction to specify the information
		logger.debug("DEBUG LOG!");
		logger.info("INFO LOG!");
		logger.warn("WARN LOG!");
		logger.error("ERROR LOG!");
		logger.fatal("FATAL LOG!");
		
	}
}
