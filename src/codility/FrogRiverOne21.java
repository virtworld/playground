package codility;
import java.util.HashSet;
public class FrogRiverOne21 {

	public FrogRiverOne21() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int X, int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 1; i <= X; i++){
            set.add(i);   
        }
        
        for(int i = 0; i < A.length; i++){
            set.remove(A[i]);
            if(set.size() == 0)
                return i;
        }
        
        return -1;
    }
}
