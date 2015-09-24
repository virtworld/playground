package LeetCode;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		System.out.println( reverseWords(s));
	}

	static public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        String str = s.trim();
        while(str.compareTo("") != 0){
            int end = str.length() - 1;
            int start = end;
            
            while(str.charAt(start) != ' ' && start-- != 0){}
            
            sb.append(str.substring(start + 1, end + 1));
            sb.append(" ");
            str = str.substring(0, start + 1).trim();
        }
        return sb.toString().trim();
    }
}
