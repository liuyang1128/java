/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yang.core.BZBaseEntiy;

/**
 * excel导入，错误日志
 * 
 * Package : com.yixin.lottery.entity
 * 
 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午12:42:35
 *
 */
@Entity
@Table(name = "lottery_import_error_log")
public class ImportErrorLog extends BZBaseEntiy {

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月27日 下午12:47:33
	 *
	 */
	private static final long serialVersionUID = -4862365476717110365L;
	private static final int LENGTH_100 = 100;
	private static final int LENGTH_5000 = 5000;

	/**
	 * 员工编号
	 */
	@Column(name = "job_number", length = LENGTH_100)
	private String jobNumber;

	/**
	 * 错误描述
	 */
	@Column(name = "error_describe", length = LENGTH_5000)
	private String errorDescribe;
	/**
	 * 错误日志
	 */
	@Column(name = "error_log", length = LENGTH_5000)
	private String errorLog;

	/**
	 * 批次号
	 */
	@Column(name = "department_name", length = LENGTH_100)
	private String departmentName;

	/**
	 * for jpa
	 */
	public ImportErrorLog() {
	}

	/**
	 * 全量构造器
	 *
	 * @param jobNumber
	 *            员工编号
	 * @param errorLog
	 *            错误信息
	 * @param aErrorDescribe
	 *            错误描述
	 * @param departmentName
	 *            部门编码
	 */
	public ImportErrorLog(String jobNumber, String errorLog, String aErrorDescribe, String departmentName) {
		this.jobNumber = jobNumber;
		this.errorLog = errorLog;
		this.errorDescribe = aErrorDescribe;
		this.departmentName = departmentName;
	}
	
	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setErrorDescribe(String errorDescribe) {
		this.errorDescribe = errorDescribe;
	}

	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String getErrorDescribe() {
		return errorDescribe;
	}

	public String getErrorLog() {
		return errorLog;
	}

}
