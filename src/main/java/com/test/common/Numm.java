package com.test.common;

import java.math.BigDecimal;
import java.util.Random;

import org.testng.annotations.Test;

public class Numm {

	//随机数的封装，获取【0，10的length次方）之前的随机数
	public static long getNum(int length) {
		/*
		 * //生成[0,1)之前的随机数.
		 *  double a=Math.random(); 
		 * //10的length次方 
		 *  double b=Math.pow(10,length); 
		 * //四舍五入 
		 * long num=Math.round(a*b);
		 * 返回的为整数
		 */
	    long num=Math.round(Math.random()*Math.pow(10, length));
		return num;		
	}
	//封装获取N位整数M位小数
	public static  String getNumAndDec(int num,int dec) {
		double a= Math.random()*Math.pow(10,num); 
		BigDecimal bd = new BigDecimal(a);
		//将获取的随机正数，四舍五入保留M位小数
		String q =String.valueOf(bd.setScale(dec,BigDecimal.ROUND_HALF_UP)) ;
		System.out.println(q);
		return q;
	}
	
	//生成某些固定范围的值
	public static int getNumRandom(int min,int max) {
		Random ro=new Random();
        //想要生成101到201之间的随机数，输入101.201，【0，1）
		int num=ro.nextInt(max-min+1)+min;
		return num;
	}
	
	//生成包含大小写和数字的随机数
		public static String getStringRandom(int length) {
			String val="";
			Random ro=new Random();
			for (int i = 0; i < length; i++) {
				String charnum=ro.nextInt(2)%2==0?"char":"num";
		        if(charnum.equals("char")) {
		        	//生成随机的大小写字母
		        	int tem=ro.nextInt(2)%2==0?65:97;
		        	val +=(char)(ro.nextInt(26)+tem);
		        }
		        //生成0到10 的随机数
		        else if(charnum.equals("num")){
		        	val +=ro.nextInt(10);
		        }
			}        
			return val;
		}
}
