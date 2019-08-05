package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.biz.PermissionroleBiz;
import com.example.demo.entity.Permissionrole;
import com.example.demo.utils.ConstantUtil;


/**
 * 控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
public class PermissionroleController extends BaseController {

	@Resource
	private PermissionroleBiz permissionroleBiz;
	
	/**
	 * 角色权限分配
	 */
	@RequestMapping(value = "manage/addpermissionroleList")
	public String addpermissionroleList(HttpServletResponse response, Model model){
		Map<String,Object> map = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject();
		try{
			List<Permissionrole> permissionroles = new ArrayList<Permissionrole>();
			String rid = request.getParameter("rid");
			if(StringUtils.isNotBlank(rid)){
				map.put("rid", rid);
			}
			permissionroleBiz.deletePermissionrole(map);
			String permissionId = request.getParameter("permissionId");
			String[] ti=null;
			if(StringUtils.isNotBlank(permissionId)){
				ti = permissionId.split(",");
				for(String title:ti){
					Permissionrole permissionrole = new Permissionrole();
					permissionrole.setRid(Integer.parseInt(rid));
					permissionrole.setPermissionId(Integer.parseInt(title));
					permissionroles.add(permissionrole);
				}
				jsonObject = permissionroleBiz.insertPermissionroleList(permissionroles);
			}
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, e.getMessage());
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 查询Permissionrole集合
	 */
	@RequestMapping(value = "/manage/permissionroleList")
	public String permissionroleList(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,Object> map=initMap(request);
			String permissionId=request.getParameter("permissionId");
			if (StringUtils.isNotBlank(permissionId)) {
				map.put("permissionId", permissionId);
			}
			String rid=request.getParameter("rid");
			if (StringUtils.isNotBlank(rid)) {
				map.put("rid", rid);
			}
			jsonObject=permissionroleBiz.permissionroleList(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 根据id查询Permissionrole
	 */
	@RequestMapping(value = "/manage/permissionroleById")
	public String permissionroleById(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String id = request.getParameter("id");
			jsonObject = permissionroleBiz.permissionroleById(id);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 新增Permissionrole
	 */
	@RequestMapping(value = "/manage/addPermissionrole")
	public String addPermissionrole(Permissionrole permissionrole, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = permissionroleBiz.insertPermissionrole(permissionrole);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 修改Permissionrole
	 */
	@RequestMapping(value = "/manage/updatePermissionrole")
	public String updatePermissionrole(Permissionrole permissionrole, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = permissionroleBiz.updatePermissionrole(permissionrole);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 删除Permissionrole
	 */
	@RequestMapping(value = "/manage/deletePermissionrole")
	public String deletePermissionrole(HttpServletResponse response, Model model) {
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
				jsonObject= permissionroleBiz.deletePermissionrole(map);
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