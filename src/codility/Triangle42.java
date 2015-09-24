package codility;
import java.util.ArrayList;
import java.util.Collections;

//https://codility.com/demo/results/demo37MTXR-KMY/
public class Triangle42 {

	public Triangle42() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        ArrayList<Long> sorted = new ArrayList<Long>();
        
        for(int i = 0; i < A.length; i++){
            sorted.add( (long)A[i]);   
        }
        
        Collections.sort( sorted);
        
        for(int i = 0; i <A.length - 2; i++){
            long a = sorted.get(i);   
            long b = sorted.get(i + 1);
            long c = sorted.get(i + 2);
            
            if( a + b > c &&
                b + c > a &&
                a + c > b){
                return 1;        
            }
        }
        
        return 0;
    }
}
