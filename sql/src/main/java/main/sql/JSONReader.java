package main.sql;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import com.google.gson.Gson;


public class JSONReader {
	public static String[] convertJSON (String json) {
		Gson parser = new Gson();
		//JsonParser to convert JSON string into Json Object
/*
		String toReturn[] = new String[20];
		
		Object obj = json;
		//parsing the JSON string inside the file that we created earlier.

		Object jsonObject = obj;
		System.out.println(jsonObject);
		//Json string has been converted into JSONObject

		String deviceId = (String) jsonObject.get("EUI");
		System.out.println(deviceId);
		toReturn[0] = deviceId;

		String data = (String) jsonObject.get("data?");
		System.out.println(data);
		toReturn[1] = data;
		//Displaying values from JSON OBject by using Keys
		
		
		return toReturn;*/
		
		String[] str = parser.fromJson(json, String[].class);
		return str;
		
		// String toRetrun = hexToDecimal(str);
		// 
		}
}
