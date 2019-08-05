package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Role_user;



/**
 * 接口
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public interface Role_userService {

	/**
	 * 新增
	 * 
	 * @param role_user
	 * @return
	 * @throws Exception
	 */
	public int insertRole_user(Role_user role_user) throws Exception;

	/**
	 * 修改
	 * 
	 * @param role_user
	 * @return
	 * @throws Exception
	 */
	public int updateRole_user(Role_user role_user) throws Exception;

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteRole_user(Map<String, Object> map) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Role_user selectRole_userById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Role_user> selectRole_userList(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<Role_user> selectAllRole_userList(Map<String, Object> map);

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectRole_userListCount(Map<String, Object> map);

}