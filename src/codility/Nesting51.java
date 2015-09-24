package codility;

import java.util.Stack;
/**
 * 
 * A string S consisting of N characters is called properly nested if:
 *  S is empty;
 *  S has the form "(U)" where U is a properly nested string;
 *  S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * Write a function:
 *   class Solution { public int solution(String S); }
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 * Assume that:
 *  N is an integer within the range [0..1,000,000];
 *  string S consists only of the characters "(" and/or ")".
 * Complexity:
 *  expected worst-case time complexity is O(N);
 *  expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 * Copyright 2009¨C2015 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 *
 */
public class Nesting51 {

	public Nesting51() {
		// TODO Auto-generated constructor stub
	}

    public int solution(String S) {
        
        Stack<Character> s = new Stack<Character>();
        
        for(int i = 0; i < S.length(); i++){
            
            char current = S.charAt(i);
            
            if(!s.empty()){
                char top = s.peek();
            
                if(top == '(' && current == ')'){
                   s.pop();
                }else{
                   s.push(current);   
                }
            }else{
                s.push(current);
            }
        }
        
        return (s.empty()) ? 1 : 0;
    }
    
    public int solution2(String S) {
        
        Stack<Character> stack = new Stack<Character>();
        
        int length = S.length();
        
        for(int i = 0; i < length; i++){
             char curr = S.charAt(i);
             if(curr == '('){
                stack.push(curr);           
             }else{
                 if(stack.empty()){
                    stack.push(curr);   
                 }else{
                    if( stack.peek() == '('){
                        stack.pop();   
                    }else{
                        stack.push(curr);   
                    }
                 }
             }
        }
        
        return stack.empty() ? 1 : 0;
    }
}
