package com.hc.mybatis.mapper;

import java.sql.SQLException;
import java.util.List;

import com.hc.mybatis.po.NewUser;
import com.hc.mybatis.po.User;
import com.hc.mybatis.po.UserCustom;
import com.hc.mybatis.po.UserQueryVo;

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
	//  select 查询 ID 在之间的 用户
	public List<User> selectBetween(UserCustom userCustom) throws SQLException;
	// 使用 包装类
	public List<User> selectBetween2(UserQueryVo userQueryVo) throws SQLException;

	// 返回 表里面的数据 条数
	public int countTable(UserCustom userCustom) throws SQLException;

	public NewUser selectRM(Integer id) throws SQLException;
	
	// 动态sql
	public List<User> selectDSQL(UserCustom userCustom) throws SQLException;

	// foreach  
	public List<User> selectForeach(UserCustom userCustom) throws SQLException;

	public boolean insert(User user) throws SQLException;
	public boolean update(User user) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
