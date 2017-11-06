package com.hc.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import com.hc.mybatis.po.User;

/**
 * 
* @Title: UserDao.java
* @ClassName: UserDao 
* @Description: 功能是 User 的 Interface
* @author 海辰 张文   
* @date 2017年10月29日 下午6:57:58
* @version V1.0
 */
public interface UserMapper {
	// 返回单条 user
	public User selectById(Integer id) throws SQLException;
	// 返回基于 User 的 List 对象
	public List<User> selectLikeName(String username) throws SQLException;
	public boolean insert(User user) throws SQLException;
	public boolean update(User user) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
