package com.example.demo.entity;

/**
 * 用户实体类
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class User { 

	private Integer id;	//
	private String name;	//姓名
	private String sex;	//性别
	private Integer age;	//年龄
	private String weid;	//微信id
	private String idcard;	//身份证账号
	private String phone;	//联系电话
	private String lastLoginTime;
	private String loginTime;
	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	private Integer state;	//

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) { 
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) { 
		this.age = age;
	}

	public String getWeid() {
		return weid;
	}

	public void setWeid(String weid) { 
		this.weid = weid;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) { 
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) { 
		this.phone = phone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) { 
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", weid=" + weid + ", idcard="
				+ idcard + ", phone=" + phone + ", lastLoginTime=" + lastLoginTime + ", loginTime=" + loginTime
				+ ", state=" + state + "]";
	}

	
}