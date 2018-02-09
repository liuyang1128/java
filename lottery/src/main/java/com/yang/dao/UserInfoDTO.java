/**
 * 2017年1月24日
 * Yang.Liu
 */
package com.yang.dao;

/**
 * Package : com.yang.dao
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2017年1月24日 下午2:21:02
 *
 */
public class UserInfoDTO extends BaseDTO{

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月30日 下午4:57:43
	 *
	 */
	private static final long serialVersionUID = 7053040718714714189L;
	
	/**
	 * 登录名
	 */
	private String userName;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

