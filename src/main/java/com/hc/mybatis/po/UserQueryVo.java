/**  
 * Project Name:Mybatis  
 * File Name:UserQueryVo.java  
 * Package Name:com.hc.mybatis.po  
 * Date:2017年11月6日下午3:01:51  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.po;  
/**  
 * ClassName:UserQueryVo <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年11月6日 下午3:01:51 <br/>  
 * @author   zhangwen  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class UserQueryVo {
	private User user;
	private UserCustom userCustom;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

}
  
