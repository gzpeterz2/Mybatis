package com.hc.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 
* @Title: DAO.java
* @ClassName: DAO 
* @Description: 功能是 基本dao 模型
* @author 海辰 张文   
* @date 2017年10月29日 下午6:55:02
* @version V1.0
* @param <T>  T 是对象类型
 * @param <ID>  ID 是key
 */
public interface  DAO<T, ID> {
	public boolean insert(T entity) throws SQLException;
	public boolean update(T entity) throws SQLException;
	public boolean deleteById(ID id) throws SQLException;
	public T selectById(ID id) throws SQLException;
	public List<T> selectAll() throws SQLException;
}
