package com.example.demo.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ConstantUtil;

/**
 * 用户业务处理类
 * 
 * @author zhangqiming
 * @version 1.0
 * @date 2018-11-22
 */
@Service
public class UserBiz {

	@Resource
	private UserService userService;
	
	/**
	 * 查询User集合
	 * @return 
	 */
	public  List<User> SelectUserList(Map<String, Object> map) throws Exception{
		List<User> users = userService.selectUserList(map);
		return users;
	}

	/**
	 * 查询User集合
	 */
	public JSONObject userList(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		List<User> users = userService.selectUserList(map);
		int total = userService.selectUserListCount(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_RESULT, users);
		jsonObject.put(ConstantUtil.KEY_TOTAL, total);
		return jsonObject;
	}

	/**
	 * 根据id查询User
	 */
	public JSONObject userById(String id) throws Exception{
		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isNotBlank(id)) {
			User user = userService.selectUserById(Integer.parseInt(id));
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
			jsonObject.put(ConstantUtil.KEY_RESULT, user);
		} else {
			jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 404);
			jsonObject.put(ConstantUtil.KEY_MSG, "参数错误");
		}
		return jsonObject;
	}

	/**
	 * 新增User
	 */
	public JSONObject insertUser(User user) throws Exception{
		JSONObject jsonObject=new JSONObject();
		userService.insertUser(user);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "新增成功");
		return jsonObject;
	}

	/**
	 * 修改User
	 */
	public JSONObject updateUser(User user) throws Exception{
		JSONObject jsonObject=new JSONObject();
		userService.updateUser(user);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "修改成功");
		return jsonObject;
	}

	/**
	 * 删除User
	 */
	public JSONObject deleteUser(Map<String, Object> map) throws Exception{
		JSONObject jsonObject=new JSONObject();
		userService.deleteUser(map);
		jsonObject.put(ConstantUtil.KEY_ERROR_CODE, 200);
		jsonObject.put(ConstantUtil.KEY_MSG, "删除成功");
		return jsonObject;
	}

}