package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Syslog;



/**
 * 系统日志接口
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public interface SyslogService {

	/**
	 * 新增
	 * 
	 * @param syslog
	 * @return
	 * @throws Exception
	 */
	public int insertSyslog(Syslog syslog) throws Exception;

	/**
	 * 修改
	 * 
	 * @param syslog
	 * @return
	 * @throws Exception
	 */
	public int updateSyslog(Syslog syslog) throws Exception;

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteSyslog(Map<String, Object> map) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param num
	 * @return
	 */
	public Syslog selectSyslogByNum(String num);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Syslog> selectSyslogList(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Syslog> selectAllSyslogList(Map<String, Object> map);

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectSyslogListCount(Map<String, Object> map);

}