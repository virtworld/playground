package adsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert; 
import org.junit.Test;

import ads.Sorts;


public class SortsTest {

	public static final int TEST_CASE = 10;
	public static final int ARRAY_SIZE = 1000;
	public static final int RANGE = 1000;
	
	@Test
	public void testQuickSort() {
		
		Random random = new Random();
	
		for(int tc = 0; tc < TEST_CASE; tc++){
			int[] array1 = new int[ARRAY_SIZE];
			Integer[] array2 = new Integer[ARRAY_SIZE];
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int nextInt = random.nextInt(RANGE);
				array2[i] = array1[i] = nextInt;
			}
			
			Arrays.sort(array1);
			Sorts.quickSort(array2);
			
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				
				Assert.assertEquals(array1[i], array2[i].intValue());
			}	
		}
	}
	
	@Test
	public void testMergeSort() {
		
		Random random = new Random();
		
		for(int tc = 0; tc < TEST_CASE; tc++){
			List<Integer> arr1 = new ArrayList<Integer>();
			List<Integer> arr2 = new ArrayList<Integer>();
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int v = random.nextInt(RANGE);
				arr1.add( v);
				arr2.add( v);
			}
			
			Collections.sort(arr1);
			arr2 = Sorts.mergeSort(arr2);
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				
				Assert.assertEquals( arr1.get(i).intValue(), arr2.get(i).intValue());
			}	
		}
	}
	
	@Test
	public void testCountingSort(){
		
		Random random = new Random();
		
		for(int tc = 0; tc < TEST_CASE; tc++){
			int[] array1 = new int[ARRAY_SIZE];
			int[] array2 = new int[ARRAY_SIZE];
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int v = random.nextInt(RANGE);
				array1[i] = array2[i] = v;
			}
			
			Arrays.sort(array1);
			array2 = Sorts.countingSort(array2, RANGE);
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				Assert.assertEquals( array1[i], array2[i]);
			}	
		}
	}
	
	@Test
	public void testRadixSort(){
		
		Random random = new Random();
		
		for(int tc = 0; tc < TEST_CASE; tc++){
			int[] array1 = new int[ARRAY_SIZE];
			int[] array2 = new int[ARRAY_SIZE];
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int v = random.nextInt(RANGE);
				array1[i] = array2[i] = v;
			}
			
			Arrays.sort(array1);
			Sorts.radixSort(array2);
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				Assert.assertEquals( array1[i], array2[i]);
			}	
		}
	}
	
	@Test
	public void testInsertionSort(){
		Random random = new Random();
		
		for(int tc = 0; tc < TEST_CASE; tc++){
			List<Integer> arr1 = new ArrayList<Integer>();
			List<Integer> arr2 = new ArrayList<Integer>();
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int v = random.nextInt(RANGE);
				arr1.add( v);
				arr2.add( v);
			}
			
			Collections.sort(arr1);
			Sorts.insertionSort(arr2);
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				
				Assert.assertEquals( arr1.get(i).intValue(), arr2.get(i).intValue());
			}	
		}
	}

	@Test
	public void testSelectionSort(){
		Random random = new Random();
		
		for(int tc = 0; tc < TEST_CASE; tc++){
			List<Integer> arr1 = new ArrayList<Integer>();
			List<Integer> arr2 = new ArrayList<Integer>();
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int v = random.nextInt(RANGE);
				arr1.add( v);
				arr2.add( v);
			}
			
			Collections.sort(arr1);
			Sorts.selectionSort(arr2, true);
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				
				//System.out.println(arr1.get(i).intValue() + " "+  arr2.get(i).intValue());
				Assert.assertEquals( arr1.get(i).intValue(), arr2.get(i).intValue());
			}	
		}
	}
}
