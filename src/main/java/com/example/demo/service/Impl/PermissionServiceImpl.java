package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Permission;
import com.example.demo.service.BaseService;
import com.example.demo.service.PermissionService;



/**
 * 实现类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class PermissionServiceImpl extends BaseService implements PermissionService {

	/**
	 * 三级菜单的绑定
	 * 
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public List<Permission> selectCurrentRolePerssionList(
			Map<String, Object> map) throws Exception {
		return super.getSqlSession().selectList("selectCurrentRolePerssionList",map);
	}
	
	/**
	 * 权限树状显示
	 * 
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public List<Permission> selectPermissionBypId(Map<String, Object> map) throws Exception{
		return super.getSqlSession().selectList("selectPermissionBypId",map);
	}
	
	/**
	 * 新增
	 * 
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public int insertPermission(Permission permission) throws Exception {
		return super.getSqlSession().insert("insertPermission", permission);
	}

	/**
	 * 修改
	 * 
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public int updatePermission(Permission permission) throws Exception {
		return super.getSqlSession().update("updatePermission", permission);
	}

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deletePermission(Map<String, Object> map) throws Exception {
		return super.getSqlSession().delete("deletePermission", map);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Permission selectPermissionById(Integer id) {
		return super.getSqlSession().selectOne("selectPermissionById",id);
	}

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Permission> selectPermissionList(Map<String, Object> map) throws Exception {
		if (map != null && map.containsKey("pageIndex") && map.containsKey("pageSize")) {
			Integer index = (Integer)map.get("pageIndex");
			Integer size = (Integer)map.get("pageSize");
			Integer count = (index-1)*size;
			map.put("countIndex", count);
		}
		return super.getSqlSession().selectList("selectPermissionList",map);
	}

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Permission> selectAllPermissionList(Map<String, Object> map) {
		return super.getSqlSession().selectList("selectAllPermissionList",map);
	}

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectPermissionListCount(Map<String, Object> map) {
		Object obj = super.getSqlSession().selectOne("selectPermissionListCount",map);
		if(obj != null){
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}

}