package codility;
import java.util.ArrayList;
import java.util.Collections;

//https://codility.com/demo/results/demoDUNVSC-8W7/
public class MaxProductOfThree41 {

	public static void main(String... args)
	{
		new MaxProductOfThree41();
	}
	
	public MaxProductOfThree41() {
		// TODO Auto-generated constructor stub
		int[] arr = new int[]{-3, 1, 2, -2, 5, 6};
		System.out.println(solution(arr));
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> arrAbs = new ArrayList<Integer>();
        
        for(int i = 0; i < A.length; i++){
            arr.add( A[i]); // n
            arrAbs.add( Math.abs(A[i]));
        }
        
        Collections.sort(arr); // n log n
        
        Collections.sort(arrAbs); // n log n
        
        int threePos = 0;
        int twoNegOnePos = 0;
        
        if(arr.get(A.length - 1) > 0 && arr.get(A.length - 2) > 0 && arr.get(A.length - 3) > 0){
            threePos = arr.get(A.length - 1) * arr.get(A.length - 2) * arr.get(A.length - 3);
        }
        
        if(arr.get(A.length - 1) > 0 && arr.get(0) < 0 && arr.get(1) < 0){
            twoNegOnePos = arr.get(0) * arr.get(1) * arr.get(A.length - 1);   
        }
        
        if( threePos != 0 || twoNegOnePos != 0){
            return (threePos > twoNegOnePos) ? threePos : twoNegOnePos;
        }else{
            return -(arrAbs.get(0) * arrAbs.get(1) * arrAbs.get(2));
        }
        
        
    }
}
