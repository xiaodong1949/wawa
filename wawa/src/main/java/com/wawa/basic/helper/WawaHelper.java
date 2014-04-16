package com.wawa.basic.helper;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Administrator
 * 
 */
public class WawaHelper {
	/**
	 * Base64加密
	 * @param encodeStr
	 * @return
	 */
	public static String decodeStr(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		String s = new String(b);
		return s;
	}
}
