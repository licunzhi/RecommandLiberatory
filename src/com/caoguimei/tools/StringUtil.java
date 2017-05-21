package com.caoguimei.tools;

/**
 * 字符串工具类
 */
public class StringUtil {
	/**
	 * 将字符串转换成数组,按照tag分割
	 */
	public static String[] str2Arr(String str,String tag){
			return str.split(tag);
	}
	/**
	 * 就是转化成可以使用in语句查询的特定格式
	 */
	public static String arr2specialstr(String[] arr){
		String str = "(";
		for(int i = 0;i < arr.length-1;i++){
			str = str +"'" + arr[i] + "',";
		}
		str = str + "'" +  arr[arr.length-1] + "')";
		return str;
	}

}
