package com.wtjr.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;


/** 
* @ClassName: SecUtil 
* @Description: 加密 解密 数据库信息 
* @author yunlin.liu 
* @date 2016-6-24 上午11:44:55 
*  
*/
public class SecUtil {

	private static final Logger logger = Logger.getLogger(SecUtil.class.getName());
	/**
	 * 自定义 KEY
	 */
	private static byte[] keybytes = { 0x31, 0x32, 0x33, 0x34, 0x35, 0x50,
			0x37, 0x38, 0x39, 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46 };
	
	
	
	/*public static void main(String[] args) {
		BufferedReader reader;
		try {
			String st = "";
			do{
				if("".equals(st)) {
					System.out.println("AES加密与解密操作:");
					System.out.println("\"E\":加密 \t\"D\":解密\t\t\"Q\":退出");
					System.out.println("请输入操作代码:");
				}
				reader = new BufferedReader(new InputStreamReader(System.in));
				st = reader.readLine();
				if("E".equalsIgnoreCase(st)) {
					System.out.println("请输入待加密字符串:");
					st = reader.readLine();
					if(!"".equals(st.trim())) {
						System.out.println("加密前:" + st.trim());
						System.out.println("加密后:" + encrypt(st.trim()) + "\n\n");
					}
					st = "";
				}else if("D".equalsIgnoreCase(st)) {
					System.out.println("请输入待解密字符串:");
					st = reader.readLine();
					if(!"".equals(st.trim())) {
						System.out.println("解密前:" + st.trim());
						System.out.println("解密后:" + decrypt(st.trim()) + "\n\n");
					}
					st = "";
				}
			} while(!st.equalsIgnoreCase("Q"));
		} catch (Exception e) {
			logger.error(e);
		}
	}*/
	
	
	
	
	/** 
	* @Title: encrypt 
	* @author yunlin.liu
	* @Description: 加密
	* @param @param value
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String encrypt(String value) {

		String s = null;

		int mode = Cipher.ENCRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);

			byte[] outBytes = cipher.doFinal(value.getBytes());

			s = String.valueOf(Hex.encodeHex(outBytes));
		} catch (Exception e) {
			logger.error(e);
		}

		return s;
	}
	
	
	/** 
	* @Title: decrypt 
	* @author yunlin.liu
	* @Description: 解密 
	* @param @param value
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String decrypt(String value) {
		String s = null;

		int mode = Cipher.DECRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);

			byte[] outBytes = cipher
					.doFinal(Hex.decodeHex(value.toCharArray()));

			s = new String(outBytes);
		} catch (Exception e) {
			logger.error(e);
		}

		return s;
	}
	
	
	/** 
	* @Title: initCipher 
	* @author yunlin.liu
	* @Description: 初始化密码
	* @param @param mode
	* @param @return
	* @param @throws NoSuchAlgorithmException
	* @param @throws NoSuchPaddingException
	* @param @throws InvalidKeyException    设定文件 
	* @return Cipher    返回类型 
	* @throws 
	*/
	private static Cipher initCipher(int mode) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		Key key = new SecretKeySpec(keybytes, "AES");
		cipher.init(mode, key);
		return cipher;
	}
	
	
	public static void main(String[] dfdf ){
		
		//String url = "jdbc:mysql://192.168.1.155:3306/lqg_db?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true" ;
		String url = "jdbc:mysql://192.168.1.156:3306/lqg_db?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true" ;
//		System.out.println( encrypt(url) ) ;
		
//	
//		String usernamew="60b4cba13522d3977d3e4be7942866270065e7b6a9d96aca985b2c23e0e14a9bbe8f11016c9a98a11bdfad8f7de2aa272378c804c1f22da604aa494fd3f585b10812d63158241c59456e26522ac932676a67739c8c491e9f8a243dbaa50b99b888b912bbac98d2f8905b96cb154021d43666f202bb5a430d51ca4fb4f5d64efed5f64e8dd606f4da64a11d3b12b87ca9";
//		System.out.println( decrypt(usernamew) ) ;
		
		String username2="b5fa5c5710ea1b1a7b691acdc48a4138";
		System.out.println( decrypt(username2) ) ;
		
		String username3="1910ad40059453eac041b98ebb3a5c6d";
		System.out.println( decrypt(username3) ) ;
		
		
		String passw="lqg_db";
		System.out.println( encrypt(passw) ) ;
		
		String passw2="6z3TLeA2Db+lRkUy";
		System.out.println( encrypt(passw2) ) ;
//		String purl="lqg_test";
//		
//		
//		String passws="b5fa5c5710ea1b1a7b691acdc48a4138";
//		System.out.println( decrypt(passws) ) ;
//		
//		String passwms="1910ad40059453eac041b98ebb3a5c6d";
//		System.out.println( decrypt(passwms) ) ;
		
		
//		String password="b5fa5c5710ea1b1a7b691acdc48a4138";
//		System.out.println( encrypt(password) ) ;
//		String  d="d9c724f6efbc62a23517e8f2952e81dbadc6db14949454024fb31ac0a1576bca3d3afaccb6c3e50ecf371afc3751336e0fb67a7c6590a0c37571010fc90bfbbb3bd16df4ed182a6c9f8b5ad6f12349b6f184b3a89a086769f648654c281c6f0f9e71dc3ba03279671d36af86e0cd552fbaa7804b5de5dc6870e8e9c20932156690edf1ff7a3b6c266311158dc40ff73d";
//		System.out.println( decrypt(d) ) ;
		
//		String username = "root" ;
//		System.out.println( encrypt(username) ) ;
//		
//		String password = "yg8uJzKV7onshHJl" ;
//		System.out.println( encrypt(password) ) ;
	}
	
	
}
