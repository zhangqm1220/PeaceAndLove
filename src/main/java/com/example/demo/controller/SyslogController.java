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
import com.example.demo.biz.SyslogBiz;
import com.example.demo.entity.Syslog;
import com.example.demo.utils.ConstantUtil;


/**
 * 系统日志控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
public class SyslogController extends BaseController {

	@Resource
	private SyslogBiz syslogBiz;

	/**
	 * 查询Syslog集合
	 */
	@RequestMapping(value = "/manage/syslogList")
	public String syslogList(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,Object> map=initMap(request);
			String num=request.getParameter("num");
			if (StringUtils.isNotBlank(num)) {
				map.put("num", num);
			}
			String userNum=request.getParameter("userNum");
			if (StringUtils.isNotBlank(userNum)) {
				map.put("userNum", userNum);
			}
			String operateName=request.getParameter("operateName");
			if (StringUtils.isNotBlank(operateName)) {
				map.put("operateName", operateName);
			}
			String operateUrl=request.getParameter("operateUrl");
			if (StringUtils.isNotBlank(operateUrl)) {
				map.put("operateUrl", operateUrl);
			}
			String description=request.getParameter("description");
			if (StringUtils.isNotBlank(description)) {
				map.put("description", description);
			}
			String ip=request.getParameter("ip");
			if (StringUtils.isNotBlank(ip)) {
				map.put("ip", ip);
			}
			String port=request.getParameter("port");
			if (StringUtils.isNotBlank(port)) {
				map.put("port", port);
			}
			String customerType=request.getParameter("customerType");
			if (StringUtils.isNotBlank(customerType)) {
				map.put("customerType", customerType);
			}
			String type=request.getParameter("type");
			if (StringUtils.isNotBlank(type)) {
				map.put("type", type);
			}
			String createTime=request.getParameter("createTime");
			if (StringUtils.isNotBlank(createTime)) {
				map.put("createTime", createTime);
			}
			String state=request.getParameter("state");
			if (StringUtils.isNotBlank(state)) {
				map.put("state", state);
			}
			String sessionkey=request.getParameter("sessionkey");
			if (StringUtils.isNotBlank(sessionkey)) {
				map.put("sessionkey", sessionkey);
			}
			String closeStatus=request.getParameter("closeStatus");
			if (StringUtils.isNotBlank(closeStatus)) {
				map.put("closeStatus", closeStatus);
			}
			jsonObject=syslogBiz.syslogList(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 根据num查询Syslog
	 */
	@RequestMapping(value = "/manage/syslogByNum")
	public String syslogByNum(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String num = request.getParameter("num");
			jsonObject = syslogBiz.syslogByNum(num);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 新增Syslog
	 */
	@RequestMapping(value = "/manage/addSyslog")
	public String addSyslog(Syslog syslog, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = syslogBiz.insertSyslog(syslog);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 修改Syslog
	 */
	@RequestMapping(value = "/manage/updateSyslog")
	public String updateSyslog(Syslog syslog, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = syslogBiz.updateSyslog(syslog);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 删除Syslog
	 */
	@RequestMapping(value = "/manage/deleteSyslog")
	public String deleteSyslog(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String num = request.getParameter("num");
			String nums = request.getParameter("nums");
			if (StringUtils.isNotBlank(num) || StringUtils.isNotBlank(nums)) {
				Map<String,Object> map=new HashMap<String, Object>();
				if (StringUtils.isNotBlank(num)) {
					map.put("num",num);
				}
				if (StringUtils.isNotBlank(nums)) {
					map.put("nums",nums);
				}
				jsonObject= syslogBiz.deleteSyslog(map);
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