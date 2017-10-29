package com.hc.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hc.mybatis.po.Student;

/**
 * 
* @Title: StudentDaoImplTest.java
* @ClassName: StudentDaoImplTest 
* @Description: 功能是  单元测试
* @author 海辰 张文   
* @date 2017年10月29日 下午7:30:59
* @version V1.0
 */
public class StudentDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
		StudentDaoImpl dao = new StudentDaoImpl(sqlSessionFactory);
		Student student = null;
		try {
			student = dao.selectById(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(student != null);
		System.out.println(student);
	}

	@Ignore
	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSelectByName() {
		fail("Not yet implemented");
	}

}
