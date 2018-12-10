package com.shinedeer;

import com.shinedeer.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFullLearningApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean flag = ioc.containsBean("helloService");
        System.out.println(flag);
    }

    @Test
    public void contextLoads() {

        System.out.println(person);

    }

    @Test
    public void testLog() {

        Logger logger = LoggerFactory.getLogger(getClass());

        // 日志级别由低到高为 track < debug < info < warn < error
        logger.trace("这是 trace 日志");
        logger.debug("这是 debug 日志");
        logger.info("这是 info 日志");
        logger.warn("这是 warn 日志");
        logger.error("这是 error 日志");

        // 待项目上线时，可以调高日志级别，这样日志只会输出 warn error 等级别的信息
        // Spring Boot 默认日志级别为 info, 所以会输出 info warn 和 error 的信息， debug 级别的信息不会输出

    }

}
