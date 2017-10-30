package com.hc.mybatis.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hc.mybatis.po.User;

/**
 * 
* @Title: UserDaoImplTest.java
* @ClassName: UserDaoImplTest 
* @Description: 功能是  单元测试
* @author 海辰 张文   
* @date 2017年10月29日 下午7:30:59
* @version V1.0
 */
public class UserDaoImplTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("in before class");
	}
	
	@Before
	public void before() {
		System.out.println("in before");
	}

	@Ignore
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectById() {
		UserDaoImpl dao = new UserDaoImpl(sqlSessionFactory);
		User user = null;
		try {
			user = dao.selectById(22);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(user != null);
		System.out.println(user);
	}

	@Test
	public void testSelectAll() {
		System.out.println("this is in select all");
	}

	@Ignore
	@Test
	public void testSelectByName() {
		fail("Not yet implemented");
	}

}
