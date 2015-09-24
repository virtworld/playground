package LeetCode;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Write a function that takes an unsigned integer and returns the number of 鈥�1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer 鈥�11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author Jiaqi Li
 *
 */
public class HammingWeight {

	public static void main(String[] args) {
		
		System.out.println(hammingWeight(10));
	}

	public static int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        
        for(int i = 0; i < str.length(); i++){
            if( str.charAt(i) == '1') count++;
        }
        
        return count;
    }
}

