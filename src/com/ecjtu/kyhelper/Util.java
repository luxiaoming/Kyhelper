package com.ecjtu.kyhelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * TODO : Util.java--工具类，号码是否有效，网络是否连接
 * 
 * @author ECJTU IsayesHu
 * @date 2015年3月29日
 */
public class Util {

	// 判断电话号码是否有效
	public static boolean isPhoneNumberValid(String phoneNumber) {

		boolean isValid = false;
		String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
		// CharSequence的值是可读可写序列，而String的值是只读序列
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}

	// 判断网络是否连接
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			// ConnectivityManager主要管理和网络连接相关的操作
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

}
