package myPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorUse {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Saddam");
		arrayList.add("Hossain");
		arrayList.add("Saddam");
		arrayList.add("Sajra");
		arrayList.add("Banu");
		System.out.println(arrayList.size());
		//use iterator
		Iterator<String> iterator = arrayList.listIterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());

		System.out.println(arrayList.get(3));
	}
}
