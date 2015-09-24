package codility;

import java.util.HashSet;

public class PermMissingElem12 {

	public PermMissingElem12() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        int n = A.length;
        for(int i = 0; i < n; i++){
            set.add(A[i]);
        }
        
        for(int i = 1; i <= n+1; i++){
            if(!set.contains(i)) 
                return i;
        }
        
        return 0;
    }
}
