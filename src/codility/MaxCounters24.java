package codility;

public class MaxCounters24 {

	public MaxCounters24() {
		// TODO Auto-generated constructor stub
	}

	public int[] solution(int N, int[] A) {
	        // write your code in Java SE 8
	        int max = 0;
	        int batch = 0;
	        int M = A.length;
	        int[] counters = new int[N];
	        
	        for(int i = 0; i < M; i++){
	            if(A[i] == N + 1){
	                batch = max;
	            }else{
	                if(counters[A[i] - 1] < batch){
	                    counters[A[i] - 1] = batch + 1;   
	                }else{
	                    counters[A[i] - 1]++;   
	                }
	                
	                if(counters[A[i] - 1] > max)
	                    max = counters[A[i] - 1];
	            }
	        }
	        
	        for(int i = 0; i < N; i++){
	            if(counters[i] < batch){
	                counters[i] = batch;   
	            }
	        }
	        
	        return counters;
	    }
}
