/**
 * 2018年1月26日
 * Yang.Liu
 */
package com.yang.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.yang.assembler.LotteryPoolInfoAssembler;
import com.yang.dao.LotteryPoolInfoDTO;
import com.yang.entity.LotteryPoolInfo;
import com.yang.service.ExcelResolveResult;
import com.yang.service.ExcelResolver;
import com.yang.service.LotteryService;

/**
 * Package : com.yixin.lottery.service.lottery.impl
 * 
 * @author YixinCapital -- Yang.Liu 2018年1月26日 下午7:56:15
 *
 */
@Service("lotteryService")
public class LotteryServiceImpl implements LotteryService {

	/**
	 * 查询中奖人员
	 * 
	 * @return 中奖人员信息
	 * @author YixinCapital -- Yang.Liu 2018年1月26日 下午7:52:19
	 */
	@Override
	public LotteryPoolInfoDTO queryWinPerson() {
		LotteryPoolInfoDTO result = new LotteryPoolInfoDTO();
		LotteryPoolInfo info = new LotteryPoolInfo();
		List<LotteryPoolInfo> list = LotteryPoolInfo.findByProperty(LotteryPoolInfo.class, "deleted", false);
		if (list != null && !list.isEmpty()) {
			Random ra = new Random();
			int i = ra.nextInt(list.size());
			info = list.get(i);
			result = LotteryPoolInfoAssembler.toDto(info);
		}
		if (result != null && result.getLotteryNumber() != null) {
			info.setDeleted(true);
			info.update();
		}
		return result;
	}

	/**
	 * 导入初始化抽奖池数据保存
	 * 
	 * @param instream
	 *            入参输入流
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午2:36:13
	 */
	@Override
	public void importExcelDataSave(InputStream instream) {
		ExcelResolver excelResolver = new ExcelResolver();
		ExcelResolveResult excelResult = excelResolver.resolve(instream);
		if (excelResult != null && excelResult.getRecevies() != null && !excelResult.getRecevies().isEmpty()) {
			List<LotteryPoolInfoDTO> list = excelResult.getRecevies();
			for (LotteryPoolInfoDTO lotteryPoolInfoDTO : list) {
				if (lotteryPoolInfoDTO.getLotteryNumber() != null) {
					LotteryPoolInfoAssembler.toEntity(lotteryPoolInfoDTO).create();
				}
			}

		}
	}

	/**
	 * 导入非抽奖池数据删除
	 * 
	 * @param instream
	 *            入参输入流
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午2:36:13
	 */
	@Override
	public void importExcelDataRemove(InputStream instream) {
		ExcelResolver excelResolver = new ExcelResolver();
		ExcelResolveResult excelResult = excelResolver.resolve(instream);
		if (excelResult != null && excelResult.getRecevies() != null && !excelResult.getRecevies().isEmpty()) {
			List<LotteryPoolInfoDTO> list = excelResult.getRecevies();
			for (LotteryPoolInfoDTO lotteryPoolInfoDTO : list) {
				if (lotteryPoolInfoDTO.getLotteryNumber() != null) {
					LotteryPoolInfo info = LotteryPoolInfo.findFirstByProperty(LotteryPoolInfo.class, "lotteryNumber",
							lotteryPoolInfoDTO.getLotteryNumber());
					info.remove();
				}
			}

		}

	}

	/**
	 * 查询中奖人员列表
	 * 
	 * @return 中奖人员列表
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午5:34:22
	 */
	@Override
	public List<LotteryPoolInfoDTO> queryLotteryNumberList() {
		List<LotteryPoolInfo> list = LotteryPoolInfo.findByProperty(LotteryPoolInfo.class, "deleted", true);
		return LotteryPoolInfoAssembler.toDtoList(list);
	}

	/**
	 * 重置中奖人员信息
	 * 
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月27日 下午5:34:22
	 */
	@Override
	public void resetLotteryNumberList() {
		List<LotteryPoolInfo> list = LotteryPoolInfo.findByProperty(LotteryPoolInfo.class, "deleted", true);
		if (list!= null && !list.isEmpty()) {
			for (LotteryPoolInfo info : list) {
				info.setDeleted(false);
				info.update();
			}
		}
	}

}
