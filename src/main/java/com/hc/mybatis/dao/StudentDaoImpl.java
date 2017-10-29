package com.hc.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hc.mybatis.po.Student;

/**
 * 
* @Title: StudentDaoImpl.java
* @ClassName: StudentDaoImpl 
* @Description: 功能是 student dao 的实现
* @author 海辰 张文   
* @date 2017年10月29日 下午7:06:17
* @version V1.0
 */
public class StudentDaoImpl implements StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public boolean insert(Student entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Student entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Student selectById(Integer id) throws SQLException {
		Student student = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//第一个参数 是  namespace +  statementID
		//第二个参数  就是 我们的 输入参数
		student = sqlSession.selectOne("test.selectById", id);
		sqlSession.close();
		return student;
	}

	public List<Student> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> selectByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
