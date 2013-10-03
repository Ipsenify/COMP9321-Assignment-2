package edu.unsw.comp9321.assign2.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public class Helper {

	public static String encrypt(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}
	
	public static Long toLong(String str){
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return (long)0;
		}
	}
	
	public static Double toDouble(String str){
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}
	
	public static int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath();
	}

}
