package com.shinedeer.springboot;

import com.alibaba.druid.pool.DruidDataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private DruidDataSource dataSource;

	@Test
	public void contextLoads() throws SQLException {

		System.out.println("dataSource class: " + dataSource.getClass());

		Connection connection = dataSource.getConnection();
        System.out.println("connection: " + connection);

    }

}

