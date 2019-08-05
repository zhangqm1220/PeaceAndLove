package com.example.demo.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Role_user;
import com.example.demo.service.Role_userService;
import com.example.demo.utils.ConstantUtil;

/**
 * 业务处理类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class Role_userBiz {

	@Resource
	private Role_userService role_userService;
	
	public List<Role_user> userroleList(Map<String, Object> map) throws Exception{
		List<Role_user> staffroles = role_userService.selectRole_userList(map);
		return staffroles;
	}

	/**
	 * 查询Role_user集合
	 */
	public JSONObject role_userList(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<Role_user> role_users = role_userService.selectRole_userList(map);
		int total = role_userService.selectRole_userListCount(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, role_users);
		jsonObject.put(ConstantUtil.KEY_TOTAL, total);
		return jsonObject;
	}

	/**
	 * 根据id查询Role_user
	 */
	public JSONObject role_userById(String id) throws Exception{
		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			Role_user role_user = role_userService.selectRole_userById(Integer.parseInt(id));
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
			jsonObject.put(ConstantUtil.KEY_RESULT, role_user);
		} else {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
			jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
		}
		return jsonObject;
	}

	/**
	 * 新增Role_user
	 */
	public JSONObject insertRole_user(Role_user role_user) throws Exception{
		JSONObject jsonObject=new JSONObject();
		role_userService.insertRole_user(role_user);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 修改Role_user
	 */
	public JSONObject updateRole_user(Role_user role_user) throws Exception{
		JSONObject jsonObject=new JSONObject();
		role_userService.updateRole_user(role_user);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "修改成功");
		return jsonObject;
	}

	/**
	 * 删除Role_user
	 */
	public JSONObject deleteRole_user(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		role_userService.deleteRole_user(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "删除成功");
		return jsonObject;
	}

}