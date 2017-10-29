package com.hc.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hc.mybatis.po.Student;

public class StudentDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindStudentById() {
		System.out.println("here is ");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Student student = null;
		student = sqlSession.selectOne("test.findStudentById", 2);
		
		sqlSession.close();
		System.out.println(student);
	}

}
