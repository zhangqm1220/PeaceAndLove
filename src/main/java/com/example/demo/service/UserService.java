package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.User;



/**
 * 用户接口
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
public interface UserService {
	
	List<User> selectAllUser(Map<String,Object> map);

	/**
	 * 新增
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(User user) throws Exception;

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateUser(User user) throws Exception;

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(Map<String, Object> map) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public User selectUserById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<User> selectUserList(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<User> selectAllUserList(Map<String, Object> map);

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectUserListCount(Map<String, Object> map);

}