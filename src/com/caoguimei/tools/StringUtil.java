package com.caoguimei.tools;

/**
 * �ַ���������
 */
public class StringUtil {
	/**
	 * ���ַ���ת��������,����tag�ָ�
	 */
	public static String[] str2Arr(String str,String tag){
			return str.split(tag);
	}
	/**
	 * ����ת���ɿ���ʹ��in����ѯ���ض���ʽ
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
