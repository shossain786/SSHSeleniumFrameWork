package myPackage;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {

	static long n = (long) 1E7;
	
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		long mills = System.currentTimeMillis();
		for(int i=0; i<n; i++) {
			arrayList.add(i);
		}
		System.out.println("Insertion into arrayList time taken "+(System.currentTimeMillis()-mills));
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		mills = System.currentTimeMillis();
		for(int i=0; i<n; i++) {
			linkedList.add(i);
		}
		System.out.println("Insertion into linkedList time taken "+(System.currentTimeMillis()-mills));
		
		//testing the time taken for element deletion
		mills = System.currentTimeMillis();
		arrayList.remove(0);
		System.out.println("Deletion from arrayList time taken "+(System.currentTimeMillis()-mills));
		
		mills = System.currentTimeMillis();
		linkedList.remove(0);
		System.out.println("Deletion from linkedList time taken "+(System.currentTimeMillis()-mills));
		
		//Checking element retrieval from arrayList and linkedList
		mills = System.currentTimeMillis();
		arrayList.get((int)n/2);
		System.out.println("Retriving from arrayList time taken "+(System.currentTimeMillis()-mills));
		
		mills = System.currentTimeMillis();
		linkedList.get((int)n/2);
		System.out.println("Retriving from linkedList time taken "+(System.currentTimeMillis()-mills));
		
	}
}
