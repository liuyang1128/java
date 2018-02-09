/**
 * 2018年1月30日
 * Yang.Liu
 */
package com.yang.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yang.dao.UserInfoDTO;
import com.yang.entity.UserInfo;
import com.yang.service.UserService;

/**
 * 用户登录验证服务
 * 
 * Package : com.yang.service.impl
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月30日 下午5:10:04
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * 查询登录人是否存在
	 * 
	 * @param dto 入参
	 * @return 结果
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月30日 下午5:10:04
	 */
	@Override
	public boolean login(UserInfoDTO dto) {
		if (dto == null) {
			return false;
		}
		Map<String, Object> propValues = new HashMap<>();
		propValues.put("userName", dto.getUserName());
		propValues.put("passWord", dto.getPassword());
		UserInfo userInfo = UserInfo.findFirstByProperties(UserInfo.class, propValues);
		if (userInfo != null) {
			return true;
		}
		return false;
	}

}

