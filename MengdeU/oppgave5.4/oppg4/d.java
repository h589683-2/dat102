package oppg4;

public class d {

	public static void main(String [] args) {
		int n = 13;
		int a0 = 0;
		int a1 = 1;
		int f = 0;
		System.out.println("0: " + a0 + "\n---------");
		System.out.println("1: " + a1 + "\n---------");
		
		for(int i = 2; i <= n; i++ ) {
			f = a1 + a0;
			a0 = a1;
			a1 = f;
			System.out.println(i + ": " + a1 + "\n---------");
		}
		
	}
}
