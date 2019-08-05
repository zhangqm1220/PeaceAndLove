package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.biz.PermissionBiz;
import com.example.demo.biz.Role_userBiz;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role_user;
import com.example.demo.entity.User;
import com.example.demo.utils.ConstantUtil;


/**
 * 控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
public class PermissionController extends BaseController {

	@Resource
	private PermissionBiz permissionBiz;
	
	@Resource
	private Role_userBiz role_userBiz;

	/**
	 * 三级菜单的绑定
	 */
	@RequestMapping(value="/manage/selectCurrentRolePerssionList")
	public String selectCurrentRolePerssionList(HttpServletResponse response, Model model){
		JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> map2 = new HashMap<String, Object>();
		try {
			User staff = getUser(request);
			map.put("sid", staff.getId());
			List<Role_user> staffroles = role_userBiz.userroleList(map);
			map2.put("rid", staffroles.get(0).getRid());
			map2.put("pId", 0);
			jsonObject = permissionBiz.selectCurrentRolePerssionList(map2);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, e.getMessage());
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}
	
	/**
	 * 权限树状显示
	 */
	@RequestMapping(value="/manage/selectPermissionBypId")
	public String selectPermissionBypId(HttpServletResponse response, Model model){
		JSONObject jsonObject = new JSONObject();
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map.put("pId", 0);
			jsonObject = permissionBiz.selectPermissionBypId(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE,500);
			jsonObject.put(ConstantUtil.KEY_MSG, e.getMessage());
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}
	
	/**
	 * 查询Permission集合
	 */
	@RequestMapping(value = "/manage/permissionList")
	public String permissionList(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,Object> map=initMap(request);
			String name=request.getParameter("name");
			if (StringUtils.isNotBlank(name)) {
				map.put("name", name);
			}
			String rank=request.getParameter("rank");
			if (StringUtils.isNotBlank(rank)) {
				map.put("rank", rank);
			}
			String pId=request.getParameter("pId");
			if (StringUtils.isNotBlank(pId)) {
				map.put("pId", pId);
			}
			String url=request.getParameter("url");
			if (StringUtils.isNotBlank(url)) {
				map.put("url", url);
			}
			String remark=request.getParameter("remark");
			if (StringUtils.isNotBlank(remark)) {
				map.put("remark", remark);
			}
			String type=request.getParameter("type");
			if (StringUtils.isNotBlank(type)) {
				map.put("type", type);
			}
			String icon=request.getParameter("icon");
			if (StringUtils.isNotBlank(icon)) {
				map.put("icon", icon);
			}
			String state=request.getParameter("state");
			if (StringUtils.isNotBlank(state)) {
				map.put("state", state);
			}
			jsonObject=permissionBiz.permissionList(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 根据id查询Permission
	 */
	@RequestMapping(value = "/manage/permissionById")
	public String permissionById(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String id = request.getParameter("id");
			jsonObject = permissionBiz.permissionById(id);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 新增Permission
	 */
	@RequestMapping(value = "/manage/addPermission")
	public String addPermission(Permission permission, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = permissionBiz.insertPermission(permission);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 修改Permission
	 */
	@RequestMapping(value = "/manage/updatePermission")
	public String updatePermission(Permission permission, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = permissionBiz.updatePermission(permission);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 删除Permission
	 */
	@RequestMapping(value = "/manage/deletePermission")
	public String deletePermission(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String id = request.getParameter("id");
			String ids = request.getParameter("ids");
			if (StringUtils.isNotBlank(id) || StringUtils.isNotBlank(ids)) {
				Map<String,Object> map=new HashMap<String, Object>();
				if (StringUtils.isNotBlank(id)) {
					map.put("id",id);
				}
				if (StringUtils.isNotBlank(ids)) {
					map.put("ids",ids);
				}
				jsonObject= permissionBiz.deletePermission(map);
			} else {
				jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
				jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
			}
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

}