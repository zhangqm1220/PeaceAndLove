package com.example.demo.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Syslog;
import com.example.demo.service.SyslogService;
import com.example.demo.utils.ConstantUtil;

/**
 * 系统日志业务处理类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class SyslogBiz {

	@Resource
	private SyslogService syslogService;
	
	/**
	 * 查询Syslog集合
	 */
	public List<Syslog> selectSyslogList(Map<String, Object> map) throws Exception{
		List<Syslog> syslogs = syslogService.selectSyslogList(map);
		return syslogs;
	}

	/**
	 * 查询Syslog集合
	 */
	public JSONObject syslogList(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<Syslog> syslogs = syslogService.selectSyslogList(map);
		int total = syslogService.selectSyslogListCount(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, syslogs);
		jsonObject.put(ConstantUtil.KEY_TOTAL, total);
		return jsonObject;
	}

	/**
	 * 根据num查询Syslog
	 */
	public JSONObject syslogByNum(String num) throws Exception{
		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isNotBlank(num)) {
			Syslog syslog = syslogService.selectSyslogByNum(num);
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
			jsonObject.put(ConstantUtil.KEY_RESULT, syslog);
		} else {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
			jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
		}
		return jsonObject;
	}

	/**
	 * 新增Syslog
	 */
	public JSONObject insertSyslog(Syslog syslog) throws Exception{
		JSONObject jsonObject=new JSONObject();
		syslogService.insertSyslog(syslog);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 修改Syslog
	 */
	public JSONObject updateSyslog(Syslog syslog) throws Exception{
		JSONObject jsonObject=new JSONObject();
		syslogService.updateSyslog(syslog);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "修改成功");
		return jsonObject;
	}

	/**
	 * 删除Syslog
	 */
	public JSONObject deleteSyslog(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		syslogService.deleteSyslog(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "删除成功");
		return jsonObject;
	}

}