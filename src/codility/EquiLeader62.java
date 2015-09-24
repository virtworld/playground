package codility;
import java.util.Stack;

public class EquiLeader62 {

	public EquiLeader62() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
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
            return 0;  
        }else{
            int c = s.peek(); // leader
            int counter = 0;
            int half = A.length / 2;
            
            for(int i = 0; i < A.length; i++){
                if( A[i] == c){
                    counter++;
                }
            }
            
            if( counter <= half)
                return 0;
            
            int lLeader = 0;
            int rLeader = counter;
            int equiLeader = 0;
            
            for( int i = 0; i < A.length - 1; i++){
                if( A[i] == c){
                    lLeader++;
                    rLeader--;
                }
                
                if( lLeader > (i + 1) / 2 && rLeader > (A.length - i - 1) / 2){
                    equiLeader++;
                }
            }
            
            return equiLeader;
        }
    }
}
