package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Role;



/**
 * 接口
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public interface RoleService {

	/**
	 * 新增
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int insertRole(Role role) throws Exception;

	/**
	 * 修改
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int updateRole(Role role) throws Exception;

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteRole(Map<String, Object> map) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Role selectRoleById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Role> selectRoleList(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Role> selectAllRoleList(Map<String, Object> map);

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectRoleListCount(Map<String, Object> map);

}