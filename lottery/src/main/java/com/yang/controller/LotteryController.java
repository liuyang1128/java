package com.yang.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yang.core.InvokeResult;
import com.yang.dao.LotteryPoolInfoDTO;
import com.yang.service.LotteryService;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	private LotteryService lotteryService;

	/**
	 * 抽奖
	 * 
	 * @return 中奖人员信息
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午5:37:06
	 */
	@ResponseBody
	@RequestMapping("/queryWinPerson")
	public InvokeResult<LotteryPoolInfoDTO> queryWinPerson() {
		InvokeResult<LotteryPoolInfoDTO> result = new InvokeResult<>();
		try {
			LotteryPoolInfoDTO dto = lotteryService.queryWinPerson();
			result.setData(dto);
			result.setHasErrors(false);
		} catch (Exception e) {
			logger.error("查询中奖号异常");
			result.setHasErrors(false);
			result.setErrorMessage("查询中奖号异常");
		}
		return result;
	}

	/**
	 * 查询中奖人员列表
	 * 
	 * @return 中奖号列表
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午5:37:06
	 */
	@ResponseBody
	@RequestMapping("/queryLotteryList")
	public InvokeResult<List<LotteryPoolInfoDTO>> queryLotteryList() {
		InvokeResult<List<LotteryPoolInfoDTO>> result = new InvokeResult<>();
		try {
			List<LotteryPoolInfoDTO> dto = lotteryService.queryLotteryNumberList();
			result.setData(dto);
			result.setHasErrors(false);
		} catch (Exception e) {
			logger.error("查询中奖人员列表异常", e.getMessage(), e);
			result.setHasErrors(true);
			result.setErrorMessage("查询中奖人员列表异常");
		}
		return result;
	}

	/**
	 * 抽奖池数据导入
	 * 
	 * @return 中奖号列表
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午5:37:06
	 */
	@ResponseBody
	@RequestMapping("/excelDataSave")
	public InvokeResult<String> excelDataSave(@RequestParam("uploadedFile") final MultipartFile uploadedFile) {
		InvokeResult<String> result = new InvokeResult<>();
		try {
			lotteryService.importExcelDataSave(uploadedFile.getInputStream());
			result.setData("文件导入成功");
			result.setHasErrors(false);
		} catch (Exception e) {
			logger.error("文件导入异常");
			result.setHasErrors(false);
			result.setErrorMessage("文件导入异常");
		}
		return result;
	}

	/**
	 * 抽奖池数据导入
	 * 
	 * @return 中奖号列表
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午5:37:06
	 */
	@ResponseBody
	@RequestMapping("/excelDataDelete")
	public InvokeResult<String> excelDataDelete(@RequestParam("uploadedFile") final MultipartFile uploadedFile) {
		InvokeResult<String> result = new InvokeResult<>();
		try {
			lotteryService.importExcelDataRemove(uploadedFile.getInputStream());
			result.setData("文件导入成功");
			result.setHasErrors(false);
		} catch (Exception e) {
			logger.error("文件导入异常");
			result.setHasErrors(false);
			result.setErrorMessage("文件导入异常");
		}
		return result;
	}

	/**
	 * 重置抽奖池数据
	 * 
	 * @return 结果
	 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午5:37:06
	 */
	@ResponseBody
	@RequestMapping("/reset")
	public InvokeResult<String> reset() {
		InvokeResult<String> result = new InvokeResult<>();
		try {
			lotteryService.resetLotteryNumberList();
			result.setData("数据重置成功");
			result.setHasErrors(false);
		} catch (Exception e) {
			logger.error("数据重置成功异常,异常信息:{}", e.getMessage(), e);
			result.setHasErrors(false);
			result.setErrorMessage("数据重置成功异常");
		}
		return result;
	}

}
