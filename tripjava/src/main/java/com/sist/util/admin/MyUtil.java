package com.sist.util.admin;

import com.example.demo.entity.Users;

public class MyUtil {	
	
	public static String getHtml(Users u) {
		String str = "";
		str += "메일 내용은 여기에 입력하시면 됩니다!";
		return str;
	}
	
	public static String getRenameNotMultiple(String oldName) {
		String fname = "";
		oldName = oldName.replace(".", ",");
		String []arr = oldName.split(",");
		try {
			long n = System.currentTimeMillis();
			fname = arr[0] + n + "." + arr[1];
		}catch (Exception e) {
			// TODO: handle exception
		}
		return fname;
	}
}
