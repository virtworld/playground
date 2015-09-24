package LeetCode;

import java.util.ArrayList;
import java.util.List;


public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = generate(10);
	}
	
	static public List<List<Integer>> generate(int numRows) {
        // need for special case 1 and 2
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>();
        List<Integer> row2 = new ArrayList<Integer>();
        row1.add(1);
        row2.add(1);
        row2.add(1);
        if(numRows == 0) return res;
        res.add(row1);
        if(numRows == 1) return res;
        res.add(row2);
        if(numRows == 2) return res;
        
        for(int i = 3; i <= numRows; i++){
        	ArrayList<Integer> row = new ArrayList<Integer>();    
            row.add(1);
            for(int j = 1; j < i - 1; j++){
                row.add(row2.get(j) + row2.get(j - 1));
            }
            row.add(1);
            res.add(row);
            row2 = row;
        }
		return res;
    }
}
