package com.example.love;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;

/**
 * Properties文件工具枚举类
 * 
 * @author ShiXian
 * @version 1.0
 * @date 2017年10月26日
 *
 */
public enum PropertiesUtil {
	
	INSTANCE;
	
	private Properties prop;
	
	
	private PropertiesUtil() {
		prop = new Properties();
		InputStream ins = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(ins);// 将属性文件流装载到Properties对象中
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(ins);
		}
	}
	
	public Properties getProperties(){
		return prop;
	}

}