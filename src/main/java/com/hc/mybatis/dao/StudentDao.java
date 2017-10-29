package com.hc.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import com.hc.mybatis.po.Student;

/**
 * 
* @Title: StudentDao.java
* @ClassName: StudentDao 
* @Description: 功能是 Student 的 Interface
* @author 海辰 张文   
* @date 2017年10月29日 下午6:57:58
* @version V1.0
 */
public interface StudentDao extends DAO<Student, Integer>{
	public List<Student> selectByName() throws SQLException;
}
