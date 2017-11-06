package com.hc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.hc.mybatis.po.Items;



public interface ItemsMapper {
	@Select ("select * from items where id = #{id}")
	public Items selectById(int id);

	@Delete ("delete from items where id=#{id} ")
	public void delete(int id);

	@Select ("select * fromn items")
	public List<Items> selectAll();
}

//public interface UserMapper {  
//    @Insert("insert into users(name, age) values(#{name}, #{age})")  
//    public int add(Users user);  
//      
//    @Delete("delete from users where id = #{id}")  
//    public int deleteById(int id);  
//      
//    @Update("update users set name = #{name}, age = #{age} where id = #{id}")  
//    public int update(Users user);  
//      
//    @Select("select * from users where id = #{id}")  
//    public Users getUserById(int id);  
//      
//    @Select("select * from users")  
//    public List<Users> getAllUsers();  
//}  