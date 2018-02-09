/**
 * 2017年1月24日
 * Yang.Liu
 */
package com.yang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yang.core.BZBaseEntiy;

/**
 * Package : com.yang.entity
 * 
 * 用户信息实体类
 * 
 * @author YixinCapital -- Yang.Liu 2017年1月24日 下午2:15:29
 *
 */

@Entity
@Table(name="lottery_user_info")
public class UserInfo extends BZBaseEntiy{

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月30日 下午4:48:55
	 *
	 */
	private static final long serialVersionUID = 1811706186582201533L;
	
	/**
	 * 登录名
	 */
	@Column(name = "user_name", length = 100)
	private String userName;
	/**
	 * 登录密码
	 */
	@Column(name = "password", length = 100)
	private String passWord;
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
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
