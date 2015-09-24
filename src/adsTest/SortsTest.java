package adsTest;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

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
			int[] array3 = new int[ARRAY_SIZE];
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				int nextInt = random.nextInt(RANGE);
				array3[i] = array2[i] = array1[i] = nextInt;
			}
			
			Arrays.sort(array1);
			ads.Sorts.quickSort(array2);
			
			for(int i = 0; i < ARRAY_SIZE; i++){
				assert array1[i] == array2[i] : 
					"QuickSort on List error: Elements at index " + i + " are not equal: expected " + array1[i] + " , got " + array2[i];
				assert array1[i] == array3[i] :
					"QuickSort on Array error: Elements at index " + i + " are not equal: expected " + array1[i] + " , got " + array2[i];
			}	
		}
	}

}
