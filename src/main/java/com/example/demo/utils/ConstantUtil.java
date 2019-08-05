package com.example.demo.utils;

/**
 * 定义常量类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public class ConstantUtil {

	/**
	 * 返回json数据键值
	 */
	public static String KEY_MSG="msg"; //消息
	public static String KEY_RESULT="result"; //结果
	public static String KEY_TOTAL="total"; //总数
	public static String KEY_ERROR_CODE="error_code"; //错误代号

	/**
	 * 错误代号值
	 */
	public static Integer CODE_200=200; //操作成功
	public static Integer CODE_201=201; //记录重复
	public static Integer CODE_401=401; //验证码错误
	public static Integer CODE_402=402; //未查到相应记录
	public static Integer CODE_403=403; //没有操作权限
	public static Integer CODE_404=404; //参数错误
	public static Integer CODE_406=406; //账号在另一地点登录
	public static Integer CODE_500=500; //系统异常

	/**
	 * 错误消息
	 */
	public static String MSG_401="验证码错误";
	public static String MSG_402="用户名或密码错误";
	public static String MSG_403="没有操作权限";
	public static String MSG_404="参数错误";
	public static String MSG_406="您的账号在另一地点登录";
	public static String MSG_500="网络异常";

	/**
	 * 客户端类型
	 */
	public static String CUSTOMERTYPE_PC="1"; //PC
	public static String CUSTOMERTYPE_ANDROID="2";//Android
	public static String CUSTOMERTYPE_IOS="3";// IOS

}