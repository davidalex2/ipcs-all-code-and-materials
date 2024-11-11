public class Method11 {
	
	public static int value(int a) {
		return a*a;
	}
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
			int result = value(i);
			System.out.println(+i+" "+result);
		}
	}
	
}
		//with return types & with parameters