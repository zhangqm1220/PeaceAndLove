package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Role_user;
import com.example.demo.service.BaseService;
import com.example.demo.service.Role_userService;



/**
 * 实现类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class Role_userServiceImpl extends BaseService implements Role_userService {

	/**
	 * 新增
	 * 
	 * @param role_user
	 * @return
	 * @throws Exception
	 */
	public int insertRole_user(Role_user role_user) throws Exception {
		return super.getSqlSession().insert("insertRole_user", role_user);
	}

	/**
	 * 修改
	 * 
	 * @param role_user
	 * @return
	 * @throws Exception
	 */
	public int updateRole_user(Role_user role_user) throws Exception {
		return super.getSqlSession().update("updateRole_user", role_user);
	}

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteRole_user(Map<String, Object> map) throws Exception {
		return super.getSqlSession().delete("deleteRole_user", map);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Role_user selectRole_userById(Integer id) {
		return super.getSqlSession().selectOne("selectRole_userById",id);
	}

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Role_user> selectRole_userList(Map<String, Object> map) throws Exception {
		if (map != null && map.containsKey("pageIndex") && map.containsKey("pageSize")) {
			Integer index = (Integer)map.get("pageIndex");
			Integer size = (Integer)map.get("pageSize");
			Integer count = (index-1)*size;
			map.put("countIndex", count);
		}
		return super.getSqlSession().selectList("selectRole_userList",map);
	}

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Role_user> selectAllRole_userList(Map<String, Object> map) {
		return super.getSqlSession().selectList("selectAllRole_userList",map);
	}

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectRole_userListCount(Map<String, Object> map) {
		Object obj = super.getSqlSession().selectOne("selectRole_userListCount",map);
		if(obj != null){
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}

}