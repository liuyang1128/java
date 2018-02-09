/**
 * 2018年1月26日
 * Yang.Liu
 */
package com.yang.service;

import java.io.InputStream;
import java.util.List;

import com.yang.dao.LotteryPoolInfoDTO;

/**
 * 抽奖活动服务类
 * 
 * Package : com.yixin.lottery.service.lottery
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月26日 下午4:15:43
 *
 */
public interface LotteryService {
	
	/**
	 * 查询中奖人员
	 * 
	 * @return 中奖人员信息
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月26日 下午7:52:19
	 */
	LotteryPoolInfoDTO queryWinPerson();
	
	/**
	 * 导入初始化抽奖池数据保存
	 * 
	 * @param instream 入参输入流
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月27日 下午2:36:13
	 */
	void importExcelDataSave(InputStream instream);
	
	/**
	 * 导入非抽奖池数据删除
	 * 
	 * @param instream 入参输入流
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月27日 下午2:36:13
	 */
	void importExcelDataRemove(InputStream instream);
	
	/**
	 * 查询中奖人员列表
	 * 
	 * @return 中奖人员列表
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月27日 下午5:34:22
	 */
	List<LotteryPoolInfoDTO> queryLotteryNumberList();
	
	
	/**
	 * 重置中奖人员信息
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月27日 下午5:34:22
	 */
	void resetLotteryNumberList();
	
}

