package com.example.demo.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Permissionrole;
import com.example.demo.service.PermissionroleService;
import com.example.demo.utils.ConstantUtil;

/**
 * 业务处理类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class PermissionroleBiz {

	@Resource
	private PermissionroleService permissionroleService;
	
	/**
	 * 批量插入Permissionrole
	 */
	public JSONObject insertPermissionroleList(List<Permissionrole> permissionroles) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionroleService.insertPermissionroleList(permissionroles);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 查询Permissionrole集合
	 */
	public JSONObject permissionroleList(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<Permissionrole> permissionroles = permissionroleService.selectPermissionroleList(map);
		int total = permissionroleService.selectPermissionroleListCount(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, permissionroles);
		jsonObject.put(ConstantUtil.KEY_TOTAL, total);
		return jsonObject;
	}

	/**
	 * 根据id查询Permissionrole
	 */
	public JSONObject permissionroleById(String id) throws Exception{
		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			Permissionrole permissionrole = permissionroleService.selectPermissionroleById(Integer.parseInt(id));
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
			jsonObject.put(ConstantUtil.KEY_RESULT, permissionrole);
		} else {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
			jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
		}
		return jsonObject;
	}

	/**
	 * 新增Permissionrole
	 */
	public JSONObject insertPermissionrole(Permissionrole permissionrole) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionroleService.insertPermissionrole(permissionrole);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 修改Permissionrole
	 */
	public JSONObject updatePermissionrole(Permissionrole permissionrole) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionroleService.updatePermissionrole(permissionrole);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "修改成功");
		return jsonObject;
	}

	/**
	 * 删除Permissionrole
	 */
	public JSONObject deletePermissionrole(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionroleService.deletePermissionrole(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "删除成功");
		return jsonObject;
	}

}