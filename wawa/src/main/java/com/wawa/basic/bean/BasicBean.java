package com.wawa.basic.bean;

import java.io.Serializable;

/**
 * 父类bean
 * 
 * @author Yang Xiaodong 2013年12月3日 下午10:26:57
 */
public class BasicBean implements Serializable {
	private static final long serialVersionUID = 1054499933055241895L;
	/**
	 * 表ID varchar(8)
	 */
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
