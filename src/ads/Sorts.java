package ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorts {

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
}
