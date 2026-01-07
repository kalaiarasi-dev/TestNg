package com.app.resuse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Test_Sample {
	 static final Logger logger = LogManager.getLogger(Test_Sample.class);
	@Test
	public void test1() {
		logger.info("test1");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test2() {
		logger.info("test2");
		Assert.assertTrue(true);
	}
	
	@Test
	public void test3() {
		logger.info("test3");
		Assert.assertTrue(true);
	}

}
