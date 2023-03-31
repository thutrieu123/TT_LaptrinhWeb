package support;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;




public class Endcoding {
	
	public String decodeEmail(String email) {
		String result = "";
		String[] split = email.split("@");
		for(int i = 0;i < 4;i++) {
			result += split[0].charAt(i);
		}
		result += "************@"+split[1];
		return result;
	}
	
	public static String encrypt(String str) {
		String salt = "adABDK*@asjdkasfl;sada";
		String result = null;
		str += str + salt;
		
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(encrypt("Anhphuong123"));
	}

}
