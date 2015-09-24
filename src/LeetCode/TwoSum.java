package LeetCode;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author Jiaqi Li
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] { 0, 4, 3, 0 };
		System.out.println(twoSum(numbers, 0)[0] + " " + twoSum(numbers, 0)[1]);
		System.out.println(twoSumHashTable(numbers, 0)[0] + " " + twoSum(numbers, 0)[1]);
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			set.add(numbers[i]);
		}

		int[] ret = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			if (set.contains(target - numbers[i])) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[j] == target - numbers[i]) {
						
						ret[0] = i + 1;
						ret[1] = j + 1;
					}
				}
			}

		}
		return ret;
	}
	
	public static int[] twoSumHashTable(int[] numbers, int target) {
		
		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			hashTable.put(numbers[i], i);
		}
		
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			Integer index = hashTable.get(target - numbers[i]);
			if(index != null && index != i){
				if(i + 1 < index + 1){
					ret[0] = i + 1;
					ret[1] = index + 1;
				}else{
					ret[0] = index + 1;
					ret[1] = i + 1;
				}
			}
		}
		return ret; 
	}
}
