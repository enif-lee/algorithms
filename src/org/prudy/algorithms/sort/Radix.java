package org.prudy.algorithms.sort;


/**
 * @author Lee Jinseoung
 * @date 2016.07.14
 * 
 * Radix Sort
 */
public class Radix {
	
	public static void main(String[] args) {
		int[] result = sort(new int[]{42, 2, 3, 11});
		for(int number : result) System.out.println(number);
	}
	
	
	/**
	 * @param array
	 * @return sorted array
	 */
	public static int[] sort(int[] array) {		
		final int MAX_LENGTH = Radix.getMaxLength(array), ARRAY_LENGTH = array.length;
		int powed = 1;
		int[] sortedArray = new int[ARRAY_LENGTH], counts;
		
		for(int p = 0; p < MAX_LENGTH; p++){
			counts = new int[10];
			
			for(int number : array){
				counts[(number/powed) % 10]++;
			}
			
			for(int i = 1; i < 10; i++ ) counts[i] += counts[i-1];
			
			for(int i = ARRAY_LENGTH-1; i >= 0; i--){
				sortedArray[counts[(array[i]/powed) %10]-- -1] = array[i];
			}

			array = sortedArray;
			sortedArray = new int[ARRAY_LENGTH];
			powed *= 10;
		}
		
		return array;
	}
	
	
	/**
	 * @param array
	 * @return maxLength
	 */
	public static int getMaxLength (int[] array) {
		int powed = 1;
		for(int number : array){
			while(number/powed > 10){
				powed*=10;
			}
		}
		return (int)Math.log10((double)powed)+1;
	}
}
