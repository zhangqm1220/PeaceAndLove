package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Syslog;
import com.example.demo.service.BaseService;
import com.example.demo.service.SyslogService;



/**
 * 系统日志实现类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class SyslogServiceImpl extends BaseService implements SyslogService {

	/**
	 * 新增
	 * 
	 * @param syslog
	 * @return
	 * @throws Exception
	 */
	public int insertSyslog(Syslog syslog) throws Exception {
		return super.getSqlSession().insert("insertSyslog", syslog);
	}

	/**
	 * 修改
	 * 
	 * @param syslog
	 * @return
	 * @throws Exception
	 */
	public int updateSyslog(Syslog syslog) throws Exception {
		return super.getSqlSession().update("updateSyslog", syslog);
	}

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteSyslog(Map<String, Object> map) throws Exception {
		return super.getSqlSession().delete("deleteSyslog", map);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Syslog selectSyslogByNum(String num) {
		return super.getSqlSession().selectOne("selectSyslogByNum",num);
	}

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Syslog> selectSyslogList(Map<String, Object> map) throws Exception {
		if (map != null && map.containsKey("pageIndex") && map.containsKey("pageSize")) {
			Integer index = (Integer)map.get("pageIndex");
			Integer size = (Integer)map.get("pageSize");
			Integer count = (index-1)*size;
			map.put("countIndex", count);
		}
		return super.getSqlSession().selectList("selectSyslogList",map);
	}

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Syslog> selectAllSyslogList(Map<String, Object> map) {
		return super.getSqlSession().selectList("selectAllSyslogList",map);
	}

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectSyslogListCount(Map<String, Object> map) {
		Object obj = super.getSqlSession().selectOne("selectSyslogListCount",map);
		if(obj != null){
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}

}