package com.example.demo.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import com.example.demo.utils.ConstantUtil;

/**
 * 业务处理类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class PermissionBiz {

	@Resource
	private PermissionService permissionService;
	
	/**
	 * 三级菜单的绑定
	 */
	public JSONObject selectCurrentRolePerssionList(Map<String,Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<Permission> permissions =permissionService.selectCurrentRolePerssionList(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE,200);
		jsonObject.put(ConstantUtil.KEY_RESULT, permissions);
		return jsonObject;
	}
	
	/**
	 * 权限树状显示
	 */
	public JSONObject selectPermissionBypId(Map<String,Object> map) throws Exception{
		JSONObject jsonObject = new JSONObject();
		List<Permission> permissions = permissionService.selectPermissionBypId(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, permissions);
		return jsonObject;
	}

	/**
	 * 查询Permission集合
	 */
	public JSONObject permissionList(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<Permission> permissions = permissionService.selectPermissionList(map);
		int total = permissionService.selectPermissionListCount(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, permissions);
		jsonObject.put(ConstantUtil.KEY_TOTAL, total);
		return jsonObject;
	}

	/**
	 * 根据id查询Permission
	 */
	public JSONObject permissionById(String id) throws Exception{
		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			Permission permission = permissionService.selectPermissionById(Integer.parseInt(id));
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
			jsonObject.put(ConstantUtil.KEY_RESULT, permission);
		} else {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
			jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
		}
		return jsonObject;
	}

	/**
	 * 新增Permission
	 */
	public JSONObject insertPermission(Permission permission) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionService.insertPermission(permission);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 修改Permission
	 */
	public JSONObject updatePermission(Permission permission) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionService.updatePermission(permission);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "修改成功");
		return jsonObject;
	}

	/**
	 * 删除Permission
	 */
	public JSONObject deletePermission(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		permissionService.deletePermission(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "删除成功");
		return jsonObject;
	}

}