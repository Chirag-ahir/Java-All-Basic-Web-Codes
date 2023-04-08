package com.miit.spb.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogClass {
	private static final Logger logger = LogManager.getLogger(LogClass.class);

	public void doSomething() {
		logger.info("Starting doSomething()");
	}
	
	public static void main(String[] args) {
		
	}
}
