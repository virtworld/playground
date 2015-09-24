package ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Sorts {

	public Sorts() {
		// TODO Auto-generated constructor stub
	}


	public static <T extends Comparable<? super T>> void quickSort(T[] arr){
		quickSort( Arrays.asList(arr));
	}
	
	public static <T extends Comparable<? super T>> void quickSort(List<T> arr){
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
