/**  
 * Project Name:Mybatis  
 * File Name:OrdersMapperCustomTest.java  
 * Package Name:com.hc.mybatis.mapper  
 * Date:2017年11月7日上午10:24:02  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.mapper;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hc.mybatis.po.Orders;
import com.hc.mybatis.po.OrdersCustom;
import com.hc.mybatis.po.User;

/**  
 * ClassName:OrdersMapperCustomTest <br/>  
 * Date:     2017年11月7日 上午10:24:02 <br/>  
 * @author   zhangwen  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class OrdersCustomMapperTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	// 一对一 延迟加载  
	public void testSelectOrdersLazy() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<Orders> list = null;
		try {
			list = mapper.selectOrdersLazy();
			// System.out.println(list);
			int i = 0;
			User user = list.get(0).getUser();
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectOrdersUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<OrdersCustom> list = null;
		try {
			list = mapper.selectOrdersUserList();
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(list);
	}

	@Test
	public void testSelectOrdersUserListRM() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<Orders> list = null;
		try {
			list = mapper.selectOrdersUserListRM();
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(list);
	}
	
	@Test
	public void testSelectOrdersAndOrderdetail() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<Orders> list = null;
		try {
			list = mapper.selectOrdersAndOrderdetailRM();
		} catch (SQLException e) {
			e.printStackTrace();  
		} finally {
			sqlSession.close();
		}
		System.out.println(list);
		System.out.println(list.get(0).getOrderdetailList());
	}
}
  
