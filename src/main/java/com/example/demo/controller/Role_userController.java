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
import com.example.demo.biz.Role_userBiz;
import com.example.demo.entity.Role_user;
import com.example.demo.utils.ConstantUtil;


/**
 * 控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
public class Role_userController extends BaseController {

	@Resource
	private Role_userBiz role_userBiz;

	/**
	 * 查询Role_user集合
	 */
	@RequestMapping(value = "/manage/role_userList")
	public String role_userList(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,Object> map=initMap(request);
			String rid=request.getParameter("rid");
			if (StringUtils.isNotBlank(rid)) {
				map.put("rid", rid);
			}
			String uid=request.getParameter("uid");
			if (StringUtils.isNotBlank(uid)) {
				map.put("uid", uid);
			}
			String state=request.getParameter("state");
			if (StringUtils.isNotBlank(state)) {
				map.put("state", state);
			}
			jsonObject=role_userBiz.role_userList(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 根据id查询Role_user
	 */
	@RequestMapping(value = "/manage/role_userById")
	public String role_userById(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String id = request.getParameter("id");
			jsonObject = role_userBiz.role_userById(id);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 新增Role_user
	 */
	@RequestMapping(value = "/manage/addRole_user")
	public String addRole_user(Role_user role_user, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = role_userBiz.insertRole_user(role_user);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 修改Role_user
	 */
	@RequestMapping(value = "/manage/updateRole_user")
	public String updateRole_user(Role_user role_user, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = role_userBiz.updateRole_user(role_user);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 删除Role_user
	 */
	@RequestMapping(value = "/manage/deleteRole_user")
	public String deleteRole_user(HttpServletResponse response, Model model) {
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
				jsonObject= role_userBiz.deleteRole_user(map);
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