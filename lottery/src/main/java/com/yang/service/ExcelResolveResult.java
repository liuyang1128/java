/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.yang.dao.LotteryPoolInfoDTO;

/**
 * excel导入结果
 * 
 * Package : com.yixin.lottery.utils.excel
 * 
 * @author YixinCapital -- Yang.Liu
 *		   2018年1月27日 下午12:51:31
 *
 */
public class ExcelResolveResult {
	
	private List<LotteryPoolInfoDTO> revevies;
	private List<String> errors;
	
	/**
	 *  默认构造，初始化内部对象：收款记录列表和错误列表
	 * @author YixinCapital -- yangysh
	 *	       2017年11月4日 下午4:41:41
	 */
	public ExcelResolveResult(){
		this.errors = new ArrayList<>();
		this.revevies = new ArrayList<>();
	}
	
	/**
	 * dto加入收款列表
	 * @param dto 收款dto
	 * @author YixinCapital -- yangysh
	 *	       2017年11月4日 下午4:42:33
	 */
	public void addData(LotteryPoolInfoDTO dto) {
		this.revevies.add(dto);
	}
	
	/**
	 * 增加一个错误信息
	 * @param message 错误消息
	 * @author YixinCapital -- yangysh
	 *	       2017年10月23日 下午3:54:54
	 */
	public void addError(String message) {
		this.errors.add(message);
	}
	
	public List<LotteryPoolInfoDTO> getRecevies() {
		return this.revevies;
	}
	
	/**
	 * 
	 * @return 格式话后的错误信息
	 * @author YixinCapital -- yangysh
	 *	       2017年10月23日 下午3:57:49
	 */
	public String getErrorString() {
		if(this.errors.isEmpty()) {
			return null;
		}else {
			StringBuilder errorBu = new StringBuilder(); 
			for(int i=0;i<this.errors.size();i++) {
				errorBu.append(this.errors.get(i)).append(";");
			}
			
			return StringUtils.removeEnd(errorBu.toString(), ";");
		}
	}
}

