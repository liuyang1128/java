/**
 * 2018年1月26日
 * Yang.Liu
 */
package com.yang.dao;

/**
 * Package : com.yixin.lottery.dto
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月26日 下午3:57:02
 *
 */
public class LotteryPoolInfoDTO extends BaseDTO{

	/**
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *		   2018年1月26日 下午3:57:21
	 *
	 */
	private static final long serialVersionUID = -6581800677245564540L;
	
	//客户姓名
	private String name;

	// 抽奖号
	private String lotteryNumber;

	// 部门名称
    private String departmentName;
    
    // 抽奖号
 	private String one;
 	
 	// 抽奖号
 	private String two;
 	
 	// 抽奖号
 	private String three;
 	
 	// 抽奖号
  	private String four;

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
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

