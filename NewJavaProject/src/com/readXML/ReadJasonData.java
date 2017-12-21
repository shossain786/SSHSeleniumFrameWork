package com.readXML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJasonData {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\MDSaddam\\Pictures\\Userdata.json"));
			
			JSONObject jsonObj = (JSONObject) obj;
			System.out.println(jsonObj);
			
			String name = (String) jsonObj.get("name");
			System.out.println("Name: "+name);
			
			String age = (String) jsonObj.get("age");
			System.out.println("Age: "+age);
			
			@SuppressWarnings("unchecked")
			Map<Object,Object> empdetails = ((Map<Object, Object>)jsonObj.get("EmployeeDetails"));
			
			Iterator<Entry<Object, Object>> itr = empdetails.entrySet().iterator();
			
			while(itr.hasNext()) {
				Entry<Object, Object> pair = itr.next();
				System.out.println(pair.getKey()+":"+pair.getValue());
			}			
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(ParseException pe) {
			pe.printStackTrace();
		}
	}
}
