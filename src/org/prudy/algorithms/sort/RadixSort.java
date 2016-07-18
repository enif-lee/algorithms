package org.prudy.algorithms.sort;


/**
 * @author Lee Jinseoung
 * @date 2016.07.14
 * 
 * Radix Sort
 * 
 * [ 설명 ]
 * Radix(기수)는 숫자의 자릿수를 의미
 * 각 Radix 별로 정렬을 진행하여, Radix sort라고하며 아래에는 각 기수별로 계수정렬(counting sort)함.
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
		final int MAX_LENGTH = this.getMaxLength(array),	// 가장 큰 값의 자릿 수의 개수를 구해줌, 예를 들어 999 -> 3, 80 -> 2
				ARRAY_LENGTH = array.length;				// Array의 Length 값
		int powed = 1;	// 해당 자릿수를 가져오기 위해 위치 값 계산, (N/10^(k-1))%10 = N의 k번째 숫자, 이 수식에서 10^(k-1) 부분의 누적에 해당함
		int[] sortedArray = new int[ARRAY_LENGTH], counts;
		
		for(int p = 0; p < MAX_LENGTH; p++){
			// 아래는 계수정렬 방식으로 진행
			counts = new int[10];
			
			for(int number : array){
				counts[(number/powed) % 10]++;
			}
			
			for(int i = 1; i < 10; i++ ){
				counts[i] += counts[i-1];
			}
			
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
