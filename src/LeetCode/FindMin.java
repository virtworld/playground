package LeetCode;


public class FindMin {

	public static void main(String[] args) {
		int[] b = new int[]{7, 8, 10, 15, 0, 1, 2, 3};
		int a = findMin(b);
		System.out.println(a);
	}

	public static int findMin(int[] num) {
        
        int left = 0;
        int right = num.length;
        
        int height = (int) (Math.log(num.length) / Math.log(2));
        
        int curr = num[0];
        System.out.println((int)((left + right) / 2));
        
        for(int i = 0; i < height; i++){
            if(curr < num[(int)((left + right) / 2)]){
                left = (int)(left + right) / 2 + 1;
                System.out.println("mid" + num[(int)((left + right) / 2)]);
            }else{
                right = (int)(left + right) / 2 - 1;
                System.out.println("mid" + num[(int)((left + right) / 2)]);
            }
            curr = num[(int)((left + right) / 2)];
            System.out.println(curr);
        }
        return curr;
    }
}
