package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Permissionrole;



/**
 * 接口
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public interface PermissionroleService {
	
	/**
	 * 批量新增
	 * 
	 * @param permissionrole
	 * @return
	 * @throws Exception
	 */
	public int insertPermissionroleList(List<Permissionrole> permissionroles) throws Exception;

	/**
	 * 新增
	 * 
	 * @param permissionrole
	 * @return
	 * @throws Exception
	 */
	public int insertPermissionrole(Permissionrole permissionrole) throws Exception;

	/**
	 * 修改
	 * 
	 * @param permissionrole
	 * @return
	 * @throws Exception
	 */
	public int updatePermissionrole(Permissionrole permissionrole) throws Exception;

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deletePermissionrole(Map<String, Object> map) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Permissionrole selectPermissionroleById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Permissionrole> selectPermissionroleList(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Permissionrole> selectAllPermissionroleList(Map<String, Object> map);

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectPermissionroleListCount(Map<String, Object> map);

}