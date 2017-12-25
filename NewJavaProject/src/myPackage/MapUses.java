package myPackage;

import java.util.HashMap;

public class MapUses {

	public static void main(String[] args) {
		HashMap<Integer, String> dataMap = new HashMap<Integer, String>();
		System.out.println(dataMap);
		System.out.println(dataMap.isEmpty());
		dataMap.put(6, "Saddam");
		dataMap.put(2, "Hossain");
		dataMap.put(3, "Banu");
		dataMap.put(4, "Sajra");
		dataMap.put(8, "Java");
		dataMap.put(7, "Saddam Hossain");
		dataMap.put(5, "Selenium");
		dataMap.put(1, "Sajra Banu");
		System.out.println(dataMap.size());
		System.out.println(dataMap);
		System.out.println(dataMap.isEmpty());
		System.out.println(dataMap.containsValue("Sajra Banu"));
		System.out.println(dataMap.get(7));
		System.out.println(dataMap.remove(5));
		System.out.println(dataMap);
		System.out.println(dataMap.values());
		System.out.println(dataMap.entrySet());
		System.out.println(dataMap.keySet());
		System.out.println(dataMap.put(5, "Map"));
		System.out.println(dataMap.keySet());
		System.out.println(dataMap.replace(8, "Oracle"));
		System.out.println(dataMap.entrySet());
		System.out.println(dataMap.replace(4, "SAJRA"));
		System.out.println(dataMap.entrySet());
		dataMap.clear();
		System.out.println(dataMap.isEmpty());
	}
}