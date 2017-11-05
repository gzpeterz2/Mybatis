package com.hc.mybatis.dao;

import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
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
	* @Title: testSelectById 
	* @Description: TODO 
	* @param @param id
	* @param @param name    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void testSelectById(int id, String name) {
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

	@Test
	public void testSelectAll() {
		System.out.println("this is in select all");
	}

}
