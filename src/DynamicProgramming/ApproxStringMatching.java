package DynamicProgramming;
 
public class ApproxStringMatching {
 
	private static String pattern = "Thou shalt not";
	private static String text = "You should not";
    
	private static int[][] matrix = new int[pattern.length() + 1][text.length() + 1];
	
    public static void main(String... args){
        
        
        long startTime = System.nanoTime();
        System.out.println(editDistanceByRecursion(pattern, text));
        System.out.println("Time taken: " + (System.nanoTime() - startTime) / Math.pow(10, 9) + " seconds");
        
        startTime = System.nanoTime();
        System.out.println(editDistanceByDP(pattern, text));
        System.out.println("Time taken: " + (System.nanoTime() - startTime) / Math.pow(10, 9) + " seconds");
        
    }
 
    /**
     * D(P|x, T|y) = D(P, T) if x = y      // Matching <br />
     *             = D(P, T) + 1 otherwise // Substitution <br />
     * D(P|x, T|y) = D(P, T|y) + 1         // P has x inserted <br />
     * D(P|x, T|y) = D(P|x, T) + 1         // P has x deleted <br />            
     * @param p
     * @param t
     * @return
     */
    public static int editDistanceByRecursion(String p, String t){
         
        int[] cost = new int[3];
         
        if(p.length() == 0) return t.length() * costInsertOrDelete(' ');
        if(t.length() == 0) return p.length() * costInsertOrDelete(' ');
         
        cost[0] = editDistanceByRecursion(p.substring(0, p.length() - 1), t.substring(0,  t.length() - 1)) +
                costMacthOrSubstitution(p.charAt(p.length() - 1), t.charAt(t.length() - 1));
        
        cost[1] = editDistanceByRecursion(p.substring(0, p.length() - 1), t) + 
                costInsertOrDelete(p.charAt(p.length() - 1));
        
        cost[2] = editDistanceByRecursion(p, t.substring(0, t.length() - 1)) +
                costInsertOrDelete(t.charAt(t.length() - 1));
         
        int lowestCost = cost[0];
        for(int i = 1; i < 3; i++){
            if(cost[i] < lowestCost) lowestCost = cost[i];
        }
         
        //System.out.println(cost[0] + " " + cost[1] + " " + cost[2]);
        return lowestCost;
    }
     
    public static int editDistanceByDP(String p, String t){
    
    	// Initialize matrix
    	for(int i = 0; i < pattern.length(); i++){
    		matrix[i][0] = i;
    	}
    	
    	for(int i = 0; i < text.length(); i++){
    		matrix[0][i] = i;
    	}
    	
    	int lenP = p.length();
    	int lenT = t.length();
    	
    	for(int i = 1; i <= lenP; i++){
    		for(int j = 1; j <= lenT; j++){
    			int cost[] = new int[3];
    			cost[0] = matrix[i - 1][j - 1] + costMacthOrSubstitution(p.charAt(i - 1), t.charAt(j - 1));
    			cost[1] = matrix[i - 1][j] + costInsertOrDelete(p.charAt(i - 1));
    			cost[2] = matrix[i][j - 1] + costInsertOrDelete(t.charAt(j - 1));
    			
    			int lowest = cost[0];
    			if(cost[1] < lowest) lowest = cost[1];
    			if(cost[2] < lowest) lowest = cost[2];
    			
    			matrix[i][j] = lowest;
    		}
    	}
    	
//    	for(int i = 0; i < lenP + 1; i++){
//    		for(int j = 0; j < lenT + 1; j++){
//    			System.out.print(matrix[i][j] + "\t");
//    		}
//    		System.out.println();
//    	}
    	
    	return matrix[lenP][lenT];
    }
    
    public static int costMacthOrSubstitution(char p, char t){
         
        if(p == t) return 0; else return 1;
    }
     
    public static int costInsertOrDelete(char c){
        return 1;
    }
}