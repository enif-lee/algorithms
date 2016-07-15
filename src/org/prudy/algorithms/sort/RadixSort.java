package org.prudy.algorithms.sort;


/**
 * @author Lee Jinseoung
 * @date 2016.07.14
 * 
 * Radix Sort
 */
public class RadixSort implements Sort{
	
	public static void main(String[] args) {
		int[] result = new RadixSort().sort(new int[]{42, 2, 3, 11});
		for(int number : result) System.out.println(number);
	}
	
	
	/**
	 * @param array
	 * @return sorted array
	 */
	public int[] sort(int[] array) {		
		final int MAX_LENGTH = this.getMaxLength(array), ARRAY_LENGTH = array.length;
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
	public int getMaxLength (int[] array) {
		int max = 0;
		for(int number : array){
			if(max < number) max = number;
		}
		return (int)Math.log10((double)max)+1;
	}
}
