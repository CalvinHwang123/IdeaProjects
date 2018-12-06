package com.shinedeer.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.trace("这是 trace 级别");
		logger.debug("这是 debug 级别");
		logger.info("这是 info 级别");
		logger.warn("这是 warn 级别");
		logger.error("这是 error 级别");
	}

}
