/**
 * 2018年1月30日
 * Yang.Liu
 */
package com.yang.service;

import com.yang.dao.UserInfoDTO;

/**
 * 用户登录服务
 * 
 * Package : com.yang.service
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月30日 下午5:07:27
 *
 */
public interface UserService {
	
	/**
	 * 查询登录人是否存在
	 * 
	 * @param dto 入参
	 * @return 结果
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月30日 下午5:10:04
	 */
	boolean login(UserInfoDTO dto);
	
}

