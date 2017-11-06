/**  
 * Project Name:Mybatis  
 * File Name:UserCustom.java  
 * Package Name:com.hc.mybatis.po  
 * Date:2017年11月6日下午2:38:21  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.hc.mybatis.po;

import java.util.List;

/**  
 * ClassName:UserCustom <br/>  
 * Date:     2017年11月6日 下午2:38:21 <br/>  
 * @author   zhangwen  
 * @version    
 * @since    JDK 1.6  
 */
public class UserCustom  extends User {
	private int beginId;
	private  int endId;
	private List<Integer> list;

	public int getBeginId() {
		return beginId;
	}
	public void setBeginId(int beginId) {
		this.beginId = beginId;
	}
	public int getEndId() {
		return endId;
	}
	public void setEndId(int endId) {
		this.endId = endId;
	}

	@Override
	public String toString() {
		return "UserCustom [beginId=" + beginId + ", endId=" + endId + "]"
				+ super.toString();
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
}
  
