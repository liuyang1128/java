package com.yang.assembler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.yang.dao.LotteryPoolInfoDTO;
import com.yang.entity.LotteryPoolInfo;

/**
 * 抽奖池信息实体与DTO转换类
 * 
 * Package : com.yixin.lottery.assembler
 * 
 * @author YixinCapital -- Yang.Liu 2018年1月26日 下午3:59:04
 *
 */
public class LotteryPoolInfoAssembler {

	/**
	 * dto转实体
	 * 
	 * @param dto 入参
	 * @return 出参
	 * @author YixinCapital -- Yang.Liu 2018年1月26日 下午4:00:49
	 */
	public static LotteryPoolInfo toEntity(LotteryPoolInfoDTO dto) {
		LotteryPoolInfo result = new LotteryPoolInfo();
		if (dto == null) {
			return result;
		}
		result.setName(dto.getName());
		result.setLotteryNumber(dto.getLotteryNumber());
		result.setDepartmentName(dto.getDepartmentName());
		return result;
	}
	
	/**
	 * 实体转dto
	 * 
	 * @param entity 实体
	 * @return dto
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月26日 下午4:07:15
	 */
	public static LotteryPoolInfoDTO toDto(LotteryPoolInfo entity) {
		LotteryPoolInfoDTO result = new LotteryPoolInfoDTO();
		if (entity == null) {
			return result;
		}
		result.setId(String.valueOf(entity.getId()));
		result.setName(entity.getName());
		result.setLotteryNumber(entity.getLotteryNumber());
		if (StringUtils.isNotBlank(entity.getLotteryNumber())) {
			result.setOne(entity.getLotteryNumber().substring(0,1));
			result.setTwo(entity.getLotteryNumber().substring(1,2));
			result.setThree(entity.getLotteryNumber().substring(2,3));
			result.setFour(entity.getLotteryNumber().substring(3,4));
		}
		result.setDepartmentName(entity.getDepartmentName());
		return result;
	}

	/**
	 * 实体列表转换为dto列表
	 * 
	 * @param entitys 实体列表
	 * @return dto列表
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月26日 下午4:07:50
	 */
	public static List<LotteryPoolInfoDTO> toDtoList(List<LotteryPoolInfo> entitys) {
		List<LotteryPoolInfoDTO> result = new ArrayList<>();
		if (entitys == null || entitys.isEmpty()) {
			return result;
		}
		for (LotteryPoolInfo info : entitys) {
			result.add(toDto(info));
		}
		return result;
	}

	/**
	 * dto列表转实体列表
	 * 
	 * @param dtoList dto列表
	 * @return 实体列表
	 * @author YixinCapital -- Yang.Liu
	 *	       2018年1月26日 下午4:13:24
	 */
	public static List<LotteryPoolInfo> toEntityList(List<LotteryPoolInfoDTO> dtoList) {
		List<LotteryPoolInfo> result = new ArrayList<>();
		if (dtoList == null || dtoList.isEmpty()) {
			return result;
		}
		for (LotteryPoolInfoDTO dto : dtoList) {
			result.add(toEntity(dto));
		}
		return result;
	}
}
