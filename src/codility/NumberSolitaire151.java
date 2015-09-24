package codility;

//https://codility.com/demo/results/demoJZW2AH-AVC/
public class NumberSolitaire151 {

	public NumberSolitaire151() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        
        int[] utilities = new int[n];
        
        utilities[0] = A[0];
        if(n == 1) return utilities[0];
        
        utilities[1] = utilities[0] + A[1];
        if(n == 2) return utilities[1];
        
        int u0r2 = utilities[0] + A[2];
        int u1r2 = utilities[1] + A[2];
        utilities[2] = u0r2 > u1r2 ? u0r2 : u1r2;
        if(n == 3) return utilities[2];
        
        int[] candidate3 = new int[3];
        candidate3[0] = utilities[0] + A[3];
        candidate3[1] = utilities[1] + A[3];
        candidate3[2] = utilities[2] + A[3];
        utilities[3] = max(candidate3);
        if(n == 4) return utilities[3];
        
        int[] candidate4 = new int[4];
        candidate4[0] = utilities[0] + A[4];
        candidate4[1] = utilities[1] + A[4];
        candidate4[2] = utilities[2] + A[4];
        candidate4[3] = utilities[3] + A[4];
        utilities[4] = max(candidate4);
        if(n == 5) return utilities[4];
        
        int[] candidate5 = new int[5];
        candidate5[0] = utilities[0] + A[5];
        candidate5[1] = utilities[1] + A[5];
        candidate5[2] = utilities[2] + A[5];
        candidate5[3] = utilities[3] + A[5];
        candidate5[4] = utilities[4] + A[5];
        utilities[5] = max(candidate5);
        if(n == 6) return utilities[5];
        
        for(int i = 6; i <= n - 1; i++){
            int[] candidateI = new int[6];
            candidateI[0] = utilities[i - 1] + A[i];
            candidateI[1] = utilities[i - 2] + A[i];
            candidateI[2] = utilities[i - 3] + A[i];
            candidateI[3] = utilities[i - 4] + A[i];
            candidateI[4] = utilities[i - 5] + A[i];
            candidateI[5] = utilities[i - 6] + A[i];
            utilities[i] = max(candidateI);   
        }
        
        return utilities[n - 1];
    }
    
    public int max(int[] numbers){
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++){
            if( numbers[i] > max){
                max = numbers[i];   
            }
        }
        
        return max;
    }
}
