/**  
 * Project Name:Mybatis  
 * File Name:UserMapperTest.java  
 * Package Name:com.hc.mybatis.mapper  
 * Date:2017年11月5日下午9:45:16  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.mapper;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hc.mybatis.po.NewUser;
import com.hc.mybatis.po.User;
import com.hc.mybatis.po.UserCustom;
import com.hc.mybatis.po.UserQueryVo;

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
	public void testSelectRM() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		NewUser newUser = new NewUser();
		try {
			newUser = mapper.selectRM(10);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(newUser);
	}

	@Test
	public void testSecondCache() throws SQLException {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();

		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		
		mapper1.selectById(10);
		// 这里 必须 关闭 session， 否则 sqlsession 里面缓存的 东西进入不了二级缓存
		sqlSession1.close();

		mapper2.selectById(10);
		sqlSession2.close();
	}
	
	@Test
	public void testCountTable() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int num = 0;
		try {
			UserCustom userCustom = new UserCustom();
			userCustom.setBeginId(20);
			userCustom.setEndId(40);
			num = mapper.countTable(userCustom);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(num);
	}
	
	@Test
	public void testSelectDSQL() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = null;
		try {
			UserCustom userCustom = new UserCustom();
			userCustom.setBeginId(20);
			userCustom.setEndId(40);
			userCustom.setUsername("小明");
			list = mapper.selectDSQL(userCustom);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(list);
	}
	
	@Test
	public void testSelectForeach() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = null;
		try {
			UserCustom userCustom = new UserCustom();
			List<Integer> list = new ArrayList<Integer>();
			list.add(10);
			list.add(50);
			list.add(51);
			userCustom.setList(list);
			userList = mapper.selectForeach(userCustom);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(userList);
	}
		
	@Test
	public void testSelectBetween() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = null;
		try {
			UserCustom userCustom = new UserCustom();
			userCustom.setBeginId(20);
			userCustom.setEndId(40);
			list = mapper.selectBetween(userCustom);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(list);
	}
	
	@Test
	public void testSelectBetween2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = null;
		try {
			UserCustom userCustom = new UserCustom();
			userCustom.setBeginId(40);
			userCustom.setEndId(80);
			UserQueryVo userQueryVo = new UserQueryVo();
			userQueryVo.setUserCustom(userCustom);
			
			list = mapper.selectBetween2(userQueryVo);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(list);
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
		} finally {
			sqlSession.close();
		}
		System.out.println(user);
	}
	
	@Test
	public void testFistCache() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = null;
		User user2 = null;

		try {
			user = mapper.selectById(10);
			System.out.println(user);
			
			// user.setAddress("hainan");
			// user.setId(40);
			// mapper.update(user);

			user2 = mapper.selectById(10);
			System.out.println(user2);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
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
		} finally {
			sqlSession.close();
		}
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
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
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
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// assertEquals("Tiger", selectUser.getUsername());
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
			sqlSession.commit();
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
	}
}
  
