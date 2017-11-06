package com.hc.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hc.mybatis.po.User;

/**
 * 
* @Title: UserDaoImpl.java
* @ClassName: UserDaoImpl 
* @Description: 功能是 student dao 的实现
* @author 海辰 张文   
* @date 2017年10月29日 下午7:06:17
* @version V1.0
 */
public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public User selectById(Integer id) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//第一个参数 是  namespace +  statementID
		//第二个参数  就是 我们的 输入参数
		User user = sqlSession.selectOne("test.selectById", id);
		sqlSession.close();
		return user;
	}

	public List<User> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User user) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert("test.insert", user);
			// 必须提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			// 关闭 sqlSession
			sqlSession.close();
		}

		return true;
	}

	@Override
	public boolean update(User user) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update("test.update", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return true;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("test.delete", id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return true;
	}

	@Override
	public List<User> selectByName(String name) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// String nameOk = "%" + name + "%";
		//  List<User> list = sqlSession.selectList("test.selectByName", nameOk);
		List<User> list = sqlSession.selectList("test.selectByName2", name);
		sqlSession.close();
		return list;
	}

}
