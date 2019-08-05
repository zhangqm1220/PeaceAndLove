package com.example.demo.entity;

/**
 * 系统日志实体类
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class Syslog { 

	private String num;	//
	private Integer userNum;	//
	private String operateName;	//
	private String operateUrl;	//
	private String description;	//
	private String ip;	//
	private String port;	//
	private Integer customerType;	//
	private Integer type;	//
	private String createTime;	//
	private Integer state;	//
	private String sessionkey;	//
	private Integer closeStatus;	//
	private User user;//

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) { 
		this.num = num;
	}

	public Integer getUserNum() {
		return userNum;
	}

	public void setUserNum(Integer userNum) { 
		this.userNum = userNum;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) { 
		this.operateName = operateName;
	}

	public String getOperateUrl() {
		return operateUrl;
	}

	public void setOperateUrl(String operateUrl) { 
		this.operateUrl = operateUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) { 
		this.description = description;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) { 
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) { 
		this.port = port;
	}

	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) { 
		this.customerType = customerType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) { 
		this.type = type;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) { 
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) { 
		this.state = state;
	}

	public String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(String sessionkey) { 
		this.sessionkey = sessionkey;
	}

	public Integer getCloseStatus() {
		return closeStatus;
	}

	public void setCloseStatus(Integer closeStatus) { 
		this.closeStatus = closeStatus;
	}

	@Override
	public String toString() {
		return "Syslog [num=" + num + ", userNum=" + userNum + ", operateName=" + operateName + ", operateUrl="
				+ operateUrl + ", description=" + description + ", ip=" + ip + ", port=" + port + ", customerType="
				+ customerType + ", type=" + type + ", createTime=" + createTime + ", state=" + state + ", sessionkey="
				+ sessionkey + ", closeStatus=" + closeStatus + ", user=" + user + "]";
	}

}