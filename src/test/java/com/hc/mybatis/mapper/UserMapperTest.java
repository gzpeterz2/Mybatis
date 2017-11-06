/**  
 * Project Name:Mybatis  
 * File Name:UserMapperTest.java  
 * Package Name:com.hc.mybatis.mapper  
 * Date:2017年11月5日下午9:45:16  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hc.mybatis.po.User;

/**  
 * ClassName:UserMapperTest <br/>  
 * Date:     2017年11月5日 下午9:45:16 <br/>  
 * @author   zhangwen  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class UserMapperTest {
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testSelectById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = null;
		try {
			user = mapper.selectById(10);
		} catch (SQLException e) {
			e.printStackTrace();  
		}
		sqlSession.close();
		System.out.println(user);
	}

	@Test
	public void testSelectLikeName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = null;
		try {
			list = mapper.selectLikeName("小明");
		} catch (SQLException e) {
			e.printStackTrace();  
		}
		sqlSession.close();
		System.out.println(list);
	}

	@Test
	public void testInsert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("peter" + (int)(Math.random()*100));
		user.setSex(1);
		user.setBirthday(new Date());
		try {
			mapper.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();  
		}
		sqlSession.commit();
		sqlSession.close();
		System.out.println(user);
	}

	@Test
	public void testUpdate() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();

		try {
			user.setId(26);
			user.setUsername("Tiger");
			user.setAddress("this is in hainan 100 num");
			mapper.update(user);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// assertEquals("Tiger", selectUser.getUsername());
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDelete() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("peter" + (int)(Math.random()*100));
		user.setSex(1);
		user.setBirthday(new Date());
		try {
			mapper.insert(user);
			sqlSession.commit();
			mapper.delete(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();  
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
  
