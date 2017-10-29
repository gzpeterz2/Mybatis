package com.hc.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hc.mybatis.po.Student;

public class FirstTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testSelectById() {
		// System.out.println("here is ");
		// StudentDaoImpl dao = new StudentDaoImpl(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Student student = null;
		student = sqlSession.selectOne("test.selectById", 2);
		assertTrue(student != null);
		
		sqlSession.close();
		System.out.println(student);
	}
}
