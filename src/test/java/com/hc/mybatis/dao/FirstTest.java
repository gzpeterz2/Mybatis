package com.hc.mybatis.dao;

import static org.junit.Assert.assertTrue;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hc.mybatis.po.User;

public class FirstTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testSelectById() {
		// System.out.println("here is ");
		// UserDaoImpl dao = new UserDaoImpl(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = null;
		user = sqlSession.selectOne("test.selectById", 10);
		// assertTrue(user != null);
		
		sqlSession.close();
		System.out.println(user);
	}
}
