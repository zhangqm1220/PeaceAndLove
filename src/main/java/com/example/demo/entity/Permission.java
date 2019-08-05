package com.example.demo.entity;

/**
 * 实体类
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class Permission { 

	private Integer id;	//
	private String name;	//权限名称
	private Integer rank;	//排序号
	private Integer pId;	//父Id
	private String url;	//地址
	private String remark;	//备注
	private Integer type;	//类型
	private String icon;	//图标
	private Integer state;	//有效状态0，有效，1无效

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

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) { 
		this.rank = rank;
	}

	public Integer getPId() {
		return pId;
	}

	public void setPId(Integer pId) { 
		this.pId = pId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) { 
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) { 
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) { 
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) { 
		this.icon = icon;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) { 
		this.state = state;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ",name=" + name + ",rank=" + rank + ",pId=" + pId + ",url=" + url + ",remark=" + remark + ",type=" + type + ",icon=" + icon + ",state=" + state + "]";
	}
}