package com.yang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yang.core.BZBaseEntiy;

/**
 * 抽奖池信息表
 * 
 * Package : com.yixin.lottery.entity
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月26日 下午3:33:43
 *
 */
@Entity
@Table(name = "lottery_pool_info")
public class LotteryPoolInfo extends BZBaseEntiy{

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月29日 下午10:28:00
	 *
	 */
	private static final long serialVersionUID = 895775991723516509L;

	// 客户姓名
	@Column(name = "name", length = 25)
	private String name;

	// 抽奖号
	@Column(name = "lottery_number", length = 25)
	private String lotteryNumber;

	// 部门名称
    @Column(name = "department_name", length = 25)
    private String departmentName;

    public LotteryPoolInfo() {
        super();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lotteryNumber
	 */
	public String getLotteryNumber() {
		return lotteryNumber;
	}

	/**
	 * @param lotteryNumber the lotteryNumber to set
	 */
	public void setLotteryNumber(String lotteryNumber) {
		this.lotteryNumber = lotteryNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
