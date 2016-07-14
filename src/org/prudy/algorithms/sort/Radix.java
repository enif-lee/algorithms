package org.prudy.algorithms.sort;


/**
 * @author Lee Jinseoung
 * @date 2016.07.14
 * 
 * Radix Sort
 */
public class Radix {
	
	public static void main(String[] args) {
		int[] result = sort(new int[]{42, 2, 3, 11}, 10);
		for(int number : result) System.out.println(number);
	}
	
	
	/**
	 * @param array 정렬할 배열
	 * @param radix 기수
	 * @return sorted array
	 */
	public static int[] sort(int[] array, int radix) {		
		final int MAX_LENGTH = Radix.getMaxLength(array, radix), ARRAY_LENGTH = array.length, RADIX = radix;
		int powed = 1;
		int[] sortedArray = new int[ARRAY_LENGTH], counts;
		
		for(int p = 0; p < MAX_LENGTH; p++){
			counts = new int[RADIX];
			
			for(int number : array){
				counts[(number/powed) % RADIX]++;
			}
			
			for(int i = 1; i < RADIX; i++ ) counts[i] += counts[i-1];
			
			for(int i = ARRAY_LENGTH-1; i >= 0; i--){
				sortedArray[counts[(array[i]/powed) %RADIX]-- -1] = array[i];
			}

			array = sortedArray;
			sortedArray = new int[ARRAY_LENGTH];
			powed *= radix;
		}
		
		return array;
	}
	
	
	/**
	 * @param array 검색할 배열
	 * @param radix 기수
	 * @return 최대 길이
	 */
	public static int getMaxLength (int[] array, int radix) {
		int maxCount = 1;
		
		for(int number : array){
			int count = 1;
			while(number > 10){
				number /= 10;
				count ++;
			}	
			if(count > maxCount) maxCount = count;
		}
		
		return maxCount;
	}
}
