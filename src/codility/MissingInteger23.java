package codility;
import java.util.HashSet;
public class MissingInteger23 {

	public MissingInteger23() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < A.length; i++){
            if(A[i] > 0)
                set.add(A[i]);
        }
        
        for(int i = 1; i <= 100001; i++){
            if(!set.contains(i))
                return i;
        }
        
        return 1;
    }
}
