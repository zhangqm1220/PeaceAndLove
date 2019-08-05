package com.example.demo.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import com.example.demo.utils.ConstantUtil;

/**
 * 业务处理类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class RoleBiz {

	@Resource
	private RoleService roleService;

	/**
	 * 查询Role集合
	 */
	public JSONObject roleList(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<Role> roles = roleService.selectRoleList(map);
		int total = roleService.selectRoleListCount(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, roles);
		jsonObject.put(ConstantUtil.KEY_TOTAL, total);
		return jsonObject;
	}

	/**
	 * 根据id查询Role
	 */
	public JSONObject roleById(String id) throws Exception{
		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			Role role = roleService.selectRoleById(Integer.parseInt(id));
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
			jsonObject.put(ConstantUtil.KEY_RESULT, role);
		} else {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
			jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
		}
		return jsonObject;
	}

	/**
	 * 新增Role
	 */
	public JSONObject insertRole(Role role) throws Exception{
		JSONObject jsonObject=new JSONObject();
		roleService.insertRole(role);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 修改Role
	 */
	public JSONObject updateRole(Role role) throws Exception{
		JSONObject jsonObject=new JSONObject();
		roleService.updateRole(role);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "修改成功");
		return jsonObject;
	}

	/**
	 * 删除Role
	 */
	public JSONObject deleteRole(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		roleService.deleteRole(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "删除成功");
		return jsonObject;
	}

}