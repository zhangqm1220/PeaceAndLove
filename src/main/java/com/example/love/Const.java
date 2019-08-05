package com.example.love;

import org.springframework.context.ApplicationContext;

public class Const {
	/** 用户  **/
	public static final String SESSION_USER = "session_user";
	/** 验证码  **/
	public static final String SESSION_VALIDATECODE = "session_validatecode";
	/** 登录用户  **/
	public static final String LOGIN_USER_MAP = "login_user_map";
	/** 默认列名  **/
	public static final String COLUMN_NAME_DEFAULT = "_default_column_name";
	
	public static ApplicationContext WEB_APP_CONTEXT = null;
}
