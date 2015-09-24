package codility;

public class TapeEquilibrium11 {

	public TapeEquilibrium11() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        int min = Integer.MAX_VALUE;
        int n = A.length;
        
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < n; i++){
            rightSum += A[i];    
        }
        
        for(int p = 1; p < n; p++){
            leftSum += A[p - 1];
            rightSum -= A[p - 1];
            int current = Math.abs(leftSum - rightSum);
            if(current < min){
                min = current;   
            }
        }
        
        return min;
    }
}
