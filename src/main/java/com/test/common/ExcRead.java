package com.test.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcRead {

	// 查看excel的后缀名称
	public static Workbook getworkbook(String filepath) {
		// excel处理
		Workbook wb = null;
		try {
			File file = new File(filepath);
			InputStream is = new FileInputStream(file);
			// 判断传递文件的后缀名
			if (filepath.endsWith(".xls")) {
				wb = new HSSFWorkbook(is);
			} else if (filepath.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb;
	}

	/**
	 * 根据Cell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	public static String getCellFormatValueT(Cell cell) {
		String returnValue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case BOOLEAN: // 布尔
				Boolean booleanValue = cell.getBooleanCellValue();
				returnValue = booleanValue.toString();
				break;
			case BLANK: // 空值
				break;
			case NUMERIC:
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// 方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					returnValue = sdf.format(date);
				} else {
					Double doubleValue = cell.getNumericCellValue();
					// 格式化科学计数法，取一位整数
					DecimalFormat df = new DecimalFormat("0");
					returnValue = df.format(doubleValue);
				}
				break;
			case FORMULA:
				break;
			// 如果当前Cell的Type为STRIN
			case STRING:
				// 取得当前的Cell字符串
				returnValue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			case ERROR: // 故障
				break;
			default:
				returnValue = "";
			}
		} else {
			returnValue = "";
		}
		return returnValue;

	}

	//封装方法获取对应sheet页的行和列
	public static String getCellValue(Sheet sheet, int rowNum, int cellNum) {
		Cell cell = sheet.getRow(rowNum).getCell(cellNum);
		String value = getCellFormatValueT(cell);
		return value;
	}

	//数据驱动读取对应文件对应sheet下的内容
	public Object[][] testDate(String file,String sheetname) {

		ArrayList<String> arr = new ArrayList<String>();
		//获取文件内容
		Workbook workbook = ExcRead.getworkbook(file);
		//获取sheet下的内容
		Sheet sheet = workbook.getSheet(sheetname);
		//行
		int rowTotalNum = sheet.getLastRowNum() + 1;
		//列
		int cloumns = sheet.getRow(0).getPhysicalNumberOfCells();
		//存到map中
		HashMap<String, String>[][] map = new HashMap[rowTotalNum - 1][1];
		if (rowTotalNum > 1) {
			for (int i = 0; i < rowTotalNum - 1; i++) {
				map[i][0] = new HashMap();
			}
		} else { // 打印
			System.out.println("读取失败");
		}
		for (int c = 0; c < cloumns; c++) {
			String cellvalue = ExcRead.getCellValue(sheet, 0, c);
			arr.add(cellvalue);
		}
		for (int j = 1; j < rowTotalNum; j++) {
			for (int c = 0; c < cloumns; c++) {
				String cellvalue = ExcRead.getCellValue(sheet, j, c);
				map[j - 1][0].put(arr.get(c), cellvalue);
			}
		}
		return map;
	}
}
