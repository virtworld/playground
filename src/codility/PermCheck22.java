package codility;
import java.util.HashSet;
public class PermCheck22 {

	public PermCheck22() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();
        int n = A.length;
        
        for(int i = 0; i < n; i++){
            if(A[i] > n)
                return 0; 
            if(!set.add(A[i]))
                return 0; // found duplicate element;
        }
        
        if(set.size() != n)
            return 0; // some elements are missing;
            
        return 1;
    }
}
