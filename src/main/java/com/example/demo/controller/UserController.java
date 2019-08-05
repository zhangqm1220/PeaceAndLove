package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Syslog;
import com.example.demo.entity.User;
import com.example.demo.biz.SyslogBiz;
import com.example.demo.biz.UserBiz;
import com.example.demo.utils.ConstantUtil;
import com.example.love.DateUtil;
import com.example.love.MD5;


/**
 * 用户控制器
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Controller
@RequestMapping("/mydb")
public class UserController extends BaseController {

	@Resource
	private UserBiz userBiz;
	
	@Resource
	private SyslogBiz syslogBiz;
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/dologin")
	public String userdologin(HttpServletResponse response, Model model){
		JSONObject jsonObject=new JSONObject();
		HttpSession session = request.getSession(); 
		try {
			Map<String, Object> map = initMap(request);
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			String customerType = request.getParameter("cuctomerType");
			if(StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(password)){
					/*if (RegexUtil.isEmail(loginName)) {
						map.put("email", loginName);
					} else if (RegexUtil.isTelephone(loginName)) {
						map.put("telephone", loginName);
					}else{
						map.put("name", loginName);
					}*/
					map.put("name", loginName);
					password = MD5.md5(password);
					map.put("psd", password);
					List<User> users = userBiz.SelectUserList(map);
					if(users !=null && users.size() > 0){
						
						Cookie cookie2 = new Cookie("islogin","yes");
						cookie2.setMaxAge(7 * 24 * 3600);
						cookie2.setPath("/");
						response.addCookie(cookie2);
						
						User user = users.get(0);
						if(user.getState() == 0){
							//存入cookie
							UUID uuid = UUID.randomUUID();
							String user_token = uuid.toString();
							
							Cookie cookie = new Cookie("user_token", user_token);
							cookie.setMaxAge(7 * 24 * 3600);
							response.addCookie(cookie);
							//修改登录时间与上次登录时间
							User user2 = new User();
							user2.setId(user.getId());
							if(StringUtils.isNotBlank(user.getLoginTime())){
								user2.setLastLoginTime(user.getLoginTime());
							}else{
								user2.setLastLoginTime(DateUtil.getDateTime());
							}
							user2.setLoginTime(DateUtil.getDateTime());
							userBiz.updateUser(user2);
							
							//将未失效的修改为失效
							Syslog syslog = new Syslog();
							syslog.setUserNum(user.getId());
							syslog.setCloseStatus(1); //过期状态 0 有效 1 无效
							syslog.setState(1);    //状态 0 有效 1 无效
							//syslog.setUpState(0);  //修改条件
							if(StringUtils.isNotBlank(customerType)){
								syslog.setCustomerType(Integer.parseInt(customerType));
							}else{
								syslog.setCustomerType(1);  //1 pc 2 安卓 3 ios
							}
							syslogBiz.updateSyslog(syslog);
							
							
							//登录情况存入系统日志
							Syslog syslog2 = new Syslog();
							syslog2.setUser(user2);
							syslog2.setOperateName("用户登录");
							syslog2.setDescription("登录成功");
							syslog2.setOperateUrl("dologin");
							syslog2.setSessionkey(user_token);
							syslog2.setType(1);
							insertSyslog(syslog2, request);
							jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
							jsonObject.put(ConstantUtil.KEY_RESULT, user);
							jsonObject.put(ConstantUtil.KEY_MSG, "恭喜您，登录成功");
						}else {
							/**String msg = "";
							if (user.getStaffroles().size()>0) {
								msg = "该账号的角色已被禁用";
							} else {
								msg = "您的账号已被禁用";
							}
							jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 403);
							jsonObject.put(ConstantUtil.KEY_MSG, msg);**/
						}
					}else {
						jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 402);
						jsonObject.put(ConstantUtil.KEY_MSG, "用户名或密码错误");
					}
			}else{
				jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
				jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}
	
	
	/**
	 * 用户退出登录
	 */
	@RequestMapping(value = "/manage/loginout")
	public String loginout(HttpServletResponse response, Model model) {
		JSONObject jsonObject = new JSONObject();
		try {
			User user = getUser(request);
			request.getSession().removeAttribute("emsstationCode");
			if (user != null) {
				String customerType = request.getParameter("customerType");
				String user_token = "";
				Cookie[] cookies = request.getCookies();
				if (cookies != null && cookies.length > 0) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("user_token")) {
							user_token = cookie.getValue();
						}else if("islogin".equals(cookie.getName())){
							cookie.setMaxAge(0);
							cookie.setPath("/");
							cookie.setValue("no");
							response.addCookie(cookie); 
						}
					}
				}
				if (StringUtils.isBlank(user_token)) {
					user_token = request.getParameter("user_token");
				}
				if (StringUtils.isNotBlank(user_token)) {
					Syslog SysLog = new Syslog();
					SysLog.setSessionkey(user_token);
					SysLog.setUserNum(user.getId());
					SysLog.setCloseStatus(1);
					SysLog.setType(1);// 登录类型
					//SysLog.setUpState(0); // 作为LoseStatus修改条件
					if (StringUtils.isNotBlank(customerType)) {
						SysLog.setCustomerType(Integer.parseInt(customerType));
					} else {
						SysLog.setCustomerType(1);
					}
					syslogBiz.updateSyslog(SysLog);
					// 添加系统日志
					Syslog sysLog = new Syslog();
					sysLog.setUser(user);
					sysLog.setOperateName("用户退出");
					sysLog.setDescription("退出成功");
					sysLog.setOperateUrl("manage/logout");
					sysLog.setType(2);
					insertSyslog(sysLog, request);

					jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
					jsonObject.put(ConstantUtil.KEY_MSG, "成功退出");
				} else {
					jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
					jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
				}
			} else {
				jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
				jsonObject.put(ConstantUtil.KEY_MSG, "该用户已退出");
			}
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),
				"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 查询User集合
	 */
	@RequestMapping("/manage/userList")
	public String userList(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,Object> map=initMap(request);
			String name=request.getParameter("name");
			if (StringUtils.isNotBlank(name)) {
				map.put("name", name);
			}
			String sex=request.getParameter("sex");
			if (StringUtils.isNotBlank(sex)) {
				map.put("sex", sex);
			}
			String age=request.getParameter("age");
			if (StringUtils.isNotBlank(age)) {
				map.put("age", age);
			}
			String weid=request.getParameter("weid");
			if (StringUtils.isNotBlank(weid)) {
				map.put("weid", weid);
			}
			String idcard=request.getParameter("idcard");
			if (StringUtils.isNotBlank(idcard)) {
				map.put("idcard", idcard);
			}
			String phone=request.getParameter("phone");
			if (StringUtils.isNotBlank(phone)) {
				map.put("phone", phone);
			}
			String state=request.getParameter("state");
			if (StringUtils.isNotBlank(state)) {
				map.put("state", state);
			}
			jsonObject=userBiz.userList(map);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 根据id查询User
	 */
	@RequestMapping(value = "/manage/userById")
	public String userById(HttpServletResponse response, Model model) {
		JSONObject jsonObject=new JSONObject();
		try {
			String id = request.getParameter("id");
			jsonObject = userBiz.userById(id);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 新增User
	 */
	@RequestMapping(value = "/manage/addUser")
	public String addUser(User user, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = userBiz.insertUser(user);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 修改User
	 */
	@RequestMapping(value = "/manage/updateUser")
	public String updateUser(User user, HttpServletResponse response, Model model) {
		JSONObject jsonObject =new JSONObject();
		try {
			jsonObject = userBiz.updateUser(user);
		} catch (Exception e) {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 500);
			jsonObject.put(ConstantUtil.KEY_MSG, "网络异常");
			e.printStackTrace();
		}
		output(response, jsonObject.toString(),"application/json;charset=UTF-8");
		return null;
	}

	/**
	 * 删除User
	 */
	@RequestMapping(value = "/manage/deleteUser")
	public String deleteUser(HttpServletResponse response, Model model) {
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
				jsonObject= userBiz.deleteUser(map);
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