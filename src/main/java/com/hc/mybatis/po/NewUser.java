/**  
 * Project Name:Mybatis  
 * File Name:NewUser.java  
 * Package Name:com.hc.mybatis.po  
 * Date:2017年11月6日下午5:40:48  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.po;

import java.util.Date;

public class NewUser {
   private Integer newId;
   private String newUsername;
   private Date newBirthday;
   private Integer newSex;
   private String newAddress;

   public Integer getNewId() {
	   return newId;
   }
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	public String getNewUsername() {
		return newUsername;
	}
	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}
	public Date getNewBirthday() {
		return newBirthday;
	}
	public void setNewBirthday(Date newBirthday) {
		this.newBirthday = newBirthday;
	}
	public Integer getNewSex() {
		return newSex;
	}
	public void setSex(Integer sex) {
		this.newSex = sex;
	}
	public String getNewAddress() {
		return newAddress;
	}
	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	@Override
	public String toString() {
		return "NewUser [newId=" + newId + ", newUsername=" + newUsername + ", newBirthday=" + newBirthday + ", sex="
				+ newSex + ", newAddress=" + newAddress + "]";
	}
}
  
