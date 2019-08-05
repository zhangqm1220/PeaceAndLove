package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Permissionrole;
import com.example.demo.service.BaseService;
import com.example.demo.service.PermissionroleService;



/**
 * 实现类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class PermissionroleServiceImpl extends BaseService implements PermissionroleService {
	
	
	/**
	 * 批量插入
	 * 
	 * @param permissionrole
	 * @return
	 * @throws Exception
	 */
	public int insertPermissionroleList(List<Permissionrole> permissionroles) throws Exception {
		return super.getSqlSession().insert("insertPermissionroleList", permissionroles);
	}

	/**
	 * 新增
	 * 
	 * @param permissionrole
	 * @return
	 * @throws Exception
	 */
	public int insertPermissionrole(Permissionrole permissionrole) throws Exception {
		return super.getSqlSession().insert("insertPermissionrole", permissionrole);
	}

	/**
	 * 修改
	 * 
	 * @param permissionrole
	 * @return
	 * @throws Exception
	 */
	public int updatePermissionrole(Permissionrole permissionrole) throws Exception {
		return super.getSqlSession().update("updatePermissionrole", permissionrole);
	}

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deletePermissionrole(Map<String, Object> map) throws Exception {
		return super.getSqlSession().delete("deletePermissionrole", map);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Permissionrole selectPermissionroleById(Integer id) {
		return super.getSqlSession().selectOne("selectPermissionroleById",id);
	}

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Permissionrole> selectPermissionroleList(Map<String, Object> map) throws Exception {
		if (map != null && map.containsKey("pageIndex") && map.containsKey("pageSize")) {
			Integer index = (Integer)map.get("pageIndex");
			Integer size = (Integer)map.get("pageSize");
			Integer count = (index-1)*size;
			map.put("countIndex", count);
		}
		return super.getSqlSession().selectList("selectPermissionroleList",map);
	}

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Permissionrole> selectAllPermissionroleList(Map<String, Object> map) {
		return super.getSqlSession().selectList("selectAllPermissionroleList",map);
	}

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectPermissionroleListCount(Map<String, Object> map) {
		Object obj = super.getSqlSession().selectOne("selectPermissionroleListCount",map);
		if(obj != null){
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}

}