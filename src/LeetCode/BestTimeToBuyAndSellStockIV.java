package LeetCode;

// WRONG
public class BestTimeToBuyAndSellStockIV {

	public static void main(String[] args) {
		
		int[] a = new int[]{6, 1, 3, 2, 4, 7};
		int k = 2;
		
		System.out.println( maxProfit(k, a));
	}

	public static int maxProfit(int k, int[] prices) {

		return help(k, 0, prices.length, prices);
	}

	public static int help(int k, int b0, int bn, int[] prices) {

		if (k < 0)
			return 0;
		if(bn <= b0)
			return 0;
		
		int lowestSoFar = Integer.MAX_VALUE;
		int lowestIndex = 0;
		int maxDiff = 0;

		int newBn1 = 0;
		int newB02 = 0;

		for (int i = b0; i < bn; i++) {
			if (prices[i] < lowestSoFar) {
				lowestSoFar = prices[i];
				lowestIndex = i;
				
			}

			int currDiff = prices[i] - lowestSoFar;

			if (currDiff > maxDiff) {
				maxDiff = currDiff;
				newB02 = i + 1;
				newBn1 = lowestIndex - 1;
			}
		}

		System.out.println(maxDiff + " " + newBn1 + " " + newB02);
		
		if (maxDiff == 0)
			return 0;

		if (k == 2)
			return maxDiff
					+ Math.max(help(k - 2, b0, newBn1, prices),
							help(k - 2, newB02, bn, prices));

		return maxDiff + help(k - 2, b0, newBn1, prices)
				+ help(k - 2, newB02, bn, prices);
	}
}
