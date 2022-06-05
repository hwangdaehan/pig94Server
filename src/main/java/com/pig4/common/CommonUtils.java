package com.pig4.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class CommonUtils {
	
	/**
	 * 오브젝트 빈 값 여부체크
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if(obj == null) return true;		
		if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; }	
		if (obj instanceof Map) { 
			return ((Map<?, ?>) obj).isEmpty(); 
		}
		if (obj instanceof Map) { 
			return ((Map<?, ?>)obj).isEmpty(); 
		}
		if (obj instanceof List) { 
			return ((List<?>)obj).isEmpty(); 
		}
		if (obj instanceof Object[]) { 
			return (((Object[])obj).length == 0); 
		}		
	return false;	
	}

	/**
	 * 암호화에 필요한 난수 생성
	 * @return
	 */
	public static String Salt() {
		
		String salt="";
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			random.nextBytes(bytes);
			salt = new String(Base64.getEncoder().encode(bytes));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return salt;
	}

	/**
	 * 비밀번호 암호화
	 * @param password
	 * @param hash
	 * @return
	 */
	public static String SHA512(String password, String hash) {
		String salt = hash+password;
		String hex = null;
		try {
			MessageDigest msg = MessageDigest.getInstance("SHA-512");
			msg.update(salt.getBytes());
			
			hex = String.format("%128x", new BigInteger(1, msg.digest()));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hex;
	}
}
