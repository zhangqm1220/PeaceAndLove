package com.example.demo.entity;

/**
 * 实体类
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class Permissionrole { 

	private Integer id;	//
	private Integer permissionId;	//
	private Integer rid;	//

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { 
		this.id = id;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) { 
		this.permissionId = permissionId;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) { 
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Permissionrole [id=" + id + ",permissionId=" + permissionId + ",rid=" + rid + "]";
	}
}