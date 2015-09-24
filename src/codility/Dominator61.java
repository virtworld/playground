package codility;
import java.util.Stack;

//https://codility.com/demo/results/demo6X3GWG-KFW/
public class Dominator61 {

	public Dominator61() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i = 0; i < A.length; i++){
            
            if( s.empty()){
                s.push( A[i]);   
            }else{
                if( s.peek() != A[i]){
                    s.pop();   
                }else{
                    s.push( A[i]);   
                }
            }
        }
        
        if( s.empty()){
            return -1;   
        }else{
            int c = s.peek();
            int counter = 0;
            int index = 0;
            int half = A.length / 2;
            
            for(int i = 0; i < A.length; i++){
                if( A[i] == c){
                    counter++;
                    index = i;
                }
            }
            
            return (counter > half) ? index : -1;
        
        }
    }
}
