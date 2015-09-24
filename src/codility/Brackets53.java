package codility;
import java.util.Stack;

public class Brackets53 {

	public Brackets53() {
		// TODO Auto-generated constructor stub
	}

	public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> s = new Stack<Character>();
        
        int length = S.length();
        
        for(int i = 0; i < length; i++){
            char c = S.charAt(i);
            
            if(s.empty()){
                s.push(c);   
            }else{
                char topChar = s.peek();
                switch(c){
                    case ')':
                        if(topChar == '('){
                            s.pop();   
                        }else{
                            s.push(c);   
                        }
                        break;
                    case ']':
                        if(topChar == '['){
                            s.pop();   
                        }else{
                            s.push(c);   
                        }
                        break;
                    case '}':
                        if(topChar == '{'){
                            s.pop();   
                        }else{
                            s.push(c);   
                        }
                        break;
                    default:
                        s.push(c);
                }
            }
        }
        return s.empty() ? 1 : 0;
    }
}
