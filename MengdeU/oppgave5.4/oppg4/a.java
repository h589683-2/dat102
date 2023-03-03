package oppg4;

public class a {

	public static void main(String [] args) {
		int n = 100;
		System.out.println(a(n) + n);
		
	}
	
	public static int a(int n) {
		int res = 0;	
		for(int i = 1; i < n; i++) {
				res += i;
			}
			
		return res;
		
	}
	

}
