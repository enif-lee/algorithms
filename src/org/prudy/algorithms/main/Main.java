package org.prudy.algorithms.main;



/**
 * @version 1.0.0
 * @author Lee Jinseoung
 *
 */
public class Main {
	
	public static void main(String[] args) {
		int count = 1;
		int temp = 100;
		System.out.println(count);
		System.out.println(temp);
		for(int i = 0; i < temp  ; i+=1){
			System.out.printf("%d %d 100\n", i, i, temp-i);
		}
	}
}
