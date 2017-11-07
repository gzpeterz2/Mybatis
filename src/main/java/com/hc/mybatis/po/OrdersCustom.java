/**  
 * Project Name:Mybatis  
 * File Name:OrdersCustom.java  
 * Package Name:com.hc.mybatis.po  
 * Date:2017年11月7日上午10:07:04  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.po;  
/**  
 * ClassName:OrdersCustom <br/>  
 * Date:     2017年11月7日 上午10:07:04 <br/>  
 * @author   zhangwen  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public class OrdersCustom extends Orders {
	private String username;
	private String sex;
	private String address;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", sex=" + sex + ", address=" + address + ", toString()="
				+ super.toString() + "]";
	}

}
  
