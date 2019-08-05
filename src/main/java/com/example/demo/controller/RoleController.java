package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.biz.RoleBiz;
import com.example.demo.entity.Role;
import com.example.demo.utils.ConstantUtil;


/**
 * 控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
public class RoleController extends BaseController {

	@Resource
	private RoleBiz roleBiz;

	/**
	 * 查询Role集合
	 */
	@RequestMapping(value = "/manage/roleList")
	public String roleList(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,Object> map=initMap(request);
			String name=request.getParameter("name");
			if (StringUtils.isNotBlank(name)) {
				map.put("name", name);
			}
			String state=request.getParameter("state");
			if (StringUtils.isNotBlank(state)) {
				map.put("state", state);
			}
			jsonObject=roleBiz.roleList(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 根据id查询Role
	 */
	@RequestMapping(value = "/manage/roleById")
	public String roleById(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String id = request.getParameter("id");
			jsonObject = roleBiz.roleById(id);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 新增Role
	 */
	@RequestMapping(value = "/manage/addRole")
	public String addRole(Role role, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = roleBiz.insertRole(role);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 修改Role
	 */
	@RequestMapping(value = "/manage/updateRole")
	public String updateRole(Role role, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = roleBiz.updateRole(role);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 删除Role
	 */
	@RequestMapping(value = "/manage/deleteRole")
	public String deleteRole(HttpServletResponse response, Model model) {
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
				jsonObject= roleBiz.deleteRole(map);
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