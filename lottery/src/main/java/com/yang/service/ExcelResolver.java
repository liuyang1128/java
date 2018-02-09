/**
 * 2018年1月27日
 * Yang.Liu
 */
package com.yang.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yang.dao.LotteryPoolInfoDTO;
import com.yang.entity.ImportErrorLog;
import com.yang.exception.BzException;
import com.yang.exception.DomainException;

/**
 * Excel数据解析工具
 * 
 * Package : com.yixin.lottery.utils.excel
 * 
 * @author YixinCapital -- Yang.Liu 2018年1月27日 下午12:38:11
 *
 */
public class ExcelResolver {
	/**
	 * 数据行开始的索引
	 */
	private static final int DATAROW_START = 1;
	private static Integer success = 0; // 读取成功条数记录
	private static Integer error = 0; // 读取失败条数记录

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 解析抽奖池的Excel
	 *
	 * @param instream
	 *            excel文件的输入流
	 * @return 抽奖池dto列表
	 * @author YixinCapital -- lz 2017年10月18日 下午7:29:57
	 */
	public ExcelResolveResult resolve(InputStream instream) {
		ExcelResolveResult result = new ExcelResolveResult();
		try {
			parseWorkbook(getWorkdbook(instream), result);
			return result;
		} catch (InvalidFormatException | IOException | ParseException e) {
			logger.error("解析Excel异常", e);
			throw new BzException("解析Excel异常", e);
		}

	}

	/**
	 * 解析工作簿数据
	 *
	 * @param wb
	 *            工作簿实例
	 * @param resolveResult
	 *            解析结果对象
	 * @throws ParseException
	 *             解析异常
	 * @author YixinCapital -- lz 2017年10月18日 下午8:17:32
	 * @throws ParseException
	 */
	void parseWorkbook(Workbook wb, ExcelResolveResult resolveResult) throws ParseException {
		success = 0;
		error = 0;
		if (wb.getNumberOfSheets() == 0) {
			new ImportErrorLog("", "导入抽奖池数据 sheet数量为0", "", "").create();
			throw new DomainException("导入抽奖池数据 sheet数量为0");
		}
		Sheet sheet = wb.getSheetAt(0);
		for (int i = DATAROW_START; i <= sheet.getLastRowNum(); i++) {
			logger.info("========开始读取第" + i + "条数据========");
			Row dataRow = sheet.getRow(i);
			if (dataRow == null) {
				new ImportErrorLog("", "第" + i + "行无数据", "", "").create();
				error++;
				continue;
			}
			try {
				LotteryPoolInfoDTO dto = parseRow(dataRow);
				if (dto != null) {
					resolveResult.addData(dto);
					success++;
				}
			} catch (BzException ex) {
				error++;
				resolveResult.addError(ex.getMessage());
				new ImportErrorLog(getValue(dataRow.getCell(2)), ex.getMessage(), "", "").create();
			}
		}
		logger.info("=======读取数据条数成功{}条,失败{}条=======", success, error);
	}

	/**
	 * 解析一行数据
	 *
	 * @param dataRow
	 *            excel的一行
	 * @return 收款勾稽DTO
	 * @author YixinCapital -- lz 2017年10月18日 下午8:21:51
	 * @throws ParseException
	 *             日期解析异常
	 */
	LotteryPoolInfoDTO parseRow(Row dataRow) throws ParseException {
		LotteryPoolInfoDTO result = new LotteryPoolInfoDTO();
		result.setName(getValue(dataRow.getCell(0))); // 客户姓名
		result.setDepartmentName(getValue(dataRow.getCell(1))); // 部门名称
		String number = getValue(dataRow.getCell(2));
		if (StringUtils.isNotBlank(number) && number.contains(".")) {
			number = number.substring(0, number.indexOf("."));
		}
		result.setLotteryNumber(number); // 抽奖号
		return result;
	}

	/**
	 * 由输入流解析成excel的workbook
	 *
	 * @param instream
	 *            输入流
	 * @return excel工作簿实例
	 * @throws InvalidFormatException
	 *             格式异常
	 * @throws IOException
	 *             io异常
	 * @author YixinCapital -- lz 2017年10月18日 下午7:28:30
	 * @throws EncryptedDocumentException
	 */
	private Workbook getWorkdbook(InputStream instream)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		return WorkbookFactory.create(instream);
	}

	/**
	 * 获取Excel单元格的内容字符串
	 *
	 * @param cell
	 *            单元格
	 * @return 字符串值
	 * @author YixinCapital -- lz 2017年10月18日 下午8:26:33
	 */
	private String getValue(Cell cell) {
		if (cell == null) {
			return null;
		}

		String result;
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			result = String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			result = String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			result = String.valueOf(cell.getNumericCellValue());
		} else {
			result = String.valueOf(cell.getStringCellValue());
		}

		return result;
	}

}
