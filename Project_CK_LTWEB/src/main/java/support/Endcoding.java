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
	
	public static void main(String[] args) {
		String email = "phuongnguyen1120002@st.hcmuaf.edu.vn";
		
		Endcoding end = new Endcoding();
		System.out.println(end.decodeEmail(email));
	}

}
