package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.service.BaseService;
import com.example.demo.service.RoleService;



/**
 * 实现类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {

	/**
	 * 新增
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int insertRole(Role role) throws Exception {
		return super.getSqlSession().insert("insertRole", role);
	}

	/**
	 * 修改
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int updateRole(Role role) throws Exception {
		return super.getSqlSession().update("updateRole", role);
	}

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteRole(Map<String, Object> map) throws Exception {
		return super.getSqlSession().delete("deleteRole", map);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Role selectRoleById(Integer id) {
		return super.getSqlSession().selectOne("selectRoleById",id);
	}

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Role> selectRoleList(Map<String, Object> map) throws Exception {
		if (map != null && map.containsKey("pageIndex") && map.containsKey("pageSize")) {
			Integer index = (Integer)map.get("pageIndex");
			Integer size = (Integer)map.get("pageSize");
			Integer count = (index-1)*size;
			map.put("countIndex", count);
		}
		return super.getSqlSession().selectList("selectRoleList",map);
	}

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Role> selectAllRoleList(Map<String, Object> map) {
		return super.getSqlSession().selectList("selectAllRoleList",map);
	}

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectRoleListCount(Map<String, Object> map) {
		Object obj = super.getSqlSession().selectOne("selectRoleListCount",map);
		if(obj != null){
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}

}