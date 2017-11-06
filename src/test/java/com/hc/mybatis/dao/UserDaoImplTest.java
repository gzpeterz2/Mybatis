package com.hc.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
	private static	UserDao dao ;

	@BeforeClass
	public static void init() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		dao = new UserDaoImpl(sqlSessionFactory);
		System.out.println("in before class");
	}
	
	/**
	 * 
	 * testSelectById:方法的作用是测试 selectById <br/>  
	 *  
	 * @author zhangwen    
	 * @since JDK 1.8
	 */
	@Test
	public void testSelectById() {
		User user = new User();
		user.setUsername("peter");
		user.setSex(1);
		user.setBirthday(new Date());
		int insert_id = 0;
		User selectUser = null;

		try {
			dao.insert(user);
			insert_id = user.getId();
			selectUser = dao.selectById(insert_id);
			dao.deleteById(insert_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("peter", selectUser.getUsername());
		System.out.println(user);
	}
	
	@Test
	public void testUpdate() {
		User user = new User();
		user.setUsername("peter");
		user.setSex(1);
		user.setBirthday(new Date());
		int insert_id = 0;
		User selectUser = null;

		try {
			dao.insert(user);
			insert_id = user.getId();
			user.setUsername("Tiger");
			user.setAddress("this is in hainan 100 num");
			dao.update(user);

			selectUser = dao.selectById(insert_id);
			dao.deleteById(insert_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("Tiger", selectUser.getUsername());
		System.out.println(selectUser);
	}
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("peter");
		user.setSex(1);
		user.setBirthday(new Date());

		try {
			dao.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(user != null);
		System.out.println(user);
	}
	
	@Test
	public void testDeleteById() {
		try {
			dao.deleteById(30);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectByName() {
		List<User> list = null;
		try {
			list = dao.selectByName("小明");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(list != null);
		System.out.println(list);
	}

	@Ignore
	@Test
	public void testSelectAll() {
		System.out.println("this is in select all");
	}

}
