package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.service.BaseService;
import com.example.demo.service.UserService;



/**
 * 用户实现类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
	
	
	public List<User> selectAllUser(Map<String,Object> map) {
		//List<User> users = super.getSqlSession().userMapper.selectAllUser();
		List<User> users = super.getSqlSession().selectList("selectAllUser", map);
		return users;
	}

	/**
	 * 新增
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(User user) throws Exception {
		return super.getSqlSession().insert("insertUser", user);
	}

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateUser(User user) throws Exception {
		return super.getSqlSession().update("updateUser", user);
	}

	/**
	 * 删除
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(Map<String, Object> map) throws Exception {
		return super.getSqlSession().delete("deleteUser", map);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public User selectUserById(Integer id) {
		return super.getSqlSession().selectOne("selectUserById",id);
	}

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<User> selectUserList(Map<String, Object> map) throws Exception {
		if (map != null && map.containsKey("pageIndex") && map.containsKey("pageSize")) {
			Integer index = (Integer)map.get("pageIndex");
			Integer size = (Integer)map.get("pageSize");
			Integer count = (index-1)*size;
			map.put("countIndex", count);
		}
		return super.getSqlSession().selectList("selectUserList",map);
	}

	/**
	 * 查询所有
	 * 
	 * @param map
	 * @return
	 */
	public List<User> selectAllUserList(Map<String, Object> map) {
		return super.getSqlSession().selectList("selectAllUserList",map);
	}

	/**
	 * 查询总数
	 * 
	 * @param map
	 * @return
	 */
	public int selectUserListCount(Map<String, Object> map) {
		Object obj = super.getSqlSession().selectOne("selectUserListCount",map);
		if(obj != null){
			return Integer.parseInt(obj.toString());
		}
		return 0;
	}


}