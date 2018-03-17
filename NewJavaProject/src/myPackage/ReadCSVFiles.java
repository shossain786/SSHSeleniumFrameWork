package myPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadCSVFiles {

	static HashMap<String, String> dataMap;
	private static String filePath;
	public static void main(String[] args) {
		filePath= System.getProperty("user.dir")+"/EmpDetails.txt";
		ReadCSVFiles obj = new ReadCSVFiles();
		obj.readCSV();
	}
	public void readCSV() {
		
		BufferedReader bfr;
		HashMap<String, String> dataMap = new HashMap<String,String>();
		
		try {
			bfr = new BufferedReader(new FileReader(filePath));
			String line = bfr.readLine();
			while(line!=null) {
				String[] userDetails = line.split(",");
				dataMap.put(userDetails[1], userDetails[0]);
				line = bfr.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		System.out.println("End of new Function.");
		System.out.println(dataMap.entrySet());
	}
}
