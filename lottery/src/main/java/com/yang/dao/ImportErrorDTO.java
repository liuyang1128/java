/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.dao;

/**
 * excel导入，错误日志
 * 
 * Package : com.yixin.lottery.entity
 * 
 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午12:42:35
 *
 */
public class ImportErrorDTO extends BaseDTO {

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月27日 下午12:49:49
	 *
	 */
	private static final long serialVersionUID = -6631491010163025251L;

	/**
	 * 员工编号
	 */
	private String jobNumber;

	/**
	 * 错误描述
	 */
	private String errorDescribe;
	/**
	 * 错误日志
	 */
	private String errorLog;

	/**
	 * 批次号
	 */
	private String departmentName;

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getErrorDescribe() {
		return errorDescribe;
	}

	public void setErrorDescribe(String errorDescribe) {
		this.errorDescribe = errorDescribe;
	}

	public String getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
