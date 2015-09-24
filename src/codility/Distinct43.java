package codility;
import java.util.HashSet;
//https://codility.com/demo/results/demoVN7AXP-9Q7/
public class Distinct43 {

	public Distinct43() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        int counter = 0;
        
        for(int i = 0; i < A.length; i++){
            if(set.add(A[i])){
                counter++;
            }
        }
        
        return counter;
    }
}
