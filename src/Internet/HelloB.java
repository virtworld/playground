package Internet;

public class HelloB extends HelloA {
	
	public HelloB() {
		System.out.println("Constructing hello B");
	}

	{
		System.out.println("I'm B class");
	}
	
	static{
		System.out.println("static B");
	}
	
	public static void main(String[] args){
		
		HelloB b = new HelloB();
		HelloB c = new HelloB();
	}
}
