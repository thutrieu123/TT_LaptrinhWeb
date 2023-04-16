package api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



public class LogicticAPI {
	
	private final String email = "phuong@1234";
	private final String password ="12345";
	
	
	public static String login(String userName,String password) throws IOException {
		URL url = new URL("http://140.238.54.136/api/auth/login?email="+userName+"&password="+password);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.connect();
		  String inline = "";

		//Getting the response code
		int responsecode = conn.getResponseCode();
		
		if (responsecode != 200) {
		    throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
		  
		  
		    Scanner scanner = new Scanner(conn.getInputStream());
		  
		   //Write all the JSON data into a string using a scanner
		    while (scanner.hasNext()) {
		       inline += scanner.nextLine();
		    }
		    
		    //Close the scanner
		    scanner.close();

//		    //Using the JSON simple library parse the string into a json object
//		    JSONParser parse = new JSONParser(inline);

		    //Get the required data using its key
		}
		String access_token = "";
		if(!inline.equals("")) {
			Object obj = JSONValue.parse(inline);
	        JSONObject jsonObject = (JSONObject) obj;
	       access_token = (String) jsonObject.get("access_token");
		}
		
		
		return access_token;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(login("phuong@1234", "123456"));
	}
	

}
