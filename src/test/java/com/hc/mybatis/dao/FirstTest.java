package com.hc.mybatis.dao;

import static org.junit.Assert.assertTrue;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hc.mybatis.po.User;

/**
 * 
* @Title: FirstTest.java
* @ClassName: FirstTest 
* @Description: mybatis 的 第一个 程序 
* @author 海辰 张文   
* @date 2017年10月30日 下午3:00:26
* @version V1.0
 */
public class FirstTest {

	// 会话 工厂
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void init() throws Exception {
		// 定义资源文件
		String resource = "SqlMapConfig.xml";
		
		// 创建输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 建立会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testSelectById() {
		// 通过 会话工厂 生成 sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过 sqlSession 操作 数据库
		// 第一个参数 statement 由 xml 的  namespace + statement 的ID
		// 第二个参数 是 输入 参数
		User user = sqlSession.selectOne("test.selectById", 10);
		
		sqlSession.close();
		System.out.println(user);
	}
}
