package com.example.love;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 自定义获取bean实例
 * 
 * @author ShiXian
 * @version 1.0
 * @date 2017年9月20日
 *
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * ApplicationContext将其存入静态变量.
	 * 
	 */
	public void setApplicationContext(ApplicationContext context) {
		Const.WEB_APP_CONTEXT = context;
		logger.debug("存入ApplicationContext:"+context);
	}

	/**
	 * 实现DisposableBean接口, 在Context关闭时清理静态变量.
	 * 
	 */
	public void destroy() throws Exception {
		Const.WEB_APP_CONTEXT = null;
		logger.debug("清除ApplicationContext:"+Const.WEB_APP_CONTEXT);
	}
	
}
