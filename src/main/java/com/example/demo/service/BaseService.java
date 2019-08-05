package com.example.demo.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.example.demo.utils.DataSourceContextHolder;


/**
 * SqlSession基础类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Component
public class BaseService {

	private SqlSession sqlSession;

	/**
	 * 获取sqlSession
	 * 
	 * @return
	 */
	public SqlSession getSqlSession() {
		DataSourceContextHolder.setDbType(DataSourceContextHolder.dataSource);
		return sqlSession;
	}

	@Resource
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}