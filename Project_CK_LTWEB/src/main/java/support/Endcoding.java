package support;

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
	

}
