package DynamicProgramming;


public class Fabonacci {
	
	public static int FABONACCI_MAX = 40;
	
	public static void main(String[] args){
		
		long timeStart = System.nanoTime();
		long res = recursiveFabonacci( FABONACCI_MAX);
		long timeEnd = System.nanoTime();
		System.out.printf("Recursive Fabonacci: %d, using %.10f\n", res, (timeEnd - timeStart) / Math.pow(10, 9));
		
		timeStart = System.nanoTime();
		res = dpFabonacii(FABONACCI_MAX);
		timeEnd = System.nanoTime();
		System.out.printf("DP Fabonacci:  %d, using %.10f\n", res, (timeEnd - timeStart) / Math.pow(10, 9));
		
		timeStart = System.nanoTime();
		res = optDpFabonacii(FABONACCI_MAX);
		timeEnd = System.nanoTime();
		System.out.printf("OPT DP Fabonacci:  %d, using %.10f\n", res, (timeEnd - timeStart) / Math.pow(10, 9));
	}
	
	public static long recursiveFabonacci(int n){
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return recursiveFabonacci(n - 2) + recursiveFabonacci(n - 1); 
	}
	
	public static long dpFabonacii(int n){
		
		long[] fabonacii = new long[n + 1];
		fabonacii[0] = 0;
		fabonacii[1] = 1;
			
		for(int i = 2; i <= n; i++){
			fabonacii[i] = fabonacii[i - 2] + fabonacii[i - 1];
		}
		
		return fabonacii[n];
	}
	
	public static long optDpFabonacii(int n){
		
		long  backTwo = 0;
		long backOne = 1;
		
		for(int i = 2; i <= n; i++){
			long temp = backTwo + backOne;
			backTwo = backOne;
			backOne = temp;
		}
		
		return backOne;
	}
}
