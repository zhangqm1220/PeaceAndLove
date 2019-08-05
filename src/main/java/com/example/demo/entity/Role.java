package com.example.demo.entity;

/**
 * 实体类
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class Role { 

	private Integer id;	//
	private String name;	//角色名称
	private String state;	//状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { 
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) { 
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) { 
		this.state = state;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ",name=" + name + ",state=" + state + "]";
	}
}