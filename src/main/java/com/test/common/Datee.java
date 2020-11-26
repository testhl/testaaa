package com.test.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

public class Datee {

	//时间格式可以自定义
	public static final String Date1="yyyy-MM-dd HH:mm:ss";
	//2020-11-10
	public static final String Date2="yyyy-MM-dd";
	public static final String Date3="HH:mm:ss";
	public static final String Date4="yyyyMMdd HHmmss";
	public static final String Date5="yyyy年MM月dd日 HH:mm:ss";
	public static final String Date6="yyyy年MM月dd日";
	public static final String Date7="yyyy年MM月dd日HH时mm分ss秒";
	public static final String Date8="HH时mm分ss秒";
	public static final String Date9="yyyyMMddHHmmss";
	//将当前时间格式化
	public static String formate(String type) {
		Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
        String dateString = simpleDateFormat.format(date);
        return dateString;
	}
	//将输入String格式的日期格式化，输入的日期格式需要与所选类型一致，否则就会报错
		public static  void inpformate(String str,String type)  {
			Date date = new Date();
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
	        try {
	        	//将String类型转化成date类型
				Date d=simpleDateFormat.parse(str);
                simpleDateFormat.format(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		//将输入Date格式的日期格式化	
		public static  String inpDaformate(Date date,String type)  {
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
	        String dateString = simpleDateFormat.format(date); 
			return dateString;
		}
		
	//生成当前时间时间戳  并进行格式化
	public static String timeCurr(String type) {
		long currtime =System.currentTimeMillis();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		String dateString = simpleDateFormat.format(currtime);
		return dateString;
	}
	
	/*
	 * //生成当前日期前后的日期 
	 */
	public static String yMdTime(int yn,int Mn,int dn,String type) {
		//获取指定的时间点，定时
		Calendar calendar = Calendar.getInstance();
		//获取加减参数后的年份
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + yn);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + Mn);
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + dn);
		// 获取计算后的时间
		Date timelast=calendar.getTime();
		return inpDaformate(timelast,type);
	}
	
	/*
	 * //生成当前时间的前后时分秒
	 * type格式
	 * hn为正后移时间，为负代表之前的时间，其他字符同理
	 */
	public static String hmsTime(int hn,int mn,int sn,String type) {
		//获取指定的时间点，定时
		Calendar calendar = Calendar.getInstance();
		//获取加减参数后的年份
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hn);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + mn);
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + sn);
		// 获取计算后的时间
		Date timelast=calendar.getTime();
		return inpDaformate(timelast,type);
	}
	
}
