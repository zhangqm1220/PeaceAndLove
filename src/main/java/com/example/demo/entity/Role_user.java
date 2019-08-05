package com.example.demo.entity;

/**
 * 实体类
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class Role_user { 

	private Integer id;	//
	private Integer rid;	//
	private Integer uid;	//
	private Integer state;	//

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { 
		this.id = id;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) { 
		this.rid = rid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) { 
		this.uid = uid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) { 
		this.state = state;
	}

	@Override
	public String toString() {
		return "Role_user [id=" + id + ",rid=" + rid + ",uid=" + uid + ",state=" + state + "]";
	}
}