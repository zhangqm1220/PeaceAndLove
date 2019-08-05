package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Permission;



/**
 * 接口
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public interface PermissionService {
	
	/**
	 * 三级菜单的绑定
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public List<Permission> selectCurrentRolePerssionList(Map<String, Object> map) throws Exception;
	
	/**
	 * 权限树状显示
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public List<Permission> selectPermissionBypId(Map<String, Object> map) throws Exception; 

	/**
	 * 新增
	 * 
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public int insertPermission(Permission permission) throws Exception;

	/**
	 * 修改
	 * 
	 * @param permission
	 * @return
	 * @throws Exception
	 */
	public int updatePermission(Permission permission) throws Exception;

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deletePermission(Map<String, Object> map) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Permission selectPermissionById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Permission> selectPermissionList(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Permission> selectAllPermissionList(Map<String, Object> map);

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectPermissionListCount(Map<String, Object> map);

}