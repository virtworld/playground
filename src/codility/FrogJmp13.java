package codility;

public class FrogJmp13 {

	public FrogJmp13() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int dist = Y - X;
        
        int steps = dist / D;
        
        if(dist % D != 0) steps++;
        
        return steps;
    }
}
