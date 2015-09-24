package DivideAndConquer;

public class Power {

	public static void main(String... args){
		
		long time = System.nanoTime();
		System.out.println(powerRec(1.0000001, 1000000));
		System.out.printf("Time: %f", (System.nanoTime() - time) / Math.pow(10, 9));
		System.out.println();
		
		time = System.nanoTime();
		System.out.println(powerIte(1.0000001, 1000000));
		System.out.printf("Time: %f", (System.nanoTime() - time) / Math.pow(10, 9));
		System.out.println();
		
		time = System.nanoTime();
		System.out.println(pow1(1.0000001, 1000000));
		System.out.printf("Time: %f", (System.nanoTime() - time) / Math.pow(10, 9));
		System.out.println();
		
		time = System.nanoTime();
		System.out.println(Math.pow(1.0000001, 1000000));
		System.out.printf("Time: %f", (System.nanoTime() - time) / Math.pow(10, 9));
		System.out.println();
	}
	
	public static double powerRec(double a, int n){
	
		if(n == 0) return 1;
		double x = powerRec(a, n/2);
		if(n % 2 == 0) return x * x; else return a * x * x;
				
	}
	
	public static double powerIte(double a, int n){

		double x = 1;
		for(int i = 0; i < n; i++){
			x *= a;
		}
		return x;
	}
	
	public static double pow1(double a, int b){
        //check the validity of a and b
        if(a == 0 && b == 0)
            return Integer.MIN_VALUE;
        
        if(a == 0)
            return 0;

        if(b == 0)
            return 1;
        
        if(b == 1)
            return a;

        boolean aMinus = a < 0? true: false;
        boolean bMinus = b < 0? true : false;

        int bAbs = Math.abs(b);
        double aAbs = Math.abs(a);
        
        //check if b is odd
        double tempAnswer;
        if( (b & 1) != 0){
            tempAnswer = pow1(aAbs, bAbs - 1) * aAbs;
        }
        else{
            tempAnswer = pow1(aAbs * aAbs, bAbs / 2);
        }

        if(bMinus)
            tempAnswer = 1.0 / tempAnswer;
        if(aMinus && (b&1)!= 0)
            tempAnswer *= -1;

        return tempAnswer;

    }
}
