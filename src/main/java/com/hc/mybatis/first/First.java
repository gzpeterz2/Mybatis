package com.hc.mybatis.first;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hc.mybatis.po.Student;

public class First {

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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Student student = null;
		student = sqlSession.selectOne("test.selectById", 2);
		
		sqlSession.close();
		System.out.println(student);
	}
}
