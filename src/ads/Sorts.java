package ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorts {

	//***************************************************************
	//-------------------Quick Sort----------------------------------
	//***************************************************************
	
	/**
	 * QuickSort on an array of elements of type T that are subtype of Comparable<? extends T>
	 *  
	 * @param arr an array of elements of type T that are subtype of Comparable<? extends T> that to be sorted
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] arr){

		// List is backed by the array, changes on the list write through to the array.
		quickSort( Arrays.asList(arr));
	}
	
	/**
	 * QuickSort on a List of elements of type T that are subtype of Comparable<? extends T>
	 *  
	 * @param arr a List of elements of type T that are subtype of Comparable<? extends T> that to be sorted
	 */
	public static <T extends Comparable<? super T>> void quickSort(List<T> arr){
		
		// Add randomness to the input data
		Random random = new Random();
		Collections.swap(arr, random.nextInt(arr.size()), arr.size() - 1);
		
		quickSortHelp(arr, 0, arr.size() - 1);
		
	}
	
	private static <T extends Comparable<? super T>> void quickSortHelp(List<T> arr, int l, int h){
		if(l < h){
			int postion = partition(arr, l, h);
			quickSortHelp(arr, l, postion - 1);
			quickSortHelp(arr, postion + 1, h);
		}
	}
	
	private static <T extends Comparable<? super T>> int partition(List<T> arr, int l, int r){
		T pivot = arr.get(r);
		int swapFlag = l - 1;
		
		for(int i = l; i < r; i++){
			if( arr.get(i).compareTo(pivot) < 0){
				Collections.swap(arr, swapFlag + 1, i);
				swapFlag++;
			}
		}
		
		Collections.swap(arr, r, swapFlag + 1);
		return swapFlag + 1;
	}
	
	
	//***************************************************************
	//-------------------Merge Sort----------------------------------
	//***************************************************************
	
	/**
	 * Merge Sort on an array of objects
	 * 
	 * @param arr an array of objects to be sorted
	 * @return a list of sorted objects
	 */
	public static <T extends Comparable<? super T>> List<T> mergeSort(T[] arr){

		return mergeSort( Arrays.asList(arr));
	}
	
	/**
	 * Merge Sort on a list of objects 
	 * 
	 * @param arr a list of objects to be sorted
	 * @return a list of sorted objects
	 */
	public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> arr){
		
		if( arr.size() == 1){
			return arr;
		}
		
		int half = arr.size() / 2;
		
		List<T> firstSeg = new ArrayList<T>();
		List<T> secondSeg = new ArrayList<T>();
		
		for(int i = 0; i < half; i++){
			firstSeg.add( arr.get(i));
		}
		
		for(int i = half; i < arr.size(); i++){
			secondSeg.add( arr.get(i));
		}
		
		firstSeg = mergeSort(firstSeg);
		secondSeg = mergeSort(secondSeg);
		return mergeSortHelp(firstSeg, secondSeg);
	}
	
	private static <T extends Comparable<? super T>> List<T> mergeSortHelp(List<T> arr1, List<T> arr2){
		
		List<T> result = new ArrayList<T>(arr1.size() + arr2.size());
		
		int index1 = 0;
		int index2 = 0;
		
		while( index1 < arr1.size() && index2 < arr2.size()){
			if( arr1.get(index1).compareTo( arr2.get(index2)) <= 0){
				result.add( arr1.get(index1));
				index1++;
			}else{
				result.add( arr2.get(index2));
				index2++;
			}
		}
		
		while( index1 < arr1.size()){
			result.add( arr1.get(index1));
			index1++;
		}
		
		while( index2 < arr2.size()){
			result.add( arr2.get(index2));
			index2++;
		}

		return result;
	}

	//***************************************************************
	//-------------------Counting Sort-------------------------------
	//***************************************************************
	
	/**
	 * Counting Sort on an array of integers.
	 * @param arr an array to be sorted
	 * @param k the range of the input values must be [0, k)
	 * @return an sorted array.
	 */
	public static int[] countingSort(int[] arr, int k){
	
		int[] result = new int[arr.length];
		int[] count = new int[k];
		
		for (int i : arr) {
			count[i]++;
		}
		
		for(int i = 1; i < k; i++){
			count[i] = count[i] + count[i - 1];
		}
		
		for(int i = arr.length - 1; i >= 0; i--){
			result[ count[arr[i]] - 1] = arr[i];
			count[ arr[i]]--;
		}
		
		return result;
	}
	
	//***************************************************************
	//-------------------Radix Sort----------------------------------
	//***************************************************************
	
	/**
	 * Radix sort on an array of positive integers
	 * @param arr an array of positive integers
	 */
	public static void radixSort(int[] arr){
		
		// Get maximum number of digits
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = (i > max) ? i : max;
		}
		
		int maxNumberOfDigits = 0;
		while(max > 0){
			max /= 10;
			maxNumberOfDigits++;
		}
		
		int radix = 1;
		for(int d = 0; d < maxNumberOfDigits; d++){
			
			int[] count = new int[10];
			int[] results = new int[arr.length];
			
			for (int i : arr) { // number of each digit at d * radix position
				count[ i / radix % 10]++;
			}
			
			for(int i = 1; i < 10; i++){
				count[i] = count[i] + count[i - 1];
			}
			
			for( int i = arr.length - 1; i >= 0; i--){
				results[ count[ arr[ i] / radix % 10] - 1] = arr[i];
				count[ arr[ i] / radix % 10]--;
			}
			
			for (int i  = 0; i < arr.length; i++) {
				arr[i] = results[i];
			}
			
			radix *= 10;
		}
	}
	
	//***************************************************************
	//-------------------Insertion Sort------------------------------
	//***************************************************************
	
	/**
	 * Insertion sort on a list of comparable objects in ascending order
	 * @param list a list of comparable objects
	 */
	public static  <T extends Comparable<? super T>> void insertionSort(List<T> list){
		
		insertionSort(list, true);
	}
	
	/**
	 * Insertion sort on a list of comparable objects
	 * @param list a list of comparable objects
	 * @param ascending true if the list need to be sorted in ascending order, false otherwise
	 */
	public static  <T extends Comparable<? super T>> void insertionSort(List<T> list, boolean ascending)
	{
	    
	    for (int i = 1; i < list.size(); i++) 
			for(int j = i - 1; 
				j >= 0 && (ascending ? 
						  list.get(j).compareTo( list.get(j + 1)) > 0 : 
						  list.get(j).compareTo( list.get(j + 1)) < 0); 
				j--)
				Collections.swap(list, j, j + 1);
	}

}
