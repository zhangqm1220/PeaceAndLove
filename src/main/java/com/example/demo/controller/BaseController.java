package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import com.example.demo.biz.SyslogBiz;
import com.example.demo.entity.Syslog;
import com.example.demo.entity.User;
import com.example.demo.utils.ConstantUtil;
import com.example.love.DateUtil;

/**
 * 基础工具控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
public class BaseController {
	protected HttpSession session;
	protected HttpServletRequest request;
	private PrintWriter out;
	
	@Resource
	private SyslogBiz syslogBiz;

	@Resource
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Resource
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * 数据输出
	 * @param response
	 * @param data 返回的数据
	 * @param contentType  返回数据类型
	 * json格式： application/json;charset=UTF-8
	 * html：text/html;charset=UTF-8
	 */
	public void output(HttpServletResponse response,String data,String contentType){
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType(contentType);
			out=response.getWriter();
			out.print(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取分页参数
	 */
	protected Map<String, Object> initMap(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String pageIndex = request.getParameter("pageIndex");
		if (StringUtils.isNotBlank(pageIndex)) {
			map.put("pageIndex", Integer.parseInt(pageIndex));
		}

		String pageSize = request.getParameter("pageSize");
		if (StringUtils.isNotBlank(pageSize)) {
			map.put("pageSize", Integer.parseInt(pageSize));
		}

		String sortname = request.getParameter("sortname");
		if (StringUtils.isNotBlank(sortname)) {
			map.put("sortname", sortname);
		}

		String sortorder = request.getParameter("sortorder");
		if (StringUtils.isNotBlank(sortorder)) {
			map.put("sortorder", sortorder);
		}
		return map;
	}

	/**
	 * 转换map
	 */
	protected static String setMap(Map<String, Object> map) {
		String message = "";
		if (map != null) {
			for (Entry<String, Object> entry : map.entrySet()) {
				message += entry.getKey() + "=" + entry.getValue() + "&";
			}
		}
		return message;
	}
	
	/**
	 * 获取在线用户信息
	 * @param userid
	 * @param operatename
	 * @param operateurl
	 * @param description
	 * @param sessionkey
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected User getUser(HttpServletRequest request) throws Exception{
		User user=null;
		String user_token="";
		Map<String,Object> map=new HashMap<String, Object>();
		String customerType=request.getParameter("customerType");
		if(StringUtils.isNotBlank(customerType) && !ConstantUtil.CUSTOMERTYPE_PC.equals(customerType)){
			//IOS或android
			user_token=request.getParameter("user_token");
		}else{
			//PC端
			customerType=ConstantUtil.CUSTOMERTYPE_PC;
			Cookie [] cookies=request.getCookies();
			if(cookies != null && cookies.length > 0){
				for(Cookie cookie : cookies){
					if("user_token".equals(cookie.getName())){
						user_token=cookie.getValue();
						break;
					}
				}
			}
			if(StringUtils.isBlank(user_token)){
				user_token=request.getParameter("user_token");
			}
		}
		if(StringUtils.isNotBlank(user_token)){
			//查询在线用户信息
			map.put("customerType", customerType);
			map.put("sessionkey", user_token);
			map.put("closeStatus", 0);
			map.put("type", 1);
			map.put("pageIndex", 1);
			map.put("pageSize", 1);
			List<Syslog> list=syslogBiz.selectSyslogList(map);
			if(list!=null && list.size()>0){
				user= list.get(0).getUser();
			}
		}
		return user;
	}
	
	//添加系统日志
	public  void insertSyslog(Syslog syslog,HttpServletRequest request){
		try {
			String user_token="";
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("user_token")) {
						user_token=cookie.getValue();
						break;
					}
				}
			}
			if(syslog.getUser()!=null){
				syslog.setUserNum(syslog.getUser().getId());
			}
			if(StringUtils.isBlank(syslog.getSessionkey())){
				if(StringUtils.isBlank(user_token)){
					user_token=request.getParameter("user_token");
				}
				syslog.setSessionkey(user_token);
			}
			
			String ip=request.getRemoteAddr();
			if(StringUtils.isNotBlank(ip)){
				syslog.setIp(ip);
			}
			
			int port=request.getRemotePort();
			syslog.setPort(String.valueOf(port));
			
			String customerType=request.getParameter("customerType");
			if(StringUtils.isNotBlank(customerType)){
				syslog.setCustomerType(Integer.parseInt(customerType));
			}else{
				syslog.setCustomerType(1);//PC端
			}
			
			syslog.setCreateTime(DateUtil.getDateTime());
			syslog.setCloseStatus(0);
			syslog.setState(0);
			UUID uuid=UUID.randomUUID();
			syslog.setNum(uuid.toString());
			syslogBiz.insertSyslog(syslog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}