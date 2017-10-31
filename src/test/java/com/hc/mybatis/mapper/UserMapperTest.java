package com.hc.mybatis.mapper;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hc.mybatis.po.User;

public class UserMapperTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("in before class");
	}
	
	@Ignore
	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectById() throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = mapper.selectById(22);
		
		assertTrue(user != null);
		System.out.println(user);
	}
}
